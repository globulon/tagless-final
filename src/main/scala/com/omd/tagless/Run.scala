package com.omd.tagless


object Run {
  private def run[R : ExpSYM : MulSYM]: Extensions[R] = new Extensions[R](implicitly[ExpSYM[R]], implicitly[MulSYM[R]])

  def main(args: Array[String]): Unit = {
    println(eval(run[Int].tfm1))
    println(eval(run[String].tfm1))
    println(eval(run[Int].tfm2))
    println(eval(run[String].tfm2))

  }
}