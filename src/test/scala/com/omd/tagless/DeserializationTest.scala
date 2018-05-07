package com.omd.tagless

import org.scalatest.{MustMatchers, WordSpec}

final class DeserializationTest extends WordSpec with MustMatchers with Deserialization with Expressions {
  "serialization" should {
    "properly reuse dsl" in {
      eval(expression[Tree].tf1) must be (expected)
    }
  }

  private def expected : Tree =
    Node("Add", List(
      Node("Lit",List(Leaf("8"))),
      Node("Neg",List(
        Node("Add",List(
          Node("Lit",List(Leaf("1"))),
          Node("Lit",List(Leaf("2")))))))))
}