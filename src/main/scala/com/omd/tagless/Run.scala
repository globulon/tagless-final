package com.omd.tagless


object Run extends Extensions {
  private def run[R : ExpSYM : MulSYM]: Extension[R] = extension[R](implicitly[ExpSYM[R]], implicitly[MulSYM[R]])

  def main(args: Array[String]): Unit = {
    println(eval(run[Int].tfm1))
    println(eval(run[String].tfm1))
    println(eval(run[Int].tfm2))
    println(eval(run[String].tfm2))
  }
}