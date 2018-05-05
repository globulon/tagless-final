package com.omd.tagless


object Run extends Extensions with Expressions {
  private def symbols[R : ExpSYM]: ExpSYM[R] = implicitly[ExpSYM[R]]
  private def extended[R : ExpSYM]: MulSYM[R] = implicitly[MulSYM[R]]

  private def exp[R : ExpSYM]: Expression[R] = expression(symbols[R])
  private def all[R : ExpSYM : MulSYM]: Extension[R] = extension[R](symbols[R], extended[R])


  def main(args: Array[String]): Unit = {
    println(eval(all[Int].tfm1))
    println(eval(all[String].tfm1))
    println(eval(all[Int].tfm2))
    println(eval(all[String].tfm2))

    println(eval(exp[Tree].tf1))
  }
}