package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Remove User Options.
  * @param w        The write concern
  * @param wtimeout The write concern timeout.
  * @param j        Specify a journal write concern..
  */
class RemoveUserOptions(val w: js.UndefOr[Int | String] = js.undefined,
                        val wtimeout: js.UndefOr[Int] = js.undefined,
                        val j: js.UndefOr[Boolean] = js.undefined)
  extends js.Object
