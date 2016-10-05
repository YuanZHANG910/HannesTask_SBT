import com.mongodb.casbah.Imports._
import Main._
import Menu._
import Products._

/**
  * Created by yuanz on 05/10/2016.
  */

object MongoProcessor {

  def getProductMapFromMongo:Any = {
    val mongoClient =  MongoClient()
    val db = mongoClient("super-shop")
    val productsCol = db("Products")
    val allDocs=productsCol.find()
    allDocs.toList.foreach(getProductDetail)
  }

}
