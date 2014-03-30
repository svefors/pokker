package sweforce.demo.macwire

import com.softwaremill.macwire.scopes.{ProxyingScope, Scope}
import com.vaadin.ui.UI

/**
 * Created by sveffa on 30/03/14.
 */
class UIScope extends Scope with ProxyingScope{
  private val ATTRIBUTE_NAME = "UISCOPE_ATTRIBUTE_"
  def get[T](key: String, createT: => T) = {
    val uiid = UI.getCurrent.getUIId
    val obj = UI.getCurrent.getSession.getAttribute(ATTRIBUTE_NAME + uiid + "_" + key).asInstanceOf[T]
    if(obj!= null)
      obj
    else{
      val newObj = createT
      UI.getCurrent.getSession.setAttribute(ATTRIBUTE_NAME + uiid + "_" + key, newObj)
      newObj
    }
  }
}
