package sweforce.vaadin.event

import com.vaadin.event.FieldEvents
import rx.lang.scala.{Subscription, Observable}
import com.vaadin.event.FieldEvents.{BlurListener, FocusListener}
import com.vaadin.event._
import com.vaadin.server.ClientConnector
import com.vaadin.server.ClientConnector.{DetachListener, AttachListener}
import com.vaadin.ui.Button
import com.vaadin.ui.Button.{ClickEvent, ClickListener}

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 12/3/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
package object observable {

//  implicit def focusEventObservable(notifier : FieldEvents.FocusNotifier) : Observable[FocusEvent]= {
//    Observable(observer =>{
//      val listener = new FocusListener {
//        def focus(event: com.vaadin.event.FieldEvents.FocusEvent) = observer.onNext(FocusEvent(event.getComponent))
//      }
//      notifier.addFocusListener(listener)
//      Subscription{
//        notifier.removeFocusListener(listener)
//      }
//    })
//  }
//
//  implicit def blurEventObservable(notifier : FieldEvents.BlurNotifier) : Observable[com.vaadin.event.FieldEvents.BlurEvent]= {
//    Observable(observer =>{
//      val listener = new BlurListener {
//        def blur(event: com.vaadin.event.FieldEvents.BlurEvent) = observer.onNext(event)
//      }
//      notifier.addBlurListener(listener)
//      Subscription{
//        notifier.removeBlurListener(listener)
//      }
//    })
//  }

//  implicit def clientConnectorToAttachObservable(notifier : ClientConnector) : Observable[ClientConnector.AttachEvent] = {
//    Observable(observer =>{
//      val listener = new AttachListener(){
//        def attach(event: ClientConnector.AttachEvent) = observer.onNext(event)
//      }
//      notifier.addAttachListener(listener)
//      Subscription{
//        notifier.removeAttachListener(listener)
//      }
//    })
//  }
//
//  implicit def clientConnectorToDetachObservable(notifier : ClientConnector) : Observable[ClientConnector.DetachEvent] = {
//    Observable(observer =>{
//      val listener = new DetachListener(){
//        def detach(event: ClientConnector.DetachEvent) = observer.onNext(event)
//      }
//      notifier.addDetachListener(listener)
//      Subscription{
//        notifier.removeDetachListener(listener)
//      }
//    })
//  }

//  implicit def buttonClickObservable(notifier : Button) : Observable[Button.ClickEvent] = {
//    Observable(observer =>{
//      val listener = new ClickListener {
//        def buttonClick(event: ClickEvent) = observer.onNext(event)
//      }
//      notifier.addClickListener(listener)
//      Subscription{
//        notifier.removeClickListener(listener)
//      }
//    })
//  }

}
