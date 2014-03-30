package sweforce.demo.security

import com.vaadin.ui._
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import rx.lang.scala.Observable
import sweforce.pokker.app.SecurityService.Credentials
import sweforce.vaadin.data._
import sweforce.vaadin.ui._
import org.apache.shiro.authc.{IncorrectCredentialsException, UnknownAccountException, UsernamePasswordToken}
import scala.concurrent.Future

/**
 * Created by sveffa on 28/03/14.
 */
class LoginView(val securityContext: SecurityContext) extends VerticalLayout with View {

  /*
  TODO: Consider making LoginView a trait with only functionality. name it LoginComponents. let the layout be handled else where.


   */
  val username = new TextField("Username")
  username.required = true
  addComponent(username)
  val password = new PasswordField("Password")
  password.required = true

  addComponent(password)
  val signin = new Button("Signin")
  addComponent(signin)

  val feedback = new Label
  feedback.setVisible(false)
  addComponent(feedback)

  val usernameStream: Observable[String] = username.values
  //.map(_.asInstanceOf[String])
  val passwordStream: Observable[String] = password.values //.map(_.asInstanceOf[String])

  val credentialsStream: Observable[UsernamePasswordToken] = usernameStream.combineLatest(passwordStream).map(tuple =>
    new UsernamePasswordToken(tuple._1, tuple._2)
  )

  val mostRecentCredentials: Iterable[UsernamePasswordToken] = credentialsStream.toBlockingObservable.mostRecent(new UsernamePasswordToken("",""))


  signin.clicks.subscribe(click => {
    try {
      securityContext.getSubject().login(mostRecentCredentials.iterator.next())
      UI.getCurrent.getNavigator.navigateTo(navigateToState)
      feedback.setVisible(false)
      feedback.setValue("")
    } catch {
      case (uae: UnknownAccountException) => {
        feedback.setValue("Unknown Account")
        feedback.setVisible(true)
      }
      case (ice: IncorrectCredentialsException) => {
        feedback.setValue("Incorrect Credentials")
        feedback.setVisible(true)
      }
    }
  })
  /*
  combine signin with mostRecentCredentials
   */

  var navigateToState: String = _

  def enter(event: ViewChangeEvent) = {
    feedback.setVisible(false)
    navigateToState = event.getViewName + "/" + event.getParameters
  }

}
