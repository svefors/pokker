package sweforce.pokker.app

import org.eclipse.jetty.server.{HttpConnectionFactory, ServerConnector, Server}
import org.eclipse.jetty.webapp.WebAppContext
import org.eclipse.jetty.util.thread.QueuedThreadPool


object StartJetty extends App {

  val threadPool = new QueuedThreadPool()
  threadPool.setMaxThreads(10)
  val jettyServer = new Server(threadPool)
  val classlist = org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(jettyServer);
  classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration",
    "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
  classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
    "org.eclipse.jetty.annotations.AnnotationConfiguration");
  val connector = new ServerConnector(jettyServer);
  //5 minutes idle time
  connector.setIdleTimeout(1000 * 60 * 5)
  connector.setSoLingerTime(-1)
  connector.setPort(8082)
  val connectionFactory = new HttpConnectionFactory()
  connector.addConnectionFactory(connectionFactory)
  jettyServer.addConnector(connector)



  val webContext = new WebAppContext();
  /*
  Fixes using annotations, see: https://bugs.eclipse.org/bugs/show_bug.cgi?id=404176#c5
  for Intellij
   */
  webContext.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/out/production/.*");
  webContext.setContextPath("/pokker")
  webContext.setWar("app/src/main/webapp")
  jettyServer.setHandler(webContext)
  try {
    jettyServer.start()
    while (System.in.available() == 0)
      Thread.sleep(5000)
    jettyServer.stop()
    jettyServer.join()
  } catch {
    case e: Exception => {
      e.printStackTrace()
      System.exit(100)
    }
  }

}
