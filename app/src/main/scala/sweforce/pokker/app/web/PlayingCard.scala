package sweforce.pokker.app.web

import com.vaadin.ui.{Label, CustomComponent}
import sweforce.pokker.app.card.Card

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 8/16/13
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
class PlayingCard extends CustomComponent{

  private val label = new Label

  /**
   * clear the value
   */
  def clear() = {
    label.setValue("")
  }

  def displayBackSide() = {
    label.setValue("XX")
  }

  def displayCard(card : Card) = {

  }



  setCompositionRoot(null)


}
