package io.scalajs.npm.mongodb.gridfs

import io.scalajs.nodejs.stream.Duplex

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Grid Store Stream
  * @author lawrence.daniels@gmail.com
  */
@deprecated("Use GridFSBucket API instead", since = "2.2")
@js.native
@JSImport("mongodb", "GridStoreStream")
class GridStoreStream() extends Duplex