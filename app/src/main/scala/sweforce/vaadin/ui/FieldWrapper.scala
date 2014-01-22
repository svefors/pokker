package sweforce.vaadin.ui

import com.vaadin.ui.Field

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 1/18/14
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
class FieldWrapper[T](f : Field[T]) {

  def required: Boolean = f.isRequired
  def required_=(v : Boolean)  =f.setRequired(v)

}
