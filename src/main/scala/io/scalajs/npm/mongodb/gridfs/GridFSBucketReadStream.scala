package io.scalajs.npm.mongodb.gridfs

import io.scalajs.{RawOptions, nodejs}
import io.scalajs.npm.mongodb.Collection

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * GridFS Bucket Read Stream
  * @author lawrence.daniels@gmail.com
  * @see {{{ http://mongodb.github.io/node-mongodb-native/2.1/api/GridFSBucketReadStream.html }}}
  */
@js.native
@JSImport("mongodb", "GridFSBucketReadStream")
class GridFSBucketReadStream(chunks: Collection,
                             files: Collection,
                             readPreference: js.Any,
                             filter: js.Any,
                             options: ReadStreamOptions | RawOptions)
  extends nodejs.stream.Readable {

  /**
    * Marks this stream as aborted (will never push another data event) and kills the underlying cursor.
    * Will emit the 'end' event, and then the 'close' event once the cursor is successfully killed.
    * @param callback called when the cursor is successfully closed or an error occurred.
    * @example abort(callback)
    */
  def abort(callback: js.Function): Unit = js.native

  /**
    * Sets the 0-based offset in bytes to start streaming from. Throws an error if this stream has entered
    * flowing mode (e.g. if you've already called on('data'))
    * @param offset the offset in bytes to stop reading at
    */
  def end(offset: Int): GridFSBucketReadStream = js.native

  /**
    * Sets the 0-based offset in bytes to start streaming from. Throws an error if this stream has entered
    * flowing mode (e.g. if you've already called on('data'))
    * @param offset the offset in bytes to start reading at
    */
  def start(offset: Int): GridFSBucketReadStream = js.native

}
