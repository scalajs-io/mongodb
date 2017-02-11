package io.scalajs.npm.mongodb

import io.scalajs.nodejs._
import io.scalajs.npm.mongodb.CursorTest.Sample
import io.scalajs.util.JSONHelper._
import org.scalatest.FunSpec

import scala.concurrent.Promise
import scala.concurrent.duration._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cursor Tests
  * @author lawrence.daniels@gmail.com
  */
class CursorTest extends FunSpec with MongoDBTestSupport {

  describe("Cursor") {

    it("supports streaming") {

      withMongo("Cursor") { db =>

        for {
          coll <- db.collectionFuture("cursor_test")

          // remove any existing docs
          _ <- coll.deleteMany(doc()).toFuture

          // insert our new docs
          iwr <- coll.insertMany(js.Array(new Sample(a = 1), new Sample(a = 2), new Sample(a = 3))).toFuture

          data <- {
            // did we get at least 3 records?
            if (iwr.result.n < 3) throw new IllegalStateException("At least 3 records were expected")

            // get the results using a find stream
            val promise = Promise[Unit]()
            val cursor = coll.find(doc()).stream(StreamTransform((doc: Sample) => doc.toJson))
            cursor
              .onData((doc: String) => info(doc))
              .onError(error => promise.failure(new RuntimeException(error.message)))
              .onEnd(() => promise.success(()))

            // if the promise hasn't complete in 1 sec, trigger it.
            setTimeout(() => if (!promise.isCompleted) promise.success(()), 1.second)

            promise.future
          }
        } yield data

      }

    }

  }

}

/**
  * Cursor Test Companion
  * @author lawrence.daniels@gmail.com
  */
object CursorTest {

  @ScalaJSDefined
  class Sample(var _id: js.UndefOr[ObjectID] = js.undefined,
               var a: js.UndefOr[Int] = js.undefined)
    extends js.Object

}
