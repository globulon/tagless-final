package com.omd.tags

import org.scalatest.{MustMatchers, WordSpec}

final class ExpressionsTest extends WordSpec with MustMatchers with Expressions {
  "evaluate" should {
    "be applicable to simple test " in {
      eval(List.empty)(ti1) must be (UB(true))
    }

    "blow up" in {
      assertThrows[MatchError] {
        eval(List.empty)(ti2o)
      }
    }
  }
}
