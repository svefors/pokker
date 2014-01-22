package sweforce.vaadin.event

import com.vaadin.event.FieldEvents

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 1/18/14
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
object FieldEventsWrapper {

  implicit def blurs(n : FieldEvents.BlurNotifier) = new BlurNotifierWrapper(n)

  implicit def blurEvent(e : FieldEvents.BlurEvent) = new Blur(e.getComponent)

  implicit def focuses(n : FieldEvents.FocusNotifier) = new FocusNotifierWrapper(n)

  implicit def focusEvent(e : FieldEvents.FocusEvent) = new Focus(e.getComponent)


}
