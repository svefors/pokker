package sweforce.pokker.app.chat.actor

import akka.persistence.EventsourcedProcessor
import java.util.{UUID, Date}
import sweforce.pokker.app.chat.actor.ChatUser.{Online, MessageDelivered, Message}
import akka.actor.SupervisorStrategy.Stop
import akka.actor.ReceiveTimeout
import akka.contrib.pattern.ShardRegion.Passivate

/**
 * Created by sveffa on 05/04/14.
 */
class ChatUser extends EventsourcedProcessor {


  context.setReceiveTimeout(3600.seconds)

  val foo : Any = "asdf"

  foo match {
    case Online => ???
  }

  val receiveRecover: Receive = {
    //should load up
  }

  val online: Receive = {
    case message@Message => {

      //forward message to inbox clients.
      //send reply that message was delivered
      context.parent ! MessageDelivered(message.id)
    }
    case ReceiveTimeout ⇒ context.parent ! Passivate(stopMessage = Stop)
    case Stop ⇒ context.stop(self)
  }
}

object ChatUser {

  sealed trait Event

  case class Message(id: UUID, from: UUID, to: UUID, message: String, sent: Date, conversationId: Option[UUID]) extends Event

  case class MessageDelivered(messageId: UUID) extends Event

  case class FriendRequest(from: UUID) extends Event

  case class FriendsConnected(from: UUID, to: UUID) extends Event

  case class StatusChange(user: UUID, status: Status) extends Event

  sealed trait Status

  case object Online extends Status

  case object Offline extends Status

}
