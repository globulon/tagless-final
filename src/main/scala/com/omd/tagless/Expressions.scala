package com.omd.tagless


trait Expression[R] {
  def tf1(implicit ev: ExpSYM[R]) : R
  def tfm1(implicit ev: ExpSYM[R], ev1: MulSYM[R]): R
  def tfm2(implicit ev: ExpSYM[R], ev1: MulSYM[R]): R
}

trait Expressions {
  final protected def expression[R]: Expression[R] = new Expression[R] {

    //In tagless final lecture : ExpSYM repr ⇒ repr
    override def tf1(implicit ev: ExpSYM[R]): R = {
      import ev._
      add (lit(8)) (neg(add(lit(1))(lit(2))))
    }

    //In tagless final lecture : (ExpSYM repr, MulSYM repr) ⇒ repr
    override def tfm1(implicit ev: ExpSYM[R], ev1: MulSYM[R]): R = {
      import ev._
      import ev1._
      add (lit (7)) (neg (mul(lit (1))(lit (2))))
    }

    //In tagless final lecture : (ExpSYM repr, MulSYM repr) ⇒ repr
    override def tfm2(implicit ev: ExpSYM[R], ev1: MulSYM[R]): R = {
      import ev._
      add (lit (7)) (tf1)
    }
  }
}