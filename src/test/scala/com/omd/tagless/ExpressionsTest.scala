package com.omd.tagless

import org.scalatest.{MustMatchers, WordSpec}

final class ExpressionsTest extends WordSpec with MustMatchers with Expressions {
  "eval for Integers" should {
    "evaluate unmixed expression" in {
      eval(expression[Int].tfm1) must be (5)
    }

    "evaluate mixed expression" in {
      eval(expression[Int].tfm2) must be (12)
    }
  }

  "eval for String" should {
    "evaluate unmixed expression" in {
      eval(expression[String].tfm1) must be ("(+ 7 (- (* 1 * 2)))")
    }

    "evaluate mixed expression" in {
      eval(expression[String].tfm2) must be ("(+ 7 (+ 8 (- (+ 1 2))))")
    }
  }

}
