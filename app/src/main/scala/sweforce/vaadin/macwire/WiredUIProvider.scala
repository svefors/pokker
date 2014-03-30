package sweforce.vaadin.macwire

import com.vaadin.navigator.{Navigator, ViewProvider}
import com.vaadin.server.{VaadinRequest, UICreateEvent, UIClassSelectionEvent, UIProvider}
import com.vaadin.ui.{VerticalLayout, UI}

/**
 * Created by sveffa on 30/03/14.
 */
class WiredUIProvider(val viewProvider: ViewProvider) extends UIProvider {

  def getUIClass(event: UIClassSelectionEvent) = classOf[UI]

  override def isPreservedOnRefresh(event: UICreateEvent) = true

  override def createInstance(event: UICreateEvent) = {
    new UI() {
      def init(request: VaadinRequest) = {
        val contentDisplay = new VerticalLayout()
        this.setContent(contentDisplay)
        val navigator = new Navigator(this, contentDisplay)
        navigator.addProvider(viewProvider)
        this.setNavigator(navigator)
      }
    }
  }

}


