package com.omd.tagless


class Expressions[R](exps: ExpSYM[R])  {

  def tf1: R = add (lit(8)) (neg(add(lit(1))(lit(2))))

  private def lit : Int  ⇒ R  = exps.lit
  private def neg : R ⇒ R     = exps.neg
  private def add : R ⇒ R ⇒ R = exps.add
}
