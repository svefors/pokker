package sweforce.vaadin.server

import rx.lang.scala.{Subscription, Observable}
import com.vaadin.server.ClientConnector
import com.vaadin.server.ClientConnector.{AttachListener, DetachListener}

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 1/18/14
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
class ClientConnectorWrapper(val c : com.vaadin.server.ClientConnector) {

  val detaches : Observable[ClientConnector.DetachEvent] = {
    Observable(observer =>{
      val listener = new DetachListener(){
        def detach(event: ClientConnector.DetachEvent) = observer.onNext(event)
      }
      c.addDetachListener(listener)
      Subscription{
        c.removeDetachListener(listener)
      }
    })
  }

  val attaches : Observable[ClientConnector.AttachEvent] = {
    Observable(observer =>{
      val listener = new AttachListener(){
        def attach(event: ClientConnector.AttachEvent) = observer.onNext(event)
      }
      c.addAttachListener(listener)
      Subscription{
        c.removeAttachListener(listener)
      }
    })
  }



}
