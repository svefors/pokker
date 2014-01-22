package sweforce.pokker.app

import com.vaadin.server._
import javax.servlet.annotation.WebServlet
import com.vaadin.annotations.VaadinServletConfiguration
import javax.servlet.ServletConfig
import akka.actor._

import java.util.UUID
import scala.concurrent.Await
import scala.util.Success
import com.vaadin.ui.UI
import scala.Some
import com.vaadin.navigator.Navigator



@WebServlet(name = "PokkerServlet", urlPatterns = Array("/*"), asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = classOf[PokkerUI])
class PokkerServlet extends VaadinServlet {

  val system = ActorSystem()

  var pokkerHouse : ActorRef = _


  override def servletInitialized() {
    super.servletInitialized()

    system.actorOf(PokerHouse.props(this.getService))

  }




  class PokerHouse(service : VaadinServletService) extends Actor with ActorLogging {
    import PokerHouse._

    service.addSessionInitListener(new SessionInitListener {
      def sessionInit(event: SessionInitEvent) {
        //event.getSession.addUIProvider()
        val token = UUID.randomUUID().toString
        event.getSession.setAttribute(VAADIN_VISITOR_CHILD_SESSION_ATTR_NAME, token)
        context.actorOf(VaadinSessionController.props(event.getSession), token)
      }
    })

    service.addSessionDestroyListener(new SessionDestroyListener {
      def sessionDestroy(event: SessionDestroyEvent) = {
        val childName = event.getSession.getAttribute(VAADIN_VISITOR_CHILD_SESSION_ATTR_NAME)
        if (childName == null) {
          context.child(childName.toString) match {
            case Some(child) => child ! PoisonPill
          }
        }
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
