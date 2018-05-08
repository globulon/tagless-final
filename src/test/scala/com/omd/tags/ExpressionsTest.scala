package com.omd.tags

import org.scalatest.{MustMatchers, WordSpec}

final class ExpressionsTest extends WordSpec with MustMatchers with Expressions {
  "evaluate" should {
    "be applicable to simple test " in {
      eval(List.empty)(ti1) must be (UB(true))
    }


    /**
    * Informally,
    * our embedding is not ‘tight’: the algebraic data type Exp contains more val-
    * ues than there are well-typed terms in the simply typed lambda-calculus with
    * booleans. The embedding failed to represent the well-formedness constraints im-
    * posed by the object language’s type system.
    * * */
    "blow up" in {
      assertThrows[MatchError] {
        eval(List.empty)(ti2o)
      }
    }
  }
}
