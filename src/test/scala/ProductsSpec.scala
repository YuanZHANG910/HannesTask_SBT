import org.scalatest.{MustMatchers, WordSpec}

import scala.io.Source
/**
  * Created by yuan on 30/09/2016.
  */
class ProductsSpec extends WordSpec with MustMatchers {

    val fileName = "src/main/data/productsList.csv"
    val sources = Source.fromFile(fileName)
    var products: Array[Product] = Array.empty
    for(line <- sources.getLines()) {
      val cols = line.split(',').map(_.trim)
      products = products :+ Product(cols(0), cols(1).toDouble)
    }
    sources.close()

  "The Products class" should {
    "able to give a list of products" in {
      products.head mustBe Product("Orange", 0.60)
    }

    "able to search a product by name and give the price if the product was in the list" in {
      Products.getProductByName("Orange") mustBe println(products.head)
    }

    "able to search a product by name without case sensitive" in {
      Products.getProductByName("oRanGe") mustBe println(products.head)
    }

    "if the product was not in the list, it should able to point it out" in {
      Products.getProductByName("Onge") mustBe println("Invalid product's name, Please try again")
    }
  }

}
