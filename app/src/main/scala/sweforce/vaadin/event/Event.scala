package sweforce.vaadin.event

import com.vaadin.ui.{Button, Component}
import com.vaadin.shared.Connector
import com.vaadin.server.ClientConnector

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 11/28/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
trait Event extends Serializable{

}

case class ConnectorEvent(source : Connector) extends Event {

}

case class ComponentEvent(component : Component) extends Event

case class FocusEvent(source : Component) extends Event

case class BlurEvent(source : Component) extends Event

//TODO add mouse event details later,
case class ButtonClickEvent(button : Button) extends Event

case class AttachEvent(source : ClientConnector) extends Event

case class DetachEvent(source : ClientConnector) extends Event


