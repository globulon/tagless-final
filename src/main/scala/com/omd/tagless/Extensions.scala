package com.omd.tagless


final class Extensions[R](exps: ExpSYM[R], muls: MulSYM[R]) {
  def tfm1: R = add (lit (7)) (neg (mul(lit (1))(lit (2))))
  def tfm2: R = add (lit (7)) (new Expressions[R](exps).tf1)

  private def mul : R ⇒ R ⇒ R = muls.mul
  private def lit : Int  ⇒ R  = exps.lit
  private def neg : R ⇒ R     = exps.neg
  private def add : R ⇒ R ⇒ R = exps.add
}
