/**
  * Created by yuanz on 03/10/2016.
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
        case _ => Products.checkProductByName(input)
      }
    }
  }
}
