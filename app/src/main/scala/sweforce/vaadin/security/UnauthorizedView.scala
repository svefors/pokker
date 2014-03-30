package sweforce.demo.security

import com.vaadin.ui.{Label, VerticalLayout}
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent

/**
 * Created by sveffa on 30/03/14.
 */
class UnauthorizedView extends VerticalLayout with View{
  def enter(event: ViewChangeEvent) = {
    this.removeAllComponents()
    this.addComponent(new Label("you are not authorized"))
  }
}
