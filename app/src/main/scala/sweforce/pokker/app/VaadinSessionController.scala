package sweforce.pokker.app

import com.vaadin.server._
import akka.actor.{Props, ActorLogging, Actor}
import scala.concurrent.Await
import scala.util.Success
import com.vaadin.ui.UI
import com.vaadin.navigator.Navigator
import scala.util.Success
import scala.Some

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 12/29/13
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
class VaadinSessionController(val session : VaadinSession) extends Actor with ActorLogging {
  import VaadinSessionController._
  import akka.pattern.ask
  import scala.concurrent.duration._

  session.setAttribute(SESSION_ATTR_NAME, self)

  val uiProvider = new UIProvider {
    def getUIClass(event: UIClassSelectionEvent) = classOf[PokkerUI]
    val sessionController = self
    override def createInstance(event: UICreateEvent) = {
      //TODO make it a typed actor
      val ui = (sessionController ? CreateUI(event))(10.milliseconds)
      Await.result(ui, 10.milliseconds)
      ui.value match {
        case Some(success) => success match {
          case Success(pokker) => pokker.asInstanceOf[UI]
        }

      }
    }
  }
  session.addUIProvider(uiProvider)
  def receive = {
    case CreateUI(event) => {
      /*
       * Create a new UI without anything in it...
       */
      val ui = new UI() {
        def init(request: VaadinRequest){}
      }
      val navigator = new Navigator(ui, ui)
      //need to add view provider to navigator
      navigator.addProvider(???)

      sender ! ui
    }
  }
}

object VaadinSessionController{

  case class CreateUI(event: UICreateEvent)

  val SESSION_ATTR_NAME = "VAADIN_VISITOR_ACTOR_REF"

  def props(session : VaadinSession) = Props(new VaadinSessionController(session))

}
