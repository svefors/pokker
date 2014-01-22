package sweforce.vaadin.server


import org.scalacheck.Arbitrary._
import org.scalacheck.{Arbitrary, Gen, Properties, Prop}
import org.scalacheck.Prop._
import org.scalatest.prop.Checkers
import org.scalatest.FunSuite
import sweforce.vaadin.server._
import com.vaadin.ui.{VerticalLayout, HorizontalLayout}

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import sweforce.vaadin.server.Units.Units
import com.vaadin.server
import scala.util.Random

/**
 * Created with IntelliJ IDEA.
 * User: sveffa
 * Date: 12/1/13
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(classOf[JUnitRunner])
class SizeableSpec extends FunSuite with Checkers {

  test("sizeable"){
    check(sizeableProperties)
  }

  object sizeableProperties extends Properties("sizeable") {

    lazy val genMeasure : Gen[Measure] = for {
      u <- Gen.oneOf(Units.values.toSeq)
      n <- u.toString match {
//        case "cm" => Gen.choose(0,1000)
//        case "em" => Gen.choose(0,166)
//        case "mm" => Gen.choose(0,407)
//        case "in" => Gen.choose(0,707)
//        case "ex" => Gen.choose(0,600)
//        case "%" => Gen.choose(0,190)
//        case "pt" => Gen.choose(6,81)
        case _ => Gen.choose(0,1000)
      }
    }yield Measure(n,u)

    lazy val genSizeable : Gen[com.vaadin.server.Sizeable] = for {
      l <- Gen.oneOf(classOf[HorizontalLayout].newInstance(),classOf[VerticalLayout].newInstance())
    } yield l




    implicit lazy val arbitrarySizable = Arbitrary(genSizeable)

    implicit lazy val arbitraryUnit = Arbitrary(Gen.oneOf(Units.values.toSeq))

    implicit lazy val arbitraryMeasure = Arbitrary(genMeasure)

    property("width") =  forAll { (sizeable : com.vaadin.server.Sizeable,  m : Measure )=>
      sizeable.width = m
      sizeable.width == Some(m)
      sizeable.getWidth == m.value
      val vaadinUnit  = com.vaadin.server.Sizeable.Unit.getUnitFromSymbol(m.unit.toString)
      val widthUnit = sizeable.getWidthUnits
      widthUnit == vaadinUnit
    }

    property("height") =  forAll { (sizeable : com.vaadin.server.Sizeable,m : Measure) =>
      sizeable.height= m
      sizeable.height== Some(m)
      sizeable.getHeight == m.value
      val vaadinUnit  = com.vaadin.server.Sizeable.Unit.getUnitFromSymbol(m.unit.toString)
      val widthUnit = sizeable.getHeightUnits
      widthUnit == vaadinUnit
    }

    property("sizeFull") =  forAll { (sizeable : com.vaadin.server.Sizeable, w : Measure, h : Measure) =>
      Random.nextInt(4) match {
        case 0 => sizeable.width = w
        case 1 => sizeable.height = h
        case 2 => {
          sizeable.width = w
          sizeable.height = h
        }
        case 3 => {}
      }
      sizeable.sizeFull()
      val width : Option[Measure] = sizeable.width
      val height : Option[Measure] = sizeable.height
      width == Some(Measure(100, Units.pct))
      height == Some(Measure(100, Units.pct))
    }

    property("sizeUndefined") =  forAll { (sizeable : com.vaadin.server.Sizeable,h : Measure, w : Measure) =>
      Random.nextInt(4)  match {
        case 0 => sizeable.width = w
        case 1 => sizeable.height = h
        case 2 => {
          sizeable.width = w
          sizeable.height = h
        }
        case 3 => {}
      }
      sizeable.sizeUndefined()
      sizeable.width == None
      sizeable.height == None
      sizeable.getWidth == -1
      sizeable.getHeight == -1
      sizeable.getHeightUnits == com.vaadin.server.Sizeable.Unit.PIXELS
    }
  }

}




