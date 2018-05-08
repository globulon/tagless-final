package com.omd.initial


sealed trait Var[Env, T]
case class VZ[Env, T]() extends Var[(T, Env), T]
case class VS[Env, A, T ](v: Var[Env, T]) extends Var[(A, Env), T]


sealed trait Exp[Env, T]
case class V[Env, T](v: Var[Env, T]) extends Exp[Env, T]
case class B[Env, T](v: Boolean) extends Exp[Env, Boolean]
case class L[Env, A, B](exp: Exp[(A, Env), B]) extends Exp[Env, A ⇒ B]
case class A[Env, A, B](f: Exp[Env, A ⇒ B], v: Exp[Env, A]) extends Exp[Env, B]