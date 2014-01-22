package sweforce.pokker.app

import com.vaadin.ui._
import com.vaadin.server.VaadinRequest
import com.vaadin.data.util.ObjectProperty
import scala.concurrent.{Promise, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.async.Async.{async, await}
import com.vaadin.ui.Button.{ClickEvent, ClickListener}
import com.vaadin.shared.communication.PushMode
import com.vaadin.annotations.Push
import rx.{Observer, Observable}
import com.vaadin.data.Property
import sweforce.pokker.app.aaa.LoginPanel

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 8/1/13
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Push
class PokkerUI extends UI{

  def init(request: VaadinRequest) {
    val layout = new VerticalLayout()
    this.setContent(layout);
    layout.addComponent(new Label("Hello World!"));
    /*
    I want a property that is built on top of a reactive extension.
    I want to invoke ui.access
     */
    val txt = new TextField("apa")
    val property = new ObjectProperty[String]("")
    txt.setPropertyDataSource(property)
    txt.setValue("asdf")
    txt.setImmediate(true)
    layout.addComponent(txt)
    var i = 0
    val p = Promise[String]()
    p.future.onComplete( x => access(
      new Runnable {
        def run() = {
          property.setValue("foo" + i)
          i += 1
        }
      }))

    val button = new Button("just a button")
    button.setEnabled(true)
    button.addClickListener(new ClickListener {

      def buttonClick(event: ClickEvent){
        async{
          Thread.sleep(1000)
          p.success("Qwerty")
        }
      }
    })
    button.setImmediate(true)
    layout.addComponent(button)
    layout.addComponent(new LoginPanel)
  }

  /*
  There is a lot of magic happening in Vaadin.
  Somethings might happen on the client.

  Design Goals
  how do I want this to work?
  define the ui component/widget
  - it should only deal with layout and "superficial" concerns
  - behavior should "bound" to observables
  - there is some form of triad or middle man cause the widget need not know
  about how the behavior works.
  - Let's say there is a backend system, or an engine that define the rules of the game
  ...

  bind between field and some observable
  loginEnabled.onNext(
   */
//  object LoginPanel extends VerticalLayout {
//    val username = new TextField("username")
//    val password = new PasswordField("password")
//    val loginButton = new Button("login")
//    addComponents(username, password)
//
//  }
//
//  trait ObserverProperty[T] extends Property[T] {
//    val observable : Observable[T]
//    def foo(observable : Observable[T], property : Property[T])
//  }
//  object Component {
//    trait Wrapper {
//
//    }
//  }
}
