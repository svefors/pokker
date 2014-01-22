package sweforce.pokker.app

import akka.actor.Actor
import org.apache.shiro.crypto.SecureRandomNumberGenerator
import java.security.SecureRandom
import java.util.UUID

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 12/29/13
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
class SecurityService extends Actor{
  import SecurityService._
  import scala.concurrent.duration._


  //var users : Map[String, String]= Map() + ("bob" -> "asdf") + ("alice" -> "asdf")
  var users = Set[Credentials]() + Credentials("bob", "asdf") + Credentials("alice", "asdf")

  var validTokens = Set[String]()

  def receive = {
    case Login(credentials) => {
      if (users(credentials)){
        val token = UUID.randomUUID().toString
        validTokens += token
        sender ! Authenticated(token)
      }else{
        sender ! InvalidLogin
      }
    }
    case Logout(token) => {
      validTokens -= token
      sender ! TokenExpired
    }
    case CheckToken(token) => {
      if (validTokens(token))
        sender ! TokenValidated
      else
        sender ! TokenExpired
    }
  }
}

object SecurityService {

  case class Credentials(username : String, password : String)

  case class Login(credentials : Credentials)

  case class Logout(token : String)

//  case class
  case class TokenExpired(token : String)

  case class CheckToken(token : String)

  case class Authenticated(token : String)

  case object TokenValidated

  case object InvalidLogin

}


