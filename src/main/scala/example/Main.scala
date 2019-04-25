package example

import util.Properties

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.concurrent.Future

object Main extends App {
  implicit val system = ActorSystem()
  implicit val ec = system.dispatcher
  implicit val materializer = ActorMaterializer()

  val routes = pathPrefix("ping") {
    get {
      complete("pong")
    }
  }

  val port = Properties.envOrElse("PORT", "8080").toInt

  val bindingFuture: Future[ServerBinding] = Http().bindAndHandle(routes, "127.0.0.1", port)
}