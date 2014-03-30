package sweforce.pokker.app.chat

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent

/**
 * Created by sveffa on 01/03/14.
 */
object Chat {

  val room = "chat/room/"
  val list = "chat/list"

  class ViewProvider extends com.vaadin.navigator.ViewProvider {

    def getViewName(viewAndParameters: String) = {
      if (viewAndParameters.startsWith(Chat.room)){
        room
      }else if (viewAndParameters.startsWith(Chat.list)){
        Chat.list
      }else {
        null
      }
    }

    def getView(viewName: String) = {
      if (viewName.equals(Chat.room))
        new RoomView
      else if (viewName.equals(Chat.list))
        new ListView
      else
        null
    }
  }

  class RoomView extends View {

    def enter(event: ViewChangeEvent) {
      val params = event.getParameters
    }
  }

  class ListView extends View {
    def enter(event: ViewChangeEvent) {
      val params = event.getParameters
    }
  }



}
