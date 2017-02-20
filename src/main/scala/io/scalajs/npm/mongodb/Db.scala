package io.scalajs.npm.mongodb

import io.scalajs.RawOptions

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, ScalaJSDefined}
import scala.scalajs.js.{Array, |}

/**
  * Mongo Database
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  */
@js.native
@JSImport("mongodb", "Db")
class Db(val databaseName: String, val replicaSet: ReplSet, val options: DbOptions) extends js.Object {

  def this() = this(null, null, null)

  def this(databaseName: String, server: Server) = this(databaseName, null, null)

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  // Server | ReplSet | Mongos  - Get the current db topology.
  var serverConfig: js.Any = js.native

  // Current bufferMaxEntries value for the database.
  var bufferMaxEntries: Int = js.native

  // The name of the database this instance represents.
  //var databaseName: String = js.native

  // The options associated with the db instance.
  //var options: js.Any = js.native

  // The current value of the parameter native_parser.
  var native_parser: Boolean = js.native

  // The current slaveOk value for the db instance.
  var slaveOk: Boolean = js.native

  // The current write concern values.
  var writeConcern: js.Any = js.native

  // Access the topology object (single server, replicaset or mongos).
  var topology: js.Any = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def admin(): MongoAdmin = js.native

  def close(): Unit = js.native

  def collection(name: String): Collection = js.native

  def collection(name: String, callback: js.Function): Unit = js.native

  def collection(name: String, options: CollectionOptions | js.Any, callback: js.Function): Unit = js.native

  def collectionsInfo(): Cursor[js.Any] = js.native

  def collectionNames(callback: js.Function): Unit = js.native

  def createCollection(name: String, callback: js.Function): Unit = js.native

  def createCollection(name: String, options: CollectionOptions | js.Any, callback: js.Function): Unit = js.native

  def createIndex(name: String, flag: Char, callback: js.Function): Unit = js.native

  def dropCollection(name: String, callback: js.Function): Unit = js.native

  def dropDatabase(callback: js.Function): Unit = js.native

  /**
    * Retrieves this collections index info.
    * @param name    the name of the collection.
    * @param options the optional settings.
    * @return a promise of the index information
    */
  def indexInformation(name: String,
                       options: IndexInformationOptions | RawOptions = js.native): js.Promise[js.Any] = js.native

  /**
    * Retrieves this collections index info.
    * @param name     the name of the collection.
    * @param options  the optional settings.
    * @param callback the callback containing the index information
    */
  def indexInformation(name: String,
                       options: IndexInformationOptions | RawOptions,
                       callback: js.Function2[MongoError, js.Any, Any]): Unit = js.native

  /**
    * Retrieves this collections index info.
    * @param name     the name of the collection.
    * @param callback the callback containing the index information
    */
  def indexInformation(name: String, callback: js.Function2[MongoError, js.Any, Any]): Unit = js.native

  /**
    * Get the list of all collection information for the specified db.
    * @param filter  query to filter collections by
    * @param options the qptional settings.
    * @return a [[CommandCursor]] containing the results
    */
  def listCollections(filter: js.Any = js.native,
                      options: ListCollectionsOptions | RawOptions = js.native): CommandCursor[CollectionInfo] = js.native

  /**
    *
    * @param callback
    */
  def open(callback: js.Function): Unit = js.native

}

/**
  * Mongo Database Companion
  * @author lawrence.daniels@gmail.com
  */
object Db {

  /**
    * Mongo Database Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoDatabaseExtensions(val db: Db) extends AnyVal {

    @inline
    def collectionFuture(name: String, options: CollectionOptions | js.Any = null): Future[Collection] = {
      callbackMongoFuture[Collection](db.collection(name, options, _))
    }

    @inline
    def collectionNamesFuture: Future[Array[String]] = callbackMongoFuture[js.Array[String]](db.collectionNames)

    @inline
    def createCollectionFuture(name: String, options: CollectionOptions = null): Future[Collection] = {
      callbackMongoFuture[Collection](db.createCollection(name, options, _))
    }

    @inline
    def dropCollectionFuture(name: String): Future[OperationResult] =
      callbackMongoFuture[OperationResult](db.dropCollection(name, _))

    @inline
    def dropDatabaseFuture(): Future[OperationResult] = callbackMongoFuture[OperationResult](db.dropDatabase)

    @inline
    def openFuture(): Future[Db] = callbackMongoFuture[Db](db.open)

  }

}

/**
  * List Collections Options
  * @param batchSize      The batchSize for the returned command cursor or if pre 2.8 the systems batch collection
  * @param readPreference The preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */
@ScalaJSDefined
class ListCollectionsOptions(val batchSize: js.UndefOr[Int] = js.undefined,
                             val readPreference: js.UndefOr[ReadPreference] = js.undefined)
  extends js.Object

/**
  * Index Information Options
  * @param full           returns the full raw index information.
  * @param readPreference the preferred read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  */
@ScalaJSDefined
class IndexInformationOptions(val full: js.UndefOr[Boolean] = js.undefined,
                              val readPreference: js.UndefOr[ReadPreference] = js.undefined)
  extends js.Object

/**
  * {"name":"listing_activity",
  * "type":"collection",
  * "options":{},
  * "info":{"readOnly":false},
  * "idIndex":{"v":2,"key":{"_id":1},"name":"_id_","ns":"mi.listing_activity"}}
  */
@js.native
trait CollectionInfo extends js.Object {
  val name: String = js.native
  val `type`: String = js.native
  val options: js.Any = js.native
  val info: CollectionInfo_Info = js.native
  val idIndex: CollectionInfo_IdIndex = js.native
}

@js.native
trait CollectionInfo_Info extends js.Object {
  val readOnly: Boolean = js.native
}

@js.native
trait CollectionInfo_IdIndex extends js.Object {
  val v: Int = js.native
  val key: js.Any = js.native
  val name: String = js.native
  val ns: String = js.native
}