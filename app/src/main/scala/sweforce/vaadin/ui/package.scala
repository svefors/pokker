package sweforce.vaadin

import com.vaadin.ui.{Component, Field, Button, AbstractComponent}
import rx.lang.scala.{Subscription, Observable, Observer}
import com.vaadin.ui.Button.{ClickEvent, ClickListener}
import sweforce.vaadin.event.ButtonClickEvent

/**
 *
 */
package object ui {


  implicit def abstractComponentWrapper(c : AbstractComponent) = new AbstractComponentWrapper(c)

  implicit def componentWrapper(c : Component) = new ComponentWrapper(c)

  implicit def fieldWrapper(c : com.vaadin.ui.Field[_]) = new FieldWrapper(c)

  implicit def buttonWrapper(c : Button) = new ButtonWrapper(c)


}
