import scala.io.Source

/**
  * Created by yuan on 30/09/16.
  */

case class Product(name: String, price: Double, Category: String)

class Products {

  val fileName = "src/main/data/productsList.csv"
  val productsMap = scala.collection.mutable.Map[String, Double]()
  var productsList: List[Product] = List.empty

  def getProductByName(name: String): Option[Double] = {
    productsMap.get(name.toLowerCase)
  }

  def getProductsInMap: Any =  {
    val sources = Source.fromFile(fileName)

    for(line <- sources.getLines()) {
      val cols = line.split(',').map(_.trim)
      productsMap += (cols(0).toLowerCase() -> cols(1).toDouble)
    }
    sources.close()
  }

  def getProductsInLiast: Any ={
    val sources = Source.fromFile(fileName)
    for(line <- sources.getLines()) {
      val cols = line.split(',').map(_.trim)
      productsList = productsList :+ Product(cols(0), cols(1).toFloat, cols(2))
    }
    sources.close()
  }
}

object Products extends Products {
  getProductsInMap
  getProductsInLiast
  println(productsList.sortBy())
}