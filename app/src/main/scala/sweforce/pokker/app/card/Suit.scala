package sweforce.pokker.app.card

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 8/16/13
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */
sealed trait Suit {



}

object Suit{
  def apply(c : Char) = {
    SuitCharConversions.charToSuit(c)
  }
}
case object Diamonds extends Suit

case object Spades extends Suit

case object Hearts extends Suit

case object Clubs extends Suit

object SuitCharConversions {

  implicit def charToSuit(c: Char) : Suit = {
    c match {
      case 'D' => Diamonds
      case 'S' => Spades
      case 'H' => Hearts
      case 'C' => Clubs
    }
  }

  implicit def suitToChar(s: Suit) : Char = {
    s match {
      case Diamonds => 'D'
      case Spades => 'S'
      case Hearts => 'H'
      case Clubs => 'C'
    }
  }
}