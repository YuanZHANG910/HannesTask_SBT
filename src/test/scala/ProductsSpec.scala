import org.scalatest.{MustMatchers, WordSpec}
import Products._

import scala.io.Source
/**
  * Created by yuan on 30/09/2016.
  */
class ProductsSpec extends WordSpec with MustMatchers {

  val fileName = "src/main/data/productsList.csv"
  val products = scala.collection.mutable.Map[String, Double]()
  val sources = Source.fromFile(fileName)

  for(line <- sources.getLines()) {
    val cols = line.split(',').map(_.trim)
    products += (cols(0).toLowerCase() -> cols(1).toDouble)
  }
  sources.close()

  "The Products class" should {

    "able to give a map of products" in {
      products.contains("orange") mustBe true
    }

    "able to search a product by name and give the price if the product was in the list" in {
      getProductByName("Orange").get mustBe 0.6
    }

    "able to search a product by name without case sensitive" in {
      getProductByName("oRanGe").get mustBe 0.6
    }

    "if the product was not in the list, it should able to point it out" in {
      getProductByName("Onge") mustBe None
    }
  }

}
