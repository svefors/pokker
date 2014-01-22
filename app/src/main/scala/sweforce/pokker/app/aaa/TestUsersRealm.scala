package sweforce.pokker.app.aaa

import org.apache.shiro.realm.SimpleAccountRealm
import java.util.UUID

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 9/15/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
object TestUsersRealm extends SimpleAccountRealm {
  val alicePassword = "1qazXSW2"// UUID.randomUUID().toString
  val bobPassword = "1qazXSW2"//UUID.randomUUID().toString
  val celiaPassword = "1qazXSW2"//UUID.randomUUID().toString
  val davePassword =  "1qazXSW2"//UUID.randomUUID().toString
  val evePassword =  "1qazXSW2"//UUID.randomUUID().toString
  val frankPassword =  "1qazXSW2"//UUID.randomUUID().toString
  val ginaPassword =  "1qazXSW2"//UUID.randomUUID().toString
  val harryPassword =  "1qazXSW2"//UUID.randomUUID().toString
  val irenePassword =  "1qazXSW2"//UUID.randomUUID().toString
  val joePassword =  "1qazXSW2"//UUID.randomUUID().toString

  addAccount("alice", alicePassword, "member")
  addAccount("bob", bobPassword, "member")
  addAccount("celia", celiaPassword, "member")
  addAccount("dave", davePassword, "member")
  addAccount("eve", evePassword, "member")
  addAccount("frank", frankPassword, "member")
  addAccount("gina", ginaPassword, "member")
  addAccount("harry", harryPassword, "member")
  addAccount("irene", irenePassword, "member")
  addAccount("joe", joePassword, "member")
}
