import Main._
import Menu._
import Products._

import scala.util.Success

/**
  * Created by yuan on 04/10/2016.
  */

object MenuProcessor {

  def checkProduct() = {
    massage("Please enter a product name or enter 0 back to the main Menu")
    while (true) {
      val input = scala.io.StdIn.readLine()
      input match {
        case "" => massage("Come on Boss! Please enter something or enter 0 back to the main Menu")
        case "0" => mainTemplate
        case _ => checkProductByName(input)
      }
    }
  }

  def checkCategory(lengthOfCategoryList:Int) = {
    val input = scala.io.StdIn.readLine()
    input match {
      case "0" => mainTemplate
      case _ => {
        scala.util.Try (input.toInt) match {
          case Success(_) => {
            if (input.toInt <= lengthOfCategoryList-1) {
              massage(s"Products in ${getCategory(input.toInt - 1)} are:")
              tableTopLine()
              getProductsInACategory(getCategory(input.toInt - 1)).values.foreach(foreachProduct)
              groupMassageForEndList()
              categoryMenu()
            }else categoryMenu()
          }
          case _ => categoryMenu()
        }
      }
    }
  }
  def checkAllProducts() = {
    readInput match {
      case "0" => mainTemplate
      case "1" => sortingBy(0)
      case "2" => sortingBy(1)
      case "3" => sortingBy(2)
      case _ => {
        massage("Please enter something valid")
      }
    }
    groupMassageForEndList()
    mainMenu()
  }

  def sortingBy(sortingBy:Int): Unit = {
    tableTopLine()
    productsMap.toList.map(_._2).sortBy(_.productElement(sortingBy).toString).foreach(foreachProduct)
  }

  def foreachProduct(product:Product) = {
    println(s"${product.name}   £${product.price}   ${product.category}")
  }

  def checkProductByName(name:String): Any = {
    getProductByName(name) match {
      case Some(v) => {
        massage("The price for " + name + " is " + v.price)
        massage("Please enter a product name or enter 0 back to the main Menu")
      }
      case None => massage(name + " is a Invalid product's name, Please try again or enter 0 back to the main Menu")
    }
  }
}
