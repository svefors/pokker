package sweforce.pokker.app.aaa

import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 8/31/13
 * Time: 8:08 AM
 * To change this template use File | Settings | File Templates.
 */
class AuthenticationSpec extends FeatureSpec with GivenWhenThen {

  feature("A client can authenticate with username/password") {
    scenario("a client should receive a MemborActorRef upon successful authentication") {
      Given("bob is a username in the system")
      And("his password is 1qazxsw2")
      When("the client authenticates with bob/1qazxsw2")
      Then("the client should recieve a MemberActorRef")
    }

    scenario("a not authenticatd client should receive a AuthenticationActorRef when entering the system") {
      Given("a not authenticated client")
      When("the client knocks on the door ")
      Then("the client should recieve a AuthenticationActorRef")
    }

    scenario("a user can use form based authentication"){

    }

  }


}
