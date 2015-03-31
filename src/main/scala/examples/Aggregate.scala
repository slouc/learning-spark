package examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import util.Input

object Aggregate extends App with Input {

  val result = inputNums.aggregate((0, 0))(
    (acc, value) => (acc._1 + value, acc._2 + 1),
    (acc1, acc2) => (acc1._1 + acc2._1, acc1._2 + acc2._2))

  val avg = result._1 / result._2.toDouble

  println(avg)
  
}