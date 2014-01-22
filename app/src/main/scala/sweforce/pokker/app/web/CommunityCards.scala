package sweforce.pokker.app.web

import com.vaadin.ui.{Label, HorizontalLayout, VerticalLayout, CustomComponent}
import sweforce.pokker.app.card.Card

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 8/16/13
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
class CommunityCards {


}

abstract class CommunityCardsView extends HorizontalLayout{

  /*
  initialize with a
   */
  val card1Lbl = new Label();


  def setFlopCards(card1: Card, card2 : Card, card3 : Card)

  def setTurnCard(card4 : Card)

  def setRiverCard(card5 : Card)

  /**
   * removes card from table
   */
  def clearTable()


}

class CommunityCardsPresenter {

}