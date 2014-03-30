package sweforce.demo

import akka.actor.ActorSystem

/**
 * Created by sveffa on 20/03/14.
 */
trait AkkaModule {
  lazy val actorSystem = ActorSystem()
}
