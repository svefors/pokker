package sweforce.vaadin

import com.vaadin.data.Property
import rx.lang.scala.{Subscription, Observable, Observer}
import com.vaadin.data.Property.{ValueChangeNotifier, ValueChangeEvent, ValueChangeListener}

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 12/3/13
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
package object data {

  implicit def values[T](p : Property.ValueChangeNotifier) = new PropertyValueChangeNotifierWrapper(p)

}
