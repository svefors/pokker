package sweforce.vaadin

import com.vaadin.server.ClientConnector
import rx.lang.scala.{Subscription, Observable}
import com.vaadin.server.ClientConnector.{DetachListener, AttachListener}

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 12/1/13
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
package object server {

  implicit def sizeableWrapper( p : com.vaadin.server.Sizeable) = new SizeableWrapper(p)

  implicit def intToMeasureOption(value: Int): MeasureExtent = new MeasureExtent(value)

  implicit def doubleToMeasureOption(value: Double): MeasureExtent = new MeasureExtent(value)

  implicit def clientConnectorWrapper(c : com.vaadin.server.ClientConnector) = new ClientConnectorWrapper(c)

}
