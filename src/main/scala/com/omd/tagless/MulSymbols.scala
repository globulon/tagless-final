package com.omd.tagless


trait MulSymbols {
  implicit final def MulInt: MulSYM[Int] = new MulSYM[Int] {
    override def mul: Int ⇒ Int ⇒ Int = a ⇒ b ⇒ a * b
  }

  implicit final def MulString: MulSYM[String] = new MulSYM[String] {
    override def mul: String ⇒ String ⇒ String = a ⇒ b ⇒ s"""(* $a * $b)"""
  }
}