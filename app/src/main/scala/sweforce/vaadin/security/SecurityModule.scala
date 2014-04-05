package sweforce.demo.security


import org.apache.shiro.session.mgt.SimpleSessionFactory
import org.apache.shiro.mgt.DefaultSecurityManager
import org.apache.shiro.realm.SimpleAccountRealm
import sweforce.vaadin.macwire.VaadinModule
import com.vaadin.navigator.View
import sweforce.vaadin.security.login.LoginView

/**
 * Created by sveffa on 21/03/14.
 */
trait SecurityModule extends VaadinModule {

  import com.softwaremill.macwire.MacwireMacros._

  lazy val securityContext = wire[VaadinSecurityContext]
  lazy val sessionManager = wire[VaadinSessionManager]
  lazy val sessionFactory = wire[SimpleSessionFactory]
  lazy val securityManager = new DefaultSecurityManager(realm)
  lazy val realm: SimpleAccountRealm = wire[SimpleAccountRealm]
  realm.addAccount("test", "test", "test", "role1")

  lazy val loginView: View = ui(wire[LoginView])

  lazy val unauthorizedView: View = ui(wire[UnauthorizedView])

}
