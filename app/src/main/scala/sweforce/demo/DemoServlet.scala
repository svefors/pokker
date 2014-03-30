package sweforce.demo

import com.vaadin.server._
import com.vaadin.annotations.VaadinServletConfiguration
import javax.servlet.annotation.WebServlet
import com.vaadin.ui.{Label, UI}
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import javax.servlet.ServletConfig
import sweforce.vaadin.macwire.WiredVaadinServlet

/**
 * Created by sveffa on 20/03/14.
 */
@WebServlet(name = "DemoServlet", urlPatterns = Array("/*"), asyncSupported = true)
class DemoServlet extends WiredVaadinServlet{

  val modules = new DemoModule {}

}
