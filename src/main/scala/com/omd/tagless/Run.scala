package com.omd.tagless


object Run extends Expressions {
  def main(args: Array[String]): Unit = {
    println(eval(expression[Int].tfm1))
    println(eval(expression[String].tfm1))
    println(eval(expression[Int].tfm2))
    println(eval(expression[String].tfm2))

    println(eval(expression[Tree].tf1))
  }
}