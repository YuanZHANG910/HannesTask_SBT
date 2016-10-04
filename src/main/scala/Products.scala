import scala.io.Source

/**
  * Created by yuan on 30/09/16.
  */

case class Product(name: String, price: Double, Category: String)

class Products {

  val fileName = "src/main/data/productsList.csv"
  val productsMap = scala.collection.mutable.Map[String, Product]()

  def getProductsInMap: Any =  {
    val sources = Source.fromFile(fileName)

    for(line <- sources.getLines()) {
      val cols = line.split(',').map(_.trim)
      productsMap += (cols(0).toLowerCase() -> Product(cols(0), cols(1).toDouble, cols(2)))
    }
    sources.close()
  }

  def getProductByName(name: String): Option[Product] = {
    productsMap.get(name.toLowerCase)
  }

  def getCategory: List[String] = {
    productsMap.map(_._2.Category).toList.distinct.sorted
  }

  def getProductsInACategory(catName: String): Map[String, Product] = {
    productsMap.filter(_._2.Category==catName).toMap
  }
}

object Products extends Products {
  getProductsInMap
}