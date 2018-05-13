package com.omd.initial

trait Expressions {
  def ti1[Env]: Exp[Env, Boolean] = A(L(V(VZ[Env, Boolean]())),B(true))
}
