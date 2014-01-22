package sweforce.vaadin

import com.vaadin.event.FieldEvents
import rx.lang.scala.{Subscription, Observable}
import com.vaadin.event.FieldEvents.{BlurListener, BlurEvent, FocusEvent, FocusListener}
import com.vaadin.event.Action.ShortcutNotifier
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.server.ClientConnector

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 12/3/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
package object event {

  implicit def focusEventWrapper(event : FocusEvent) = FocusEvent(event.source)

  implicit def blurEventWrapper(event : BlurEvent) = BlurEvent(event.source)

  implicit def buttonClickEventWrapper(event : ClickEvent) = ButtonClickEvent(event.getButton)

  implicit def attachEventWrapper(event : ClientConnector.AttachEvent) = AttachEvent(event.getConnector)

  implicit def detachEventWrapper(event : ClientConnector.DetachEvent) = DetachEvent(event.getConnector)
}
