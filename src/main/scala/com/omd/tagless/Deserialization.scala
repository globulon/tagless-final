package com.omd.tagless

import scalaz.Scalaz._

import scala.util.{Success, Try}
/**
  * 2.3
  * The de-serialization problem
  */
trait Deserialization {
  protected type ErrMsg = String
  protected type SafeRead[+A] = Either[ErrMsg, A]

  private final def safeRead(s: String): SafeRead[Int] = Try(s.toInt) match {
    case Success(v) ⇒ Right(v)
    case _          ⇒ Left(s"""Read error $s""")
  }

  protected final def fromTree[R: ExpSYM]: Tree ⇒ SafeRead[R] = {
    case Node("Lit", List(Leaf(v)))     ⇒
      safeRead(v) map implicitly[ExpSYM[R]].lit
    case Node("Neg", List(t))           ⇒
      fromTree[R].apply(t) map implicitly[ExpSYM[R]].neg
    case Node("Add", List(left, right)) ⇒
      (fromTree[R].apply(left) |@| fromTree[R].apply(right)) { implicitly[ExpSYM[R]].add(_)(_) }
    case n                          ⇒
      Left(s"""Invalid tree $n""")
  }
}
