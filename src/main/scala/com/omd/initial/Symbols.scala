package com.omd.initial

sealed trait Var[Env, T]

case class VZ[Env, T]() extends Var[(T, Env), T]
case class VS[Env, T, R](v: Var[Env, T]) extends Var[(R, Env), T]


sealed trait Exp[Env, T]

case class B[Env](v: Boolean) extends Exp[Env, Boolean]
case class V[Env, T](v: Var[Env, T]) extends Exp[Env, T]
case class L[Env, T, R](exp: Exp[(T, Env), R]) extends Exp[Env, T ⇒ R] { type P = T }
case class A[Env, T, R](f: Exp[Env, T ⇒ R], v: Exp[Env, T]) extends Exp[Env, R]

