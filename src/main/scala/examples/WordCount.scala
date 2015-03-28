package examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object WordCount extends App {

  val inputFile = "build.sbt"
  val outputFile = "output"
    
  // Create a Scala Spark Context
  val conf = new SparkConf().setMaster("local").setAppName("wordCount")
  val sc = new SparkContext(conf)
  
  // Load input data
  val input = sc.textFile(inputFile)
  
  // Split it up into words
  val words = input.flatMap(line => line.split(" "))
  
  // Transform into pairs and count
  val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
  
  // Save word count back to the text file, causing evaluation
  counts.saveAsTextFile(outputFile)
  
}