package examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/**
 * @author slouc
 *
 */
class Initialize {

  val conf = new SparkConf().setMaster("local").setAppName("MyApp")
  val sc = new SparkContext(conf)
  
}