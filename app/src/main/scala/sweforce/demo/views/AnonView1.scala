package sweforce.demo.views

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.ui.{UI, Button, Label, VerticalLayout}
import sweforce.vaadin.ui._
import com.vaadin.ui.Button.{ClickEvent, ClickListener}


/**
 * Created by sveffa on 28/03/14.
 */
class AnonView1 extends VerticalLayout with View{


  def enter(event: ViewChangeEvent) = {
    this.removeAllComponents()
    this.addComponent(new Label("View 1"))
    this.addComponent(new Label("Params: " + event.getParameters))
    val view2Button = new Button("View 2")

    view2Button.addClickListener(new ClickListener {

      def buttonClick(event: ClickEvent) = UI.getCurrent.getNavigator.navigateTo("role1/123")

    })
    this.addComponent(view2Button)

  }


}
