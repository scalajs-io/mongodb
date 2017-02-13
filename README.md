MongoDB API for Scala.js
================================
[mongodb](http://mongodb.github.io/node-mongodb-native/2.2/api/) - The official MongoDB driver for Node.js.

#### Description

The official MongoDB driver for Node.js. Provides a high-level API on top of mongodb-core that is meant for end users.

<a name="build_requirements"></a>
#### Build Requirements

* [ScalaJs.io v0.3.x](https://github.com/ldaniels528/scalajs.io)
* [SBT v0.13.13](http://www.scala-sbt.org/download.html)

<a name="building_sdk"></a>
#### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

#### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

#### Examples

```scala
import io.scalajs.JSON
import io.scalajs.nodejs._
import io.scalajs.npm.mongodb._
import scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

val url = "mongodb://localhost:27017/test"
MongoClient.connect(url, (err, db) => {
    val col = db.collection("streams")
    
    // Insert some documents
    col.insertMany(js.Array(new Sample(a = 1), new Sample(a = 2), new Sample(a = 3)), (err, iwr) => {        
        // Get the results using a find stream
        val cursor = col.find(doc()).stream(StreamTransform((doc: Sample) => JSON.stringify(doc)))
        cursor.onData((doc: Sample) => console.log(doc))
        cursor.onEnd(() => db.close())
    })
})

@ScalaJSDefined
class Sample(var _id: js.UndefOr[ObjectID] = js.undefined, 
             var a: js.UndefOr[Int] = js.undefined) 
  extends js.Object
```

#### Artifacts and Resolvers

To add the `MongoDB` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "mongodb" % "2.2.22"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
