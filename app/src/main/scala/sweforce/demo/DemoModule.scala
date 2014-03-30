package sweforce.demo

import sweforce.demo.views.{Role1View, AnonView1}
import sweforce.vaadin.security.viewprovider.{Authc, Anon, SecureViewProvider}
import SecureViewProvider.{ViewAccessControl, Mapping}
import sweforce.demo.security._
import com.vaadin.navigator.{ViewProvider, View}
import com.vaadin.server.UIProvider
import sweforce.vaadin.macwire.VaadinModule


/**
 * Created by sveffa on 20/03/14.
 */
trait DemoModule extends AkkaModule with VaadinModule with SecurityModule {
  import com.softwaremill.macwire.MacwireMacros._

  lazy val anonView1 = ui(wire[AnonView1])

  lazy val role1View = ui(wire[Role1View])

  val fragmentViewMappings : List[Mapping] = List[Mapping](
    "role1" -> role1View,
    "anon"  -> anonView1,
    ""  -> anonView1,
    "login"  -> loginView
  )

  val viewAccessControlList : List[ViewAccessControl] = List[ViewAccessControl](
    "role1" -> Seq(Authc),
    "" -> Seq(Anon)
  )

  def viewProvider : ViewProvider = new SecureViewProvider(securityContext, viewAccessControlList, fragmentViewMappings,
    loginView, unauthorizedView)



//  def uiProvider = wire[DemoUIProvider]

}
