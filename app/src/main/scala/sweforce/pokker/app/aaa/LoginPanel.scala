package sweforce.pokker.app.aaa

import com.vaadin.ui._
import sweforce.vaadin.ui._
import sweforce.vaadin.event._
import sweforce.vaadin.data._
import sweforce.vaadin.event.observable._


import rx.lang.scala.Observable
import rx.lang.scala.Observable._
import sweforce.vaadin.data.observable.propertyObservable
import rx.lang.scala.subjects.PublishSubject
import scala.util.Try
import java.util.concurrent.Future
import sweforce.pokker.app.SecurityService.Credentials
import sweforce.vaadin.data._
import sweforce.vaadin.ui._


class LoginPanel(val viewModel : LoginPanel#ViewModel) extends VerticalLayout{

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

  viewModel.feedback.subscribe( (cap : String) =>feedback.caption = cap)

  val usernameStream : Observable[String] = username.values//.map(_.asInstanceOf[String])
  val passwordStream : Observable[String] = password.values//.map(_.asInstanceOf[String])

  val credentialsStream : Observable[Credentials] = usernameStream.combineLatest(passwordStream).map( tuple =>
     Credentials(tuple._1, tuple._2)
    )

  val mostRecentCredentials  = credentialsStream.toBlockingObservable.mostRecent()
  signin.clicks.subscribe(event => {
    println(mostRecentCredentials.iterator.next())
  })

  //make it work, make it right...
  /*
  is the feedback actually a part of the LoginPanel?
  In this case the feedback is part of the same panel, but it might be the case that it should be displayed as a
  popup? then it would be better to attach the feedback as a subscription to the view models error source.
   */
  trait ViewModel {

    case class Credentials(username : String, password : String)

    def feedback: Observable[String]

    def login(username : String, password : String)

    val enabled : Observable[Boolean]
  }
}






