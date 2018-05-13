package com.omd.initial

import org.scalatest.{MustMatchers, WordSpec}

final class ExpressionsTest extends WordSpec with MustMatchers{
  "eval" should {
    "resolve expression" in {
      eval[Map[String, Any], Boolean](Map.empty,ti1[Map[String, Any]]) must be (true)
    }
  }
}
