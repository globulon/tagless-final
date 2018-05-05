package com.omd.tagless

sealed trait Tree {
  def label: String
}
case class Node(override val label: String, t: List[Tree]) extends Tree
case class Leaf(override val label: String) extends Tree