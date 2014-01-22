package sweforce.vaadin.data

import com.vaadin.data.Property
import rx.lang.scala.{Subscription, Observable}
import com.vaadin.data.Property.{ValueChangeEvent, ValueChangeListener}

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 1/18/14
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
class PropertyValueChangeNotifierWrapper(p : Property.ValueChangeNotifier) {
  def values[T] : Observable[T] = Observable(observer => {
    val listener = new ValueChangeListener {
      def valueChange(event: ValueChangeEvent) = observer.onNext(event.getProperty.getValue.asInstanceOf[T])
    }
    p.addValueChangeListener(listener)
    Subscription{
      p.removeValueChangeListener(listener)
    }
  })
}


/*



 */
