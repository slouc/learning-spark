package util

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

trait Input {

  val inputFile = "build.sbt"
  val outputFile = "output"
    
  val conf = new SparkConf().setMaster("local").setAppName("wordCount")
  val sc = new SparkContext(conf)
  
  val inputWords = sc.textFile(inputFile)
  val inputNums = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8))
  
}