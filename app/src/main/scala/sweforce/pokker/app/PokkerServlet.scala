package sweforce.pokker.app

import com.vaadin.server._
import javax.servlet.annotation.WebServlet
import com.vaadin.annotations.{Push, VaadinServletConfiguration}
import javax.servlet.ServletConfig
import akka.actor._

import java.util.UUID
import scala.concurrent.Await
import scala.util.Success
import com.vaadin.ui.UI
import scala.Some
import com.vaadin.navigator.Navigator
import com.vaadin.shared.communication.PushMode
import com.vaadin.shared.ui.ui.Transport


//@WebServlet(name = "PokkerServlet", urlPatterns = Array("/*"), asyncSupported = true)
//@VaadinServletConfiguration(productionMode = false, ui = classOf[PokkerUI])
class PokkerServlet extends VaadinServlet {

  val system = ActorSystem()

  var pokkerHouse : ActorRef = _


  override def servletInitialized() {
    super.servletInitialized()

    system.actorOf(PokerHouse.props(this.getService))

  }






  class PokerHouse(service : VaadinServletService) extends Actor with ActorLogging {
    import PokerHouse._
    val actorRef = self

//    object uiProvider extends UIProvider {
//
//      def getUIClass(event: UIClassSelectionEvent) = classOf[PokkerUI]
//
//      override def createInstance(event: UICreateEvent) = new PokkerUI(actorRef)
//
//      override def getPushMode(event: UICreateEvent) = PushMode.AUTOMATIC
//
//      override def isPreservedOnRefresh(event: UICreateEvent) = true
//
//      override def getPushTransport(event: UICreateEvent) = Transport.WEBSOCKET
//    }


    service.addSessionInitListener(new SessionInitListener {
      def sessionInit(event: SessionInitEvent) {
//        event.getSession.addUIProvider(uiProvider)
      }
    })


    service.addSessionDestroyListener(new SessionDestroyListener {
      def sessionDestroy(event: SessionDestroyEvent) = {

      }
    })

    def receive = {
      ???
    }
  }



  object PokerHouse {
    val VAADIN_VISITOR_CHILD_SESSION_ATTR_NAME = "VAADIN_VISITOR_CHILD_SESSION_ATTR_NAME"

    def props(service : VaadinServletService) : Props = Props(new PokerHouse(service))

  }
}
