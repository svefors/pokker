package sweforce.pokker.app

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.ui.{Notification, HorizontalLayout}

/**
 * Created by sveffa on 06/03/14.
 */
class StartPageView extends HorizontalLayout with View{
  def enter(event: ViewChangeEvent) = {
    Notification.show("Welcome!")
  }
}
