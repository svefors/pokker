package sweforce.demo.views

import com.vaadin.ui.{Button, Label, VerticalLayout}
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent

/**
 * Created by sveffa on 28/03/14.
 */
class Role1View extends VerticalLayout with View{
  def enter(event: ViewChangeEvent) = {
    this.removeAllComponents()
    this.addComponent(new Label("Role 1 View"))
    this.addComponent(new Label("Params: " + event.getParameters))
    val button = new Button("Logout")
    this.addComponent(button)
  }
}


