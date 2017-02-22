package io.scalajs.npm.mongodb

import io.scalajs.{RawOptions, nodejs}

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, ScalaJSDefined}
import scala.scalajs.js.|

/**
  * Cursor
  * @author lawrence.daniels@gmail.com
  * @see {{{ https://mongodb.github.io/node-mongodb-native/api-generated/cursor.html }}}
  */
@js.native
trait Cursor[T] extends nodejs.stream.Readable {

  /**
    * Add a cursor flag to the cursor
    * @param flag  The flag to set, must be one of following ['tailable', 'oplogReplay', 'noCursorTimeout', 'awaitData', 'partial'].
    * @param value The flag boolean value.
    */
  def addCursorFlag(flag: CursorFlag, value: Boolean): this.type = js.native

  /**
    * Add a query modifier to the cursor query
    * @param name  The query modifier (must start with $, such as $orderby etc)
    * @param value The flag boolean value.
    */
  def addQueryModifier(name: String, value: Boolean): this.type = js.native

  /**
    * Sets the batch size parameter of this cursor to the given value.
    * @param size the new batch size.
    * @return a promise of the [[Cursor]]
    * @example batchSize(size[, callback])
    */
  def batchSize(size: Int): js.Promise[this.type] = js.native

  /**
    * Sets the batch size parameter of this cursor to the given value.
    * @param size     the new batch size.
    * @param callback this optional callback will be called after executing this method. The first parameter will
    *                 contain an error object when the batchSize given is not a valid number or when the cursor is
    *                 already closed while the second parameter will contain a reference to this object upon successful
    *                 execution.
    * @example batchSize(size[, callback])
    */
  def batchSize(size: Int, callback: MongoCallback[this.type]): Unit = js.native

  /**
    * Clone the cursor
    */
  override def clone(): this.type = js.native

  /**
    * Close the cursor, sending a KillCursor command and emitting close.
    * @return a promise of the [[Cursor]]
    */
  def close(): Promise[this.type] = js.native

  /**
    * Close the cursor, sending a KillCursor command and emitting close.
    * @param callback this will be called after executing this method. The first parameter will always contain null
    *                 while the second parameter will contain a reference to this cursor.
    */
  def close(callback: MongoCallback[this.type]): Unit = js.native

  /**
    * Set the collation options for the cursor.
    * @param value the cursor collation options (MongoDB 3.4 or higher) settings for update operation
    *              (see 3.4 documentation for available fields).
    * @return the [[Cursor]]
    */
  def collation(value: js.Any): this.type = js.native

  /**
    * Add a comment to the cursor query allowing for tracking the comment in the log.
    * @param value The comment attached to this query.
    * @return the [[Cursor]]
    */
  def comment(value: String): this.type = js.native

  /**
    * Determines how many result the query for this cursor will return
    * @param applySkipLimit if set to true will apply the skip and limits set on the cursor. Defaults to false.
    * @param options        the optional settings.
    * @return a promise of the count
    * @example count(applySkipLimit, [options])
    */
  def count(applySkipLimit: Boolean = js.native,
            options: CountOptions | RawOptions = js.native): Promise[Int] = js.native

  /**
    * Determines how many result the query for this cursor will return
    * @param applySkipLimit if set to true will apply the skip and limits set on the cursor. Defaults to false.
    * @param callback       this will be called after executing this method. The first parameter will contain the Error
    *                       object if an error occurred, or null otherwise. While the second parameter will contain the
    *                       number of results or null if an error occurred.
    * @param options        the optional settings.
    * @example count(applySkipLimit, [options], callback)
    */
  def count(applySkipLimit: Boolean,
            options: CountOptions | RawOptions,
            callback: MongoCallback[Int]): Unit = js.native

  /**
    * Determines how many result the query for this cursor will return
    * @param applySkipLimit if set to true will apply the skip and limits set on the cursor. Defaults to false.
    * @param callback       this will be called after executing this method. The first parameter will contain the Error
    *                       object if an error occurred, or null otherwise. While the second parameter will contain the
    *                       number of results or null if an error occurred.
    * @example count(applySkipLimit, [options], callback)
    */
  def count(applySkipLimit: Boolean, callback: MongoCallback[Int]): Unit = js.native

  /**
    * Iterates over all the documents for this cursor. As with {cursor.toArray}, not all of the elements will be
    * iterated if this cursor had been previouly accessed. In that case, {cursor.rewind} can be used to reset the
    * cursor. However, unlike {cursor.toArray}, the cursor will only hold a maximum of batch size elements at any
    * given time if batch size is specified. Otherwise, the caller is responsible for making sure that the entire
    * result can fit the memory.
    * @param callback this will be called for while iterating every document of the query result. The first parameter
    *                 will contain the Error object if an error occurred, or null otherwise. While the second parameter
    *                 will contain the document.
    */
  @deprecated(message = "No alternatives specified", since = "2.2")
  def each(callback: MongoCallback[T]): Unit = js.native

  /**
    * Gets a detailed information about how the query is performed on this cursor and how long it took the database to process it.
    * @param callback this will be called after executing this method. The first parameter will always be null while
    *                 the second parameter will be an object containing the details.
    * @example explain(callback)
    */
  def explain(callback: js.Function): Unit = js.native

