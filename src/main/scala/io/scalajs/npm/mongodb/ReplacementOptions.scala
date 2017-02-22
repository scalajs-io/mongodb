package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * Document Replacement Options
  * @param upsert                    Update operation is an upsert.
  * @param w                         The write concern
  * @param wtimeout                  The write concern timeout.
  * @param j                         Specify a journal write concern.
  * @param  bypassDocumentValidation Allow driver to bypass schema validation in MongoDB 3.2 or higher.
  */
@ScalaJSDefined
class ReplacementOptions(val upsert: js.UndefOr[Boolean] = js.undefined,
                         val w: js.UndefOr[Int | String] = js.undefined,
                         val wtimeout: js.UndefOr[Int] = js.undefined,
                         val j: js.UndefOr[Boolean] = js.undefined,
                         val bypassDocumentValidation: js.UndefOr[Boolean] = js.undefined)
  extends js.Object
