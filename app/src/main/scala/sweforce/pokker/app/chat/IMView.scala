package sweforce.pokker.app.chat

import com.vaadin.ui._
import com.vaadin.navigator.{ViewProvider, View}
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.navigator.Navigator.StaticViewProvider

/**
 * Created by sveffa on 06/03/14.
 */
class IMView extends HorizontalSplitPanel with View with ViewProvider{

  val left = new VerticalLayout()
  val right = new VerticalLayout()
  left.addComponent(new Label("Contacts"))
  left.addComponent(new Label("Recent"))

  setFirstComponent(left)
  setSecondComponent(right)


  def getViewName(viewAndParameters: String) =
    if (viewAndParameters == null) null
    else if (viewAndParameters.startsWith("im")) "im"
    else null

  def getView(viewName: String) = if (viewName.equals("im")) this else null

  def enter(event: ViewChangeEvent)  {
    event.getViewName
  }
}
