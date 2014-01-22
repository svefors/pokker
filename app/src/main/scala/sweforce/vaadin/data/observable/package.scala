package sweforce.vaadin.data

import com.vaadin.data.Property
import rx.lang.scala.{Subscription, Observable}
import com.vaadin.data.Property.{ValueChangeNotifier, ValueChangeListener, ValueChangeEvent}
import com.vaadin.ui.Field

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 12/3/13
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
package object observable {

  implicit def propertyObservable[T](notifier : Property.ValueChangeNotifier) : Observable[T] ={
    Observable(observer => {
      val listener = new ValueChangeListener {
        def valueChange(event: ValueChangeEvent) = observer.onNext(event.getProperty.getValue.asInstanceOf[T])
      }
      notifier.addValueChangeListener(listener)
      Subscription{
        notifier.removeValueChangeListener(listener)
      }
    })
  }

  implicit def propertyObservable2(notifier : Property.ValueChangeNotifier) : Observable[ValueChangeEvent] ={
    /*
     TODO:
     An alternative would be to have a BehaviorSubject.
     advantage is that the last emitted value will be sent to the observer that subscribes.
     but the behavior subject would have to be
      */
    Observable(observer => {
      val listener = new ValueChangeListener {
        def valueChange(event: ValueChangeEvent) = observer.onNext(event)
      }
      notifier.addValueChangeListener(listener)
      Subscription{
        notifier.removeValueChangeListener(listener)
      }
    })
  }

//  implicit def fieldObservable[T](field : Field[T]) : Observable[ValueChangeEvent] ={
//    Observable(observer => {
//      val listener = new ValueChangeListener {
//        def valueChange(event: ValueChangeEvent) = observer.onNext(event)
//      }
//      field.addValueChangeListener(listener)
//      Subscription{
//        field.removeValueChangeListener(listener)
//      }
//    })
//  }
//
//  implicit def fieldObservable2[T](field : Field[T]) : Observable[T] ={
//    Observable(observer => {
//      val listener = new ValueChangeListener {
//        def valueChange(event: ValueChangeEvent) = observer.onNext(event.getProperty.getValue.asInstanceOf[T])
//      }
//      field.addValueChangeListener(listener)
//      Subscription{
//        field.removeValueChangeListener(listener)
//      }
//    })
//  }
}
