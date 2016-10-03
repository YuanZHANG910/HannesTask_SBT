import scala.io.Source

/**
  * Created by yuan on 30/09/16.
  */

case class Product(name: String, price: Double)

class Products {

  val fileName = "src/main/data/productsList.csv"
  val products = scala.collection.mutable.Map[String, Double]()
  val sources = Source.fromFile(fileName)

  for(line <- sources.getLines()) {
    val cols = line.split(',').map(_.trim)
    products += (cols(0).toLowerCase() -> cols(1).toDouble)
  }
  sources.close()

  def checkProductByName(name:String): Any = {
    products.getOrElse(name.toLowerCase(),Main.massage(name + " is a Invalid product's name, Please try again or enter 0 back to the main Menu")) match {
      case value => {
        Main.massage("The price for " + name + " is " + value)
        Main.massage("Please enter a product name or enter 0 back to the main Menu")
      }
    }
  }
}

object Products extends Products