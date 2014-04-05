package sweforce.vaadin.security.login

import com.vaadin.ui._
import rx.lang.scala.Observable
import org.apache.shiro.authc.{IncorrectCredentialsException, UnknownAccountException, UsernamePasswordToken}
import sweforce.vaadin.data._
import sweforce.vaadin.ui._
import scala.util.{Success, Failure, Try}
import rx.lang.scala.subjects.PublishSubject
import sweforce.demo.security.SecurityContext
import org.apache.shiro.subject.Subject

/**
 * Created by sveffa on 31/03/14.
 */
trait LoginComponents {
  val securityContext: SecurityContext

  val username = new TextField("Username")
  username.required = true

  val password = new PasswordField("Password")
  password.required = true

  val signin = new Button("Signin")

  val feedback = new Label
  feedback.setVisible(false)

  val usernameStream: Observable[String] = username.values

  val passwordStream: Observable[String] = password.values

  val credentialsStream: Observable[UsernamePasswordToken] = usernameStream.combineLatest(passwordStream).map(tuple =>
    new UsernamePasswordToken(tuple._1, tuple._2)
  )

  val mostRecentCredentials: Iterable[UsernamePasswordToken] = credentialsStream.toBlockingObservable.mostRecent(new UsernamePasswordToken("", ""))

  signin.clicks.subscribe(click => {
    try {
      securityContext.getSubject().login(mostRecentCredentials.iterator.next())
      loginAttempts.onNext(Success(securityContext.getSubject()))
    } catch {
      case (e: Exception) => {
        loginAttempts.onNext(Failure(e))
      }
    }
  })
  /*
  This is really a PublishSubject.
  emits only thos items that are emitted by the source observable(s) subsequent to the time of subscription.
  remember to unsubscribe after you are done...
   */
  val loginAttempts: PublishSubject[Try[Subject]] = PublishSubject[Try[Subject]]()

  loginAttempts.subscribe({
    _ match {
      case Success(subject) => {
        feedback.setValue("")
        feedback.setVisible(false)
      }
      case Failure(uae: UnknownAccountException) => {
        feedback.setValue("Unknown Account")
        feedback.setVisible(true)
      }
      case Failure(uae: IncorrectCredentialsException) => {
        feedback.setValue("Incorrect Credentials")
        feedback.setVisible(true)
      }
    }
  })

}
