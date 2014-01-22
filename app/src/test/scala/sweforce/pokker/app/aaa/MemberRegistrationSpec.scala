package sweforce.pokker.app.aaa

import org.scalatest.{GivenWhenThen, FeatureSpec}

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 8/31/13
 * Time: 6:51 AM
 * To change this template use File | Settings | File Templates.
 */
class MemberRegistrationSpec extends FeatureSpec with GivenWhenThen{

  feature ("A user can register as a member with an email address") {

    scenario("A user applies for membership with an email address should be sent a confirmation email") {
      Given("Bob is applying for membership")
      When("he submits the required details: email (bob@example.org), loginid (bob) and password (bobsyouruncle)")
      Then("an inactive account should be created")
      And("he should receive be sent a confirmation email")
    }

    scenario("A user completes registration by confirming their email address") {
      Given("Bob has applied for membership")
      And("he has an inactive account with credentials")
      And("he has a valid but unused confirmation token")
      When("he uses the confirmation token")
      Then("he should be sent a welcome message")
      And("his account should be activated")
      And("he can login")
    }
  }



  feature ("A user can register as a member using their google credentials") (pending)
  feature ("A user can register as a member using their facebook credentials") (pending)

}
