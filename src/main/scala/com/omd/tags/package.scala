package com.omd

import scala.annotation.tailrec

package object tags extends Environment {
  type Env = List[Union]


// Like in SICP
//  def eval0: Env ⇒ Exp ⇒ Any = env ⇒ {
//    case V(v) ⇒ lookup (env) (v)
//    case B(b) ⇒ b
//    case L(ex) ⇒ eval0 (_) (ex)
//    case A(f, x) ⇒ (eval0 env f) ()
//
//  }

  //match is not exhaustive
  def eval: Env ⇒ Exp ⇒ Union = env ⇒ {
    case V(v)    ⇒ lookup (v, env)
    case B(b)    ⇒ UB(b)
    case L(ex)   ⇒ UA { u ⇒ eval(u::env)(ex) }
    case A(f, x) ⇒ eval(env)(f) match {
      case UA(fu) ⇒ fu(eval(env)(x))
    }
  }

  @tailrec
  override def lookup(v: Var, ev: Env): Union = (v, ev) match {
    case (VZ(), u::_)     ⇒ u
    case (VS(n), _::rest) ⇒ lookup (n, rest)
  }
}





