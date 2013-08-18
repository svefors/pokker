package sweforce.pokker.app.card

import org.scalatest.FunSuite
import RankCharConversions._
import SuitCharConversions._
import CardStringConversions._
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 8/16/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(classOf[JUnitRunner])
class CardSuite extends FunSuite {

  test("implicit conversion char to Rank") {
    var rank: Rank = 'A'
    assert(Ace === rank)
    rank = 'K'
    assert(King === rank)
    rank = 'Q'
    assert(Queen === rank)
    rank = 'J'
    assert(Jack === rank)
    rank = 'T'
    assert(Ten === rank)
    rank = '9'
    assert(Nine === rank)
    rank = '8'
    assert(Eight === rank)
    rank = '7'
    assert(Seven === rank)
    rank = '6'
    assert(Six === rank)
    rank = '5'
    assert(Five === rank)
    rank = '4'
    assert(Four === rank)
    rank = '3'
    assert(Three === rank)
    rank = '2'
    assert(Two === rank)
  }

  test("implicit conversion char to Suit") {
    assert(Diamonds === Suit('D'))
    var suit: Suit = 'C'
    assert(Clubs === suit)
    suit = 'H'
    assert(Hearts === suit)
    suit = 'S'
    assert(Spades === suit)
  }

  test("implicit conversion String to Card") {

    assert(Card(Diamonds, Ace) === Card("DA"))
    var card: Card = "SK"
    assert(Card(Spades, King) === card)
  }

  test("implicit conversion Card to String") {
    var value: String = Card(Diamonds, Ace)
    assert("DA" === value)
  }

  test("Deck has 52 cards") {
    var deck = Deck()
    var count = 0
    while (!deck.isEmpty()) {
      deck.draw()
      count = count + 1
    }
    assert(52 === count)
  }

  test("Deck returns Option.None when empty") {
    var deck = Deck()
    while (!deck.isEmpty()) {
      deck.draw()
    }
    deck.draw() match {
      case None => {
        //success
      }
      case Some(card) => {
        fail("draw() should return None when empty")
      }
    }
  }

  test("Deck returns Option.Some when not empty") {
    var deck = Deck()
    while (!deck.isEmpty()) {
      deck.draw() match {
        case None => {
          fail("draw() should return Some when not empty")
        }
        case Some(card) => {
          //success
        }
      }
    }

  }

  test("Two decks are equal if their card order is the same") {
    val cardOrder1 = List(Card(Diamonds, Nine), Card(Spades, Six))
    val cardOrder2 = List(Card(Diamonds, Nine), Card(Spades, Six))
    var deck1 = new Deck(mutable.Stack() ++ (cardOrder1))
    var deck2 = new Deck(mutable.Stack() ++ (cardOrder2))
    assert(deck1 == deck2)
  }

  test("two decks that are shuffled should not have the same card order") {
    var deck1 = Deck()
    deck1.shuffle()
    var deck2 = Deck()
    deck2.shuffle()
    assert(deck1 != deck2)
  }

}
