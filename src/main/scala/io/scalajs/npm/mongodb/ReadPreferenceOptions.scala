package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * Read Preference Options
  * @param readPreference The preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */
@ScalaJSDefined
class ReadPreferenceOptions(val readPreference: js.UndefOr[ReadPreference | String] = js.undefined)
  extends js.Object