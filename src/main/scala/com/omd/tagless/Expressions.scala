package com.omd.tagless


trait Expression[R] {
  def tf1 : R
}

trait Expressions {
  final protected def expression[R](exps: ExpSYM[R]): Expression[R] = new Expression[R](exps) {
    import exps._

    override def tf1: R = add (lit(8)) (neg(add(lit(1))(lit(2))))
  }
}