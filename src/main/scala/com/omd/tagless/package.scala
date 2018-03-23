package com.omd

package object tagless extends ExpSymbols with MulSymbols {
  implicit def eval[R]: R ⇒ R = identity[R]
}