/**
  * Created by yuan on 30/09/16.
  */

object Main {
  def main(args: Array[String]): Unit = {
    while(true) {
      println("Please enter a product name or enter 0 to exit")
      val input = userInput()
      input match {
        case "0" =>
          sys.exit
        case _ => Products.getProductByName(input)
      }
    }
  }
  def userInput(): String ={
    scala.io.StdIn.readLine()
  }
}
