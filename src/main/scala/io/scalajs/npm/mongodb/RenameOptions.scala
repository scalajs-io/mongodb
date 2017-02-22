package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Rename Options
  * @param dropTarget drop the target name collection if it previously exists.
  */
@ScalaJSDefined
class RenameOptions(val dropTarget: js.UndefOr[Boolean] = js.undefined)
  extends js.Object