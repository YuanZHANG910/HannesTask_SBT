import Products._
import Main._
import MenuProcessor._

/**
  * Created by yuan on 03/10/2016.
  */

object Menu {

  def mainMenu(): Unit = {
    println("Main Menu")
    println("Please enter one of the following to continue:")
    println("1: Search for a product")
    println("2: Simple calculator (simple multiplication only)")
    println("8: Check products in category")
    println("9: Show all products details")
    println("0: If you would like to exit")
  }

  def categoryMenu(): Unit = {
    massage("Please enter one of the following Category to continue:")
    var n = 1
    for (cat <- getCategory) {
      println(s"$n. $cat")
      n+=1
    }
    println("0: Back to the main Menu")
    checkCategory(n)
  }

  def sortingAllMenu(): Unit = {
    massage("Sorting all products by:")
    println("1: Products Name alphabetical order")
    println("2: Products Price ascending order")
    println("3: Category alphabetical order")
    println("0: Back to the main Menu")
    checkAllProducts()
  }

  def groupMassageForEndList(): Unit = {
    massage("")
    massage("End of products list")
    massage("")
    massage("Listed as above")
    massage("Are there anything else I can do for you my boss?")
  }

  def tableTopLine(): Unit = {
    println("Name   ||    Price   ||   Category")
  }
}
