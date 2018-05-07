package com.omd.tags

trait Environment {
  type Env

  def lookup (v: Var, env: Env): Union

}
