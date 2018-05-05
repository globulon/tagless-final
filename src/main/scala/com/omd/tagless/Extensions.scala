package com.omd.tagless


final class Extensions[R](exps: ExpSYM[R], muls: MulSYM[R]) {
  import exps._
  import muls._

  def tfm1: R = add (lit (7)) (neg (mul(lit (1))(lit (2))))
  def tfm2: R = add (lit (7)) (new Expressions[R](exps).tf1)
}
