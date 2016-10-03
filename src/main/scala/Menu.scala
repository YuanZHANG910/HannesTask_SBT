import Products._

/**
  * Created by yuan on 03/10/2016.
  */
object Menu {

  def mainMenu() = {
    println("Please enter one of the following:")
    println("1: Search for a product")
    println("0: If you would like to exit")
  }

  def checkProductMenu() = {
    Main.massage("Please enter a product name or enter 0 back to the main Menu")
    while (true) {
      val input = scala.io.StdIn.readLine()
      input match {
        case "" => Main.massage("Come on Boss! Please enter something or enter 0 back to the main Menu")
        case "0" => Main.mainTemplate
        case _ => checkProductByName(input)
      }
    }
  }

  def checkProductByName(name:String): Any = {
    getProductByName(name) match {
      case Some(v) => {
        Main.massage("The price for " + name + " is " + v)
        Main.massage("Please enter a product name or enter 0 back to the main Menu")
      }
      case None => Main.massage(name + " is a Invalid product's name, Please try again or enter 0 back to the main Menu")
    }
  }
}
