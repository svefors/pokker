package sweforce.vaadin.macwire

import com.vaadin.server.{DefaultDeploymentConfiguration, DefaultSystemMessagesProvider, SystemMessagesProvider, UIProvider}
import sweforce.demo.macwire.{VaadinSessionScope, UIScope}
import scala.reflect.ClassTag
import com.vaadin.navigator.ViewProvider

/**
 * Created by sveffa on 20/03/14.
 */
trait VaadinModule {

  import com.softwaremill.macwire.MacwireMacros._

  lazy val systemMessagesProvider = DefaultSystemMessagesProvider.get()

  lazy val ui = new UIScope

  lazy val session = new VaadinSessionScope

  lazy val uiProvider : UIProvider = wire[WiredUIProvider]

  def viewProvider : ViewProvider

}
