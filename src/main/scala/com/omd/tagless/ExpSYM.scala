package com.omd.tagless


trait ExpSYM[R] {
  def lit : Int  ⇒ R
  def neg : R ⇒ R
  def add : R ⇒ R ⇒ R
}