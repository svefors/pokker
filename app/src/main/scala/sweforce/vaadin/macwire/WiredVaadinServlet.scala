package sweforce.vaadin.macwire

import com.vaadin.server.{SessionInitEvent, SessionInitListener, VaadinServlet}

/**
 * Created by sveffa on 30/03/14.
 */
abstract class WiredVaadinServlet extends VaadinServlet{

  val modules : VaadinModule

  override def servletInitialized() = {
      super.servletInitialized()
      this.getService.addSessionInitListener(new SessionInitListener {
          def sessionInit(event: SessionInitEvent) = {
            event.getSession.addUIProvider(modules.uiProvider)
          }
        })

        this.getService.setSystemMessagesProvider(modules.systemMessagesProvider)
    }
}
