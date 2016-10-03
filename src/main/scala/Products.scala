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

  def getProductByName(name: String): Option[Double] = {
    products.get(name.toLowerCase)
  }
}

object Products extends Products