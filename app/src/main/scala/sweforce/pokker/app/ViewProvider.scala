package sweforce.pokker.app

import akka.actor.Actor


/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 12/29/13
 * Time: 11:34 PM
 * To change this template use File | Settings | File Templates.
 */
class ViewProvider extends Actor{

  def receive = anonymous

  def authenticated = ???

  def anonymous = {
    /*
    if the view requires login, give them the login view.
        give the login view instructions on where to go next?
        or have an actor react to the login message?
     */

    /*
     * All views that need to contact an actor should be given an actorRef.
     * Actors should be able to push data to the view?
     * Then we don't need to have typed actors?
     */
    ???
  }
}

object ViewProvider {
    def client() : com.vaadin.navigator.ViewProvider = new com.vaadin.navigator.ViewProvider {
      def getViewName(viewAndParameters: String) = viewAndParameters

      def getView(viewName: String) = ???
    }
}