  /**
    * Set the cursor query
    * @param filter The filter object used for the cursor.
    */
  def filter(filter: js.Any): this.type = js.native

  /**
    * Iterates over all the documents for this cursor using the iterator, callback pattern.
    * @param iterator The iteration callback.
    * @param callback The end callback.
    */
  def forEach(iterator: js.Function1[T, Any], callback: MongoCallback[T]): Unit = js.native

  /**
    * Set the cursor hint
    * @param hint If specified, then the query system will only consider plans using the hinted index.
    */
  def hint(hint: String = js.native): this.type = js.native

  /**
    * Check if the cursor is closed or open.
    * @return the state of the cursor.
    */
  def isClosed(): Boolean = js.native

  /**
    * Sets the limit parameter of this cursor to the given value.
    * @param limit    the new limit.
    * @param callback this optional callback will be called after executing this method. The first parameter will
    *                 contain an error object when the limit given is not a valid number or when the cursor is already
    *                 closed while the second parameter will contain a reference to this object upon successful execution.
    * @example limit(limit[, callback])
    */
  def limit(limit: Int, callback: js.Function = js.native): this.type = js.native

  /**
    * Map all documents using the provided function
    * @param transform The mapping transformation method.
    */
  def map(transform: js.Function): Unit = js.native

  /**
    * Set the cursor max
    * @param max Specify a $max value to specify the exclusive upper bound for a specific index in order to constrain
    *            the results of find(). The $max specifies the upper bound for all keys of a specific index in order.
    */
  def max(max: Int): this.type = js.native

  /**
    * Set a maxAwaitTimeMS on a tailing cursor query to allow to customize the timeout value for the option awaitData
    * (Only supported on MongoDB 3.2 or higher, ignored otherwise)
    * @param value Number of milliseconds to wait before aborting the tailed query.
    */
  def maxAwaitTimeMS(value: Int): this.type = js.native

  /**
    * Set the cursor maxScan
    * @param maxScan Constrains the query to only scan the specified number of documents when fulfilling the query
    */
  def maxScan(maxScan: Int): this.type = js.native

  /**
    * Specifies a time limit for a query operation. After the specified time is exceeded, the operation will be
    * aborted and an error will be returned to the client. If maxTimeMS is null, no limit is applied.
    * @param maxTimeMS the maxTimeMS for the query.
    * @param callback  this optional callback will be called after executing this method. The first parameter will
    *                  contain an error object when the limit given is not a valid number or when the cursor is
    *                  already closed while the second parameter will contain a reference to this object upon
    *                  successful execution.
    * @example maxTimeMS(maxTimeMS[, callback])
    */
  def maxTimeMS(maxTimeMS: Int, callback: js.Function = js.native): this.type = js.native

  /**
    * Set the cursor min
    * @param min Specify a $min value to specify the inclusive lower bound for a specific index in order to constrain
    *            the results of find(). The $min specifies the lower bound for all keys of a specific index in order.
    */
  def min(min: Int): this.type = js.native

  /**
    * Get the next available document from the cursor, returns null if no more documents are available.
    * @param callback The result callback.
    * @return [[js.Promise promise]] if no callback passed
    */
  def next(callback: js.Function): Unit = js.native

  /**
    * Get the next available document from the cursor, returns null if no more documents are available.
    * @return [[js.Promise promise]] if no callback passed
    */
  def next(): js.Promise[T] = js.native

  /**
    * Gets the next document from the cursor.
    * @param callback The result callback.
    * @return [[js.Promise promise]] if no callback passed
    */
  def nextObject(callback: MongoCallback[T]): Unit = js.native

  /**
    * Gets the next document from the cursor.
    * @return [[js.Promise promise]] if no callback passed
    */
  @deprecated("Use next() instead", since = "2.0")
  def nextObject(): js.Promise[T] = js.native

  /**
    * Sets a field projection for the query.
    * @param value The field projection object.
    */
  def project(value: js.Any): this.type = js.native

  /**
    * Set the cursor returnKey
    * @param returnKey Only return the index field or fields for the results of the query. If $returnKey is
    *                  set to true and the query does not use an index to perform the read operation, the
    *                  returned documents will not contain any fields.
    */
  def returnKey(returnKey: Int): this.type = js.native

  /**
    * Resets this cursor to its initial state. All settings like the query string, tailable, batchSizeValue,
    * skipValue and limits are preserved.
    */
  def rewind(): this.type = js.native

  /**
    * Sets the read preference for the cursor
    * @param pref     read preference for the cursor, one of [[Server.READ_PRIMARY Server.READ_PRIMARY]],
    *                 [[Server.READ_SECONDARY Server.READ_SECONDARY]], [[Server.READ_SECONDARY Server.READ_SECONDARY_ONLY]]
    * @param callback this optional callback will be called after executing this method. The first parameter will
    *                 contain an error object when the read preference given is not a valid number or when the cursor
    *                 is already closed while the second parameter will contain a reference to this object upon
    *                 successful execution.
    * @example setReadPreference(pref[, callback])
    */
  def setReadPreference(pref: String, callback: js.Function = js.native): this.type = js.native

