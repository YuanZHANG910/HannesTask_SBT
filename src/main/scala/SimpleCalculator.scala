import Products._
import Main._

import scala.util.Success
/**
  * Created by yuanz on 04/10/2016.
  */
class SimpleCalculator {

  mainMassage

  while(true) {
    val input = scala.io.StdIn.readLine()

    scala.util.Try(input.toDouble) match {
      case Success(_) => {
        if (input.toInt == 0){
          massage("Goodbye from your little calculator")
          massage("")
          Main.mainTemplate
        }else{
          putQuantityAndGetResult(input.toDouble)
        }
      }
      case _ => {
        getProductByName(input) match {
          case Some(v) => putQuantityAndGetResult(v.price)
          case None => massage(input + " is a Invalid product's name, Please enter a products name or a price, or enter 0 back to the Main Menu")
        }
      }
    }
  }

  def mainMassage: Any = {
    println("Please enter a products name or a price, or enter 0 back to the Main Menu")
  }

  def times(a: Double, b:Int): Double ={
    a*b
  }

  def putQuantityAndGetResult(firstV:Double): Any = {
    println("Please enter Quantity")
    val quantity = scala.io.StdIn.readLine()
    scala.util.Try(quantity.toInt) match {
      case Success(_) => {
        println("£"+f"${times(firstV,quantity.toInt)}%1.2f")
        massage("")
        new SimpleCalculator
      }
      case _ => {
        massage("Come on Boss! Invalid input, Please enter a products name or a price, or enter 0 back to the Main Menu")
      }
    }
  }
}

object SimpleCalculator extends SimpleCalculator