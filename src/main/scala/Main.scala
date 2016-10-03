/**
  * Created by yuan on 30/09/16.
  */

object Main {
  def main(args: Array[String]): Unit = {
    while(true) {
      println("Hi Boss, Please enter a product name or enter 0 to exit")
      val input = scala.io.StdIn.readLine()
      input match {
        case "0" =>
          sys.exit
        case _ => Products.getProductByName(input)
      }
    }
  }
}
