package examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
 * @author slouc
 *
 */
class FunctionPassing(val query: String) {

  def isMatch(s: String) = s.contains(query)

  def getMatchesFunctionReference(rdd: RDD[String]): RDD[String] = {
    // Problem: "isMatch" means "this.isMatch" so we pass all of "this"
    rdd.filter(isMatch)
  }
  
  def getMatchesFieldReference(rdd: RDD[String]): RDD[String] = {
    // Problem: "query" means "this.query" so we pass all of "this"
    rdd.filter(x => x.contains(query))
  }
  
  def getMatchesNoReference(rdd: RDD[String]): RDD[String] = {
    // Safe: extract just the field we need into a local variable
    val query_ = this.query
    rdd.filter(x => x.contains(query))
  }
}