package com.omd.tagless

sealed trait Tree
case class Node(label: String, t: List[Tree]) extends Tree
case class Leaf(value: String) extends Tree