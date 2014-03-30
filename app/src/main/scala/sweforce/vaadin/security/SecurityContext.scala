package sweforce.demo.security

import org.apache.shiro.subject.Subject

/**
 * Created by sveffa on 22/03/14.
 */
trait SecurityContext {

  def getSubject() : Subject


}
