package sweforce.demo.security

import org.apache.shiro.session.mgt._
import java.util.UUID
import com.vaadin.server.VaadinSession

/**
 * Created by sveffa on 22/03/14.
 */
class VaadinSessionManager(val sessionFactory : SessionFactory) extends SessionManager{


  def start(context: SessionContext) = {
    val vaadinSession = VaadinSession.getCurrent
    if (vaadinSession == null)
      throw new IllegalStateException("Unable to locate VaadinSession")
    val shiroSession = sessionFactory.createSession(context).asInstanceOf[SimpleSession]
    shiroSession.setId(UUID.randomUUID().toString)
    vaadinSession.setAttribute(VaadinSessionManager.SESSION_ATTRIBUTE_PREFIX + shiroSession.getId, shiroSession)
    shiroSession
  }

  def getSession(key: SessionKey) = {
    val vaadinSession = VaadinSession.getCurrent
    val attributeName = VaadinSessionManager.SESSION_ATTRIBUTE_PREFIX + key
    if (vaadinSession != null){
      val shiroSession = vaadinSession.getAttribute(attributeName).asInstanceOf[SimpleSession]
      if (shiroSession != null && shiroSession.isValid){
        shiroSession
      }else{
        vaadinSession.setAttribute(attributeName, null)
        null
      }
    }else{
      null
    }
  }

}

object VaadinSessionManager {
  private val SESSION_ATTRIBUTE_PREFIX = "VAADIN_SESSION_MANAGER.session." + UUID.randomUUID().toString
}
