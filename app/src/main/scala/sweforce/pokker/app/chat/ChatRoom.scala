package sweforce.pokker.app.chat

import akka.actor.{ActorRef, Actor}
import rx.lang.scala.Subject
import sweforce.pokker.app.chat.ChatRoom.{Join, ChatMessage}
import rx.lang.scala.subjects.ReplaySubject

/**
 * Created by sveffa on 01/03/14.
 */
class ChatRoom extends Actor{

//  var rooms = Map[String, ActorRef]
//  var
  val message = ReplaySubject[ChatMessage]
  var participants = Map[String, ActorRef]()

  def receive = {
    case msg @ ChatRoom.Join(newUser) => {
      participants.foreach {
        case (existingUser,  existingUserActor) => {
          sender ! Join(existingUser)
          existingUserActor forward msg
        }
      }

//      participants = participants + (user -> sender)

      /*

        */

    }
    case ChatRoom.Watch => ???
  }
}
/*
you can:
ask to observe a
 */

object ChatRoom {

  case class Join(user : String)

  case class Leave(user : String)

  case class ChatMessage(from : String, message : String)




  /**
   * subscribe the observer to the list of available rooms.
   */
  case class List(observer : AnyRef)

  /**
   *
   * @param id
   */
  case class Watch(id : String, observer : AnyRef )
}
