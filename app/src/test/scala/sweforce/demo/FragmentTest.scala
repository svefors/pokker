package sweforce.demo

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import scala.util.matching.Regex

/**
 * Created by sveffa on 25/03/14.
 */
@RunWith(classOf[JUnitRunner])
class FragmentTest extends FunSuite {

  /*
  test("implicit conversion char to Rank") {
      var rank: Rank = 'A'
      assert(Ace === rank)
      rank = 'K'
   */

  test("regex starting with") {
    val regex = new Regex("im/chat/(?)")
    println(regex.findFirstIn("im/chat/123"))
    regex.findAllMatchIn("im/chat/123").foreach(_.groupNames.foreach(println(_)))

  }

}
