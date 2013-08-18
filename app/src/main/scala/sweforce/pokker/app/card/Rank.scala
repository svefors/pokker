package sweforce.pokker.app.card

sealed trait Rank {

}

case object Ace extends Rank

case object King extends Rank

case object Queen extends Rank

case object Jack extends Rank

case object Ten extends Rank

case object Nine extends Rank

case object Eight extends Rank

case object Seven extends Rank

case object Six extends Rank

case object Five extends Rank

case object Four extends Rank

case object Three extends Rank

case object Two extends Rank



object RankCharConversions {
  implicit def charToRank(c: Char) : Rank = {
    return c match {
      case 'A' => Ace
      case 'K' => King
      case 'Q' => Queen
      case 'J' => Jack
      case 'T' => Ten
      case '9' => Nine
      case '8' => Eight
      case '7' => Seven
      case '6' => Six
      case '5' => Five
      case '4' => Four
      case '3' => Three
      case '2' => Two
    }
  }

  implicit def rankToChar(r: Rank) : Char = {
    return r match {
      case Ace => 'A'
      case King => 'K'
      case Queen => 'Q'
      case Jack => 'J'
      case Ten => 'T'
      case Nine => '9'
      case Eight => '8'
      case Seven => '7'
      case Six => '6'
      case Five => '5'
      case Four => '4'
      case Three => '3'
      case Two => '2'
    }
  }
}



object AcesHighRankOrder extends Ordering[Rank] {
  val order = List(Ace, King, Queen, Jack, Ten, Nine, Eight, Seven, Six, Five, Four, Three, Two)

  def compare(x: Rank, y: Rank) = {
    order.indexOf(x).compareTo(order.indexOf(y))
  }
}