/**
  * Created by yuan on 30/09/16.
  */

object Main {
  def main(args: Array[String]): Unit = {
    massage("Hi Boss, Please enter a product name or enter 0 to exit")
    while(true) {
      val input = scala.io.StdIn.readLine()
      input match {
        case "0" =>
          sys.exit
        case "" => massage("Come on Boss! Please enter a product name or enter 0 to exit")
        case _ => Products.checkProductByName(input)
      }
    }
  }

  def massage(feedBack:String): Unit ={
    println(feedBack)
  }
}
