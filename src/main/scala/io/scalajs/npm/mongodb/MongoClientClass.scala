package io.scalajs.npm.mongodb

import scala.scalajs.js

/**
  * Mongo Client Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoClientClass extends js.Object {

  def connect(url: String, callback: MongoCallback1[Db]): Unit = js.native

}

/**
  * Mongo Client Class Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoClientClass {

  /**
    * Mongo Client Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoClientClassExtensions(val `class`: MongoClientClass) extends AnyVal {

    @inline
    def connectAsync(url: String): js.Promise[Db] = promiseMongoCallback1[Db](`class`.connect(url, _))

  }

}