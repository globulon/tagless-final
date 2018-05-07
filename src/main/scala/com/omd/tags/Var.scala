package com.omd.tags

sealed trait Var
case class VZ() extends Var
case class VS(v: Var) extends Var

sealed trait Exp
case class V(v: Var) extends Exp
case class B(v: Boolean) extends Exp
case class L(v: Exp) extends Exp
case class A(v: Exp, w: Exp) extends Exp

sealed trait Union
case class UB(b: Boolean) extends Union
case class UA(f: Union ⇒ Union) extends Union