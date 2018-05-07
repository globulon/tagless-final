package com.omd.tagless

import org.scalatest.{MustMatchers, WordSpec}

final class DeserializationTest extends WordSpec with MustMatchers with Deserialization with Expressions {
  "de-serialization" should {
    "properly reuse dsl" in {
      eval(expression[Tree].tf1) must be (expected)
    }
  }

  "deserialization" should {
    "match expected expression" in {
      fromTree[Int].apply(expression[Tree].tf1) must be (Right(expression[Int].tf1))
      println(deserialize[Int])
    }
  }

  private def expected : Tree =
    Node("Add", List(
      Node("Lit",List(Leaf("8"))),
      Node("Neg",List(
        Node("Add",List(
          Node("Lit",List(Leaf("1"))),
          Node("Lit",List(Leaf("2")))))))))


  private def deserialize[R: ExpSYM] =
    fromTree[R].apply(expression[Tree].tf1) match {
      case Left(msg) ⇒ msg
      case Right(x)  ⇒ s"""${eval(x)}"""
    }
}