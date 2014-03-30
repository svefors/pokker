package sweforce.demo.security

import com.vaadin.server.VaadinSession
import org.apache.shiro.mgt.SecurityManager
import org.apache.shiro.subject.Subject
import java.util.UUID
;

/**
 * Created by sveffa on 21/03/14.
 */
class VaadinSecurityContext(val securityManager : SecurityManager) extends SecurityContext{


  /**
   * Assumes there is a valid vaadin session available
   * @return the subject, will neter return null
   */
  def getSubject() = {
    val session = VaadinSession.getCurrent
    if (session == null)
      throw new IllegalStateException("Unable to locate VaadinSession")
    val subject = session.getAttribute(VaadinSecurityContext.SUBJECT_ATTRIBUTE).asInstanceOf[Subject]
    if (subject != null)
      subject
    else{
      val anon = new Subject.Builder(securityManager).buildSubject()
      session.setAttribute(VaadinSecurityContext.SUBJECT_ATTRIBUTE, anon)
      anon
    }
  }

}

object VaadinSecurityContext {
  private val SUBJECT_ATTRIBUTE = "VaadinSecurityContext.subject" + UUID.randomUUID().toString
}
