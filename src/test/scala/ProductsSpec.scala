import Products._
import org.scalatest.{MustMatchers, WordSpec}

/**
  * Created by yuan on 30/09/2016.
  */

class ProductsSpec extends WordSpec with MustMatchers {

  "The Products class" should {

    "able to give a map of products" in {
      productsMap.contains("orange") mustBe true
    }

    "able to give category of products" in {
      getCategory mustBe List("Dairy", "Drink", "Fruit", "Meat", "Other", "Vegetable")
    }

    "able to search a product by name and give the price if the product was in the list" in {
      getProductByName("Orange").get.price mustBe 0.6
    }

    "able to search a product by name without case sensitive" in {
      getProductByName("oRanGe").get.price mustBe 0.6
    }

    "if the product was not in the list, it should able to point it out" in {
      getProductByName("Onge") mustBe None
    }
  }

}
