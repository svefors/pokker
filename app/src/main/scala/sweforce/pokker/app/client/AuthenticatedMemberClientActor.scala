package sweforce.pokker.app.client

import akka.actor.{Props, Actor}
import javax.servlet.http.HttpSession

/**
 * There should only be one actor. Put the actor ref in the session.
 */
class AuthenticatedMemberClientActor(session : HttpSession) extends Actor{

  def receive = ???

}

object AuthenticatedMemberClientActor {
  def props(session : HttpSession): Props = Props(classOf[AuthenticatedMemberClientActor], session)
}
