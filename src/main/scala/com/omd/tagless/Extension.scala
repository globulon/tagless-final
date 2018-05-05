package com.omd.tagless


trait Extension[R] {
  def tfm1: R
  def tfm2: R
}

trait Extensions { self : Expressions ⇒
  final protected def extension[R](exps: ExpSYM[R], muls: MulSYM[R]): Extension[R] = new Extension[R] {
    import exps._
    import muls._

    override def tfm1: R = add (lit (7)) (neg (mul(lit (1))(lit (2))))
    override def tfm2: R = add (lit (7)) (expression[R](exps).tf1)
  }
}