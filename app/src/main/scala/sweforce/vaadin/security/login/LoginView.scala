package sweforce.vaadin.security.login

import com.vaadin.ui._
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import rx.lang.scala.Observable
import sweforce.pokker.app.SecurityService.Credentials
import sweforce.vaadin.data._
import sweforce.vaadin.ui._
import org.apache.shiro.authc.{IncorrectCredentialsException, UnknownAccountException, UsernamePasswordToken}
import scala.concurrent.Future
import sweforce.demo.security.SecurityContext
import scala.util.{Failure, Success}

/**
 * Created by sveffa on 28/03/14.
 */
class LoginView(val securityContext: SecurityContext) extends VerticalLayout with View with LoginComponents {

  addComponent(username)
  addComponent(password)
  addComponent(signin)
  addComponent(feedback)

  var navigateToState: String = _

  loginAttempts.subscribe(_ match {
    case Success(subject) => UI.getCurrent.getNavigator.navigateTo(navigateToState)
    case Failure(_) => //do nothing
  })

  def enter(event: ViewChangeEvent) = {
    navigateToState = event.getViewName + "/" + event.getParameters
  }

}
