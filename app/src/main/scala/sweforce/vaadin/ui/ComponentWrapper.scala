package sweforce.vaadin.ui

import com.vaadin.ui.Component
import rx.lang.scala.{Observable, Observer}
import com.vaadin.server.ClientConnector.DetachEvent
import com.vaadin.server.Resource

/**
 * Add utilitity methods for Component
 */
class ComponentWrapper(val c : com.vaadin.ui.Component) {


  def caption: String = c.getCaption
  def caption_=(caption : String) {c.setCaption(caption)}
  def captionSubscription(obs : Observable[String]) = obs.subscribe( (s: String) => caption = s)

  def enabled: Boolean = c.isEnabled
  def enabled_=(enabled : Boolean) {c.setEnabled(enabled)}
  def enabled_=(obs : Observable[Boolean]) {obs.subscribe((e : Boolean) => enabled = e )}

  def visible: Boolean = c.isVisible
  def visible_=(visible : Boolean) {c.setVisible(visible)}
  def visble_=(obs : Observable[Boolean]) {obs.subscribe((v : Boolean) => visible = v )}

  def readonly: Boolean = c.isReadOnly
  def readonly_=(v : Boolean) {c.setReadOnly(v)}
  def readonly_=(obs : Observable[Boolean]) {obs.subscribe((v : Boolean) => readonly = v )}

  def primaryStyleName: String = c.getPrimaryStyleName
  def primaryStyleName_=(v : String) {c.setPrimaryStyleName(v)}

  def icon: Resource = c.getIcon
  def icon_=(v : Resource) = c.setIcon(v)


}
