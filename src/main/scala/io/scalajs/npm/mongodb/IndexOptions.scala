package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * Index Options
  * @param w                       The write concern (number | string;	default: null).
  * @param wtimeout                The write concern timeout (default: null).
  * @param j                       Specify a journal write concern (default: false).
  * @param unique                  Creates an unique index (default: false).
  * @param sparse                  Creates a sparse index (default: false).
  * @param background              Creates the index in the background, yielding whenever possible (default: false).
  * @param dropDups                A unique index cannot be created on a key that has pre-existing duplicate values.
  *                                If you would like to create the index anyway keeping the first document the database
  *                                indexes and deleting all
  *                                subsequent documents that have duplicate value (default: false).
  * @param min                     For geospatial indexes set the lower bound for the co-ordinates (default: null).
  * @param max                     For geospatial indexes set the high bound for the co-ordinates (default: null).
  * @param v                       Specify the format version of the indexes (default: null).
  * @param expireAfterSeconds      Allows you to expire data on indexes applied to a data (MongoDB 2.2 or higher) (default: null).
  * @param name                    Override the auto-generated index name (useful if the resulting name is larger than
  *                                128 bytes) (default: null)
  * @param partialFilterExpression Creates a partial index based on the given filter object (MongoDB 3.2 or higher)
  */
@ScalaJSDefined
class IndexOptions(val w: js.UndefOr[Int | String] = js.undefined,
                   val wtimeout: js.UndefOr[Int] = js.undefined,
                   val j: js.UndefOr[Boolean] = js.undefined,
                   val unique: js.UndefOr[Boolean] = js.undefined,
                   val sparse: js.UndefOr[Boolean] = js.undefined,
                   val background: js.UndefOr[Boolean] = js.undefined,
                   val dropDups: js.UndefOr[Boolean] = js.undefined,
                   val min: js.UndefOr[Int] = js.undefined,
                   val max: js.UndefOr[Int] = js.undefined,
                   val v: js.UndefOr[Int] = js.undefined,
                   val expireAfterSeconds: js.UndefOr[Int] = js.undefined,
                   val name: js.UndefOr[Int] = js.undefined,
                   val partialFilterExpression: js.UndefOr[js.Any] = js.undefined)
  extends js.Object
