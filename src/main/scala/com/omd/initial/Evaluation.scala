package com.omd.initial

protected[initial] trait Evaluation {

  def eval[Env, T](env: Env, exp: Exp[Env, T]): T = exp match {
    case B(b)       ⇒ b
    case V(v)       ⇒ lookup(env, v)
    case ll@L(ex)   ⇒ t: ll.P => eval ((t, ex), ex)
    case A(f, a)    ⇒ eval(env, f).apply(eval(env, a))
  }

  protected def lookup[Env, T](env: Env, v: Var[Env, T]): T
}
