package sweforce.pokker.app.card

import collection.mutable.Stack
import scala.None
import util.Random
import collection.mutable

/**
 * A mutable Deck of cards
 */
class Deck(private var cards: Stack[Card]) extends Equals {


  def canEqual(that: Any) = {
    that != null && that.isInstanceOf[Deck]
  }

  /**
   * equals if the two deck of cards are in the same order
   * @param that
   * @return
   */
  override def equals(that: Any) = {
    canEqual(that) && cards.equals(that.asInstanceOf[Deck].cards)
  }

  /**
   * shuffle the deck
   */
  def shuffle() {
    cards = Random.shuffle(cards)
  }

  /**
   * draw the top card from the deck
   * @return the top card
   */
  def draw() = {
    if (cards.isEmpty)
      None
    else
      Some(cards.pop())
  }

  def isEmpty() = {
    cards.isEmpty
  }

}

object Deck {
  /**
   * creates a unshuffled 52 card deck
   * @return
   */
  def apply(): Deck = {
    new Deck(new mutable.Stack[Card]() ++
      AcesHighRankOrder.order.map(rank => Card(Spades, rank)) ++
      AcesHighRankOrder.order.map(rank => Card(Diamonds, rank)) ++
      AcesHighRankOrder.order.map(rank => Card(Hearts, rank)) ++
      AcesHighRankOrder.order.map(rank => Card(Clubs, rank))
    )
  }
}
