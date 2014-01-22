package sweforce.vaadin.event

import com.vaadin.event.FieldEvents
import rx.lang.scala.{Subscription, Observable}
import com.vaadin.event.FieldEvents.BlurListener
import com.vaadin.ui.Component

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 1/18/14
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
case class Blur(c : Component) {

}

class BlurNotifierWrapper(notifier : FieldEvents.BlurNotifier) {
  def blurs : Observable[com.vaadin.event.FieldEvents.BlurEvent] = Observable(observer =>{
    val listener = new BlurListener {
      def blur(event: com.vaadin.event.FieldEvents.BlurEvent) = observer.onNext(event)
    }
    notifier.addBlurListener(listener)
    Subscription{
      notifier.removeBlurListener(listener)
    }
  })
}


