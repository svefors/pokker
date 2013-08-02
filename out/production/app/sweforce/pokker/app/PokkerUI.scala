package sweforce.pokker.app

import com.vaadin.ui.{Label, VerticalLayout, UI}
import com.vaadin.server.VaadinRequest


/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 8/1/13
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
class PokkerUI extends UI{

  def init(request: VaadinRequest) {
    val layout = new VerticalLayout()
    this.setContent(layout);
    layout.addComponent(new Label("Hello World!"));
  }
}
