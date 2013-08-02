package sweforce.pokker.app

import com.vaadin.server.VaadinServlet
import javax.servlet.annotation.WebServlet
import com.vaadin.annotations.VaadinServletConfiguration


@WebServlet(name = "PokkerServlet", urlPatterns = Array("/*"), asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = classOf[PokkerUI])
class PokkerServlet extends VaadinServlet {

}
