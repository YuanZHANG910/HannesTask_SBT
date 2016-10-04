import Products._
import Main._
import MenuControl._


/**
  * Created by yuan on 03/10/2016.
  */
object Menu {

  def mainMenu() = {
    println("Main Menu")
    println("Please enter one of the following to continue:")
    println("1: Search for a product")
    println("2: Simple calculator")
    println("8: Check products in category")
    println("9: Show all products details (in products alphabetical order)")
    println("0: If you would like to exit")
  }

  def categoryMenu(): Any = {
    massage("Please enter one of the following Category to continue:")
    var n = 1
    for (cat <- getCategory) {
      println(s"$n. $cat")
      n+=1
    }
    println("0: Back to the main Menu")
    checkCategory(n)
  }
}
