package sweforce.vaadin.event

import com.vaadin.ui.Component
import com.vaadin.event.FieldEvents
import rx.lang.scala.{Subscription, Observable}
import com.vaadin.event.FieldEvents.FocusListener

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 1/18/14
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
case class Focus(c : Component) {

}

class FocusNotifierWrapper(notifier : FieldEvents.FocusNotifier) {
  def focuses : Observable[FocusEvent]= {
    Observable(observer =>{
      val listener = new FocusListener {
        def focus(event: com.vaadin.event.FieldEvents.FocusEvent) = observer.onNext(FocusEvent(event.getComponent))
      }
      notifier.addFocusListener(listener)
      Subscription{
        notifier.removeFocusListener(listener)
      }
    })
  }
}