  /**
    * Set the cursor showRecordId
    * @param enable The $showDiskLoc option has now been deprecated and replaced with the showRecordId field.
    *               $showDiskLoc will still be accepted for OP_QUERY stye find.
    */
  def showRecordId(enable: Boolean): this.type = js.native

  /**
    * Sets the skip parameter of this cursor to the given value.
    * @param skip     the new skip value.
    * @param callback this optional callback will be called after executing this method. The first parameter will contain
    *                 an error object when the skip value given is not a valid number or when the cursor is already closed
    *                 while the second parameter will contain a reference to this object upon successful execution.
    * @example skip(skip[, callback])
    */
  def skip(skip: Int, callback: js.Function = js.native): this.type = js.native

  /**
    * Sets the sort parameter of this cursor to the given value.
    * @param keyOrList this can be a string or an array. If passed as a string, the string will be the field to sort.
    *                  If passed an array, each element will represent a field to be sorted and should be an array that
    *                  contains the format [string, direction].
    * @param direction this determines how the results are sorted. "asc", "ascending" or 1 for
    *                  ascending order while "desc", "descending or -1 for descending order.
    *                  <b>Note</b> that the strings are case insensitive.
    * @param callback  this will be called after executing this method. The first parameter will contain an error
    *                  object when the cursor is already closed while the second parameter will contain a reference
    *                  to this object upon successful execution.
    * @example sort(keyOrList, direction, callback)
    */
  def sort(keyOrList: String, direction: Int | String, callback: js.Function): this.type = js.native

  /**
    * Sets the sort parameter of this cursor to the given value.
    * @param keyOrList this can be a string or an array. If passed as a string, the string will be the field to sort.
    *                  If passed an array, each element will represent a field to be sorted and should be an array that
    *                  contains the format [string, direction].
    * @param callback  this will be called after executing this method. The first parameter will contain an error
    *                  object when the cursor is already closed while the second parameter will contain a reference
    *                  to this object upon successful execution.
    * @example sort(keyOrList, direction, callback)
    */
  def sort(keyOrList: js.Array[js.Any], callback: js.Function = js.native): this.type = js.native

  /**
    * Sets the sort parameter of this cursor to the given value.
    * @param keyOrList this can be a string or an array. If passed as a string, the string will be the field to sort.
    *                  If passed an array, each element will represent a field to be sorted and should be an array that
    *                  contains the format [string, direction].
    * @param direction this determines how the results are sorted. "asc", "ascending" or 1 for
    *                  ascending order while "desc", "descending or -1 for descending order.
    *                  <b>Note</b> that the strings are case insensitive.
    * @example sort(keyOrList, direction, callback)
    */
  def sort(keyOrList: String | js.Array[js.Any], direction: Int | String): this.type = js.native

  /**
    * TODO document me
    */
  def snapshot(enable: Boolean): this.type = js.native

  /**
    * Returns a Node Transform Stream interface for this cursor.
    * {{{
    *   var stream = collection.find({mykey:{$ne:2}}).stream();
    *   stream.on("data", function(item) {});
    *   stream.on("end", function() {});
    * }}}
    * @return returns a [[CursorStream stream object]].
    */
  def stream(): CursorStream = js.native

  /**
    * Returns a Node Transform Stream interface for this cursor.
    * @return returns a [[CursorStream stream object]].
    */
  def stream(transform: StreamTransform): this.type = js.native

  /**
    * Returns an array of documents. The caller is responsible for making sure that there is enough memory to store
    * the results. Note that the array only contain partial results when this cursor had been previouly accessed.
    * In that case, cursor.rewind() can be used to reset the cursor.
    * @param callback This will be called after executing this method successfully. The first parameter will contain
    *                 the Error object if an error occurred, or null otherwise. The second parameter will contain an
    *                 array of BSON deserialized objects as a result of the query.
    */
  def toArray(callback: MongoCallback[js.Array[T]]): Unit = js.native

}

/**
  * Cursor Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "Cursor")
object Cursor extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  val INIT: Int = js.native
  val OPEN: Int = js.native
  val CLOSED: Int = js.native
  val GET_MORE: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Static Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Clones a given cursor but uses new options
    * @example Cursor.cloneWithOptions(cursor)
    */
  def cloneWithOptions[T](cursor: Cursor[T]): CursorOptions = js.native

}

/**
  * Count Options
  * @param skip           The number of documents to skip.
  * @param limit          The maximum amounts to count before aborting.
  * @param maxTimeMS      Number of miliseconds to wait before aborting the query.
  * @param hint           An index name hint for the query.
  * @param readPreference The preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */
@ScalaJSDefined
class CountOptions(val skip: js.UndefOr[Int] = js.undefined,
                   val limit: js.UndefOr[Int] = js.undefined,
                   val maxTimeMS: js.UndefOr[Int] = js.undefined,
                   val hint: js.UndefOr[String] = js.undefined,
                   val readPreference: js.UndefOr[ReadPreference | String] = js.undefined) extends js.Object