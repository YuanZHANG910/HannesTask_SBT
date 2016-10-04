import Menu._
import MenuControl._
/**
  * Created by yuan on 30/09/16.
  */

object Main {

  def main(args: Array[String]): Unit = {
    massage("Hi Boss, how can I help?")
    mainTemplate
  }

  def mainTemplate: Any = {
    mainMenu()
    while(true) {
      readInput match {
        case "1" => checkProduct()
        case "2" => SimpleCalculator
        case "8" => categoryMenu()
        case "9" => sortingAllMenu()
        case "0" => {
          massage("Boss are you sure you would like to exit?"  )
          massage("Enter Y to conform, or anything else to stay with me")
          readInput match {
            case "Y"|"y" => {
              massage("OK, goodbye boss")
              sys.exit
            }
            case _ => mainMenu()
          }
        }
        case _ => {
          massage("Come on Boss!")
          mainMenu()
        }
      }
    }
  }

  def readInput: String = {
    val input = scala.io.StdIn.readLine()
    input
  }

  def massage(feedBack:String): Unit = {
    println(feedBack)
  }
}
