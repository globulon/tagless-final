package com.omd.tagless

trait ExpSymbols {
  implicit final def runInt: ExpSYM[Int] = new  ExpSYM[Int] {
    override def lit: Int ⇒ Int = identity

    override def neg: Int ⇒ Int = - _

    override def add: Int ⇒ Int ⇒ Int = a ⇒ b ⇒ a + b
  }

  implicit final def runString: ExpSYM[String] = new  ExpSYM[String] {
    override def lit: Int ⇒ String = _.toString

    override def neg: String ⇒ String = s ⇒ s"""(- $s)"""

    override def add: String ⇒ String ⇒ String = a ⇒ b ⇒ s"""(+ $a $b)"""
  }

  implicit final def runTree: ExpSYM[Tree] = new ExpSYM[Tree] {
    override def lit: Int ⇒ Tree = v ⇒ Node("Lit", List(Leaf(v.toString)))

    override def neg: Tree ⇒ Tree = t ⇒ Node("neg", List(t))

    override def add: Tree ⇒ Tree ⇒ Tree = left ⇒ right ⇒ Node("add", List(left, right))
  }
}