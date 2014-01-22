package sweforce.vaadin.ui

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 1/18/14
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
class AbstractComponentWrapper(c : com.vaadin.ui.AbstractComponent) {

  def immediate: Boolean = c.isImmediate
  def immediate_=(immediate: Boolean) = c.setImmediate(immediate)


}
