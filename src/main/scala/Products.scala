import scala.io.Source

/**
  * Created by yuan on 30/09/16.
  */

case class Product(name: String, price: Double)

class Products {
  val fileName = "src/main/data/productsList.csv"
  var products: Map[String,Double] = Map()
  val sources = Source.fromFile(fileName)

  def getProductByName(name:String): Any = {
    products.contains(name.toLowerCase()) match {
      case true => println("the Price for " + name + " is " + products(name.toLowerCase()))
      case false => println("Invalid product's name, Please try again")
    }
  }
}

object Products extends Products{
  for(line <- sources.getLines()) {
    val cols = line.split(',').map(_.trim)
    products += (cols(0).toLowerCase() -> cols(1).toDouble)
  }
  sources.close()
}