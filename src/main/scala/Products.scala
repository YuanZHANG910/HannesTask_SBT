import scala.io.Source

/**
  * Created by yuan on 30/09/16.
  */

case class Product(name: String, price: Float)

class Products {

  val fileName = "src/main/data/productsList.csv"

  var products: Array[Product] = Array.empty

  def getProductByName(name:String): Any = {
    products.exists(_.name.toLowerCase() == name.toLowerCase()) match {
      case true => println(products.filter(_.name.toLowerCase() == name.toLowerCase()).head)
      case false => println("Invalid product's name, Please try again")
    }
  }
}

object Products extends Products{
  val sources = Source.fromFile(fileName)
  for(line <- sources.getLines()) {
    val cols = line.split(',').map(_.trim)
    products = products :+ Product(cols(0), cols(1).toFloat)
  }
  sources.close()
}