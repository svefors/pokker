package sweforce.demo.macwire

import com.softwaremill.macwire.scopes.{ProxyingScope, ScopeStorage, Scope}
import scala.reflect.ClassTag
import com.vaadin.server.VaadinSession

/**
 * Assumes there is a VaadinSession in scope
 */
class VaadinSessionScope extends Scope with ProxyingScope {

  private val STORAGE_ATTRIBUTENAME = "VaadinSessionScope.SCOPE_STORAGE_"

  def get[T](key: String, createT: => T) = {
    //perhaps not very thread safe
    val obj = VaadinSession.getCurrent.getAttribute(STORAGE_ATTRIBUTENAME + key).asInstanceOf[T]
    if (obj != null)
      obj
    else {
      val newObj = createT
      VaadinSession.getCurrent.setAttribute(STORAGE_ATTRIBUTENAME + key, newObj)
      newObj
    }
  }
}




