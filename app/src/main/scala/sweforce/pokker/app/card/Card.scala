package sweforce.pokker.app.card

import RankCharConversions._
import SuitCharConversions._
/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 8/16/13
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
case class Card(suit :Suit, rank : Rank) {

}

object Card {
  def apply(card : String) ={
    CardStringConversions.StringToCard(card)
  }
}

object CardStringConversions {


  implicit def CardToString(c : Card) : String = {
    return (suitToChar(c.suit) + rankToChar(c.rank).toString)
  }

  implicit def StringToCard(s : String) : Card = {
    return Card(s.charAt(0), s.charAt(1))
  }

}


