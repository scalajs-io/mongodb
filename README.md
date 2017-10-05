MongoDB API for Scala.js
================================
[mongodb](http://mongodb.github.io/node-mongodb-native/2.2/api/) - The official MongoDB driver for Node.js.

### Description

The official MongoDB driver for Node.js. Provides a high-level API on top of mongodb-core that is meant for end users.

<a name="build_requirements"></a>
### Build Requirements

* [ScalaJs.io v0.3.x](https://github.com/scalajs-io/scalajs-io)
* [SBT v0.13.16](http://www.scala-sbt.org/download.html)

<a name="building_sdk"></a>
### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

### Examples

```scala
import io.scalajs.JSON
import io.scalajs.nodejs._
import io.scalajs.npm.mongodb._
import scalajs.js


val url = "mongodb://localhost:27017/test"
MongoClient.connect(url, (err, db) => {
    val col = db.collection("streams")
    
    // Insert some documents
    col.insertMany(js.Array(new Sample(a = 1), new Sample(a = 2), new Sample(a = 3)), (err, iwr) => {        
        // Get the results using a find stream
        val stream = col.find[Sample](doc()).stream()
        stream.onData[Sample](doc => console.log(doc))
        stream.onEnd(() => db.close())
    })
})


class Sample(var _id: js.UndefOr[ObjectID] = js.undefined, 
             var a: js.UndefOr[Int] = js.undefined) 
  extends js.Object
```

### Artifacts and Resolvers

To add the `MongoDB` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "mongodb" % "0.4.2"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
