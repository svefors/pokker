package sweforce.vaadin.ui

import com.vaadin.ui.Button
import rx.lang.scala.{Subscription, Observable}
import sweforce.vaadin.event.ButtonClickEvent
import com.vaadin.ui.Button.{ClickEvent, ClickListener}

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 1/18/14
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
class ButtonWrapper(val c : Button) {

  val clicks : Observable[ButtonClickEvent] = Observable(observer => {
    val listener = new ClickListener {
      def buttonClick(event: ClickEvent) = observer.onNext(event)
    }
    c.addClickListener(listener)
    Subscription {
      c.removeClickListener(listener)
    }
  })
}
