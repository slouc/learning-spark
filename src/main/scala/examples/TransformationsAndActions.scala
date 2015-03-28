package examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object TransformationsAndActions extends App {

  val inputFile = "build.sbt"
  val outputFile = "output"
    
  val conf = new SparkConf().setMaster("local").setAppName("wordCount")
  val sc = new SparkContext(conf)
  
  val inputRDD = sc.textFile(inputFile)
  val errorsRDD = inputRDD.filter(line => line.contains("error"))
  val warningsRDD = inputRDD.filter(line => line.contains("warning"))
  
  val badLinesRDD = errorsRDD.union(warningsRDD)
  
  println("Input had " + badLinesRDD.count() + " concerning lines")
  println("Here are 10 examples:")
  badLinesRDD.take(10).foreach(println)
  
}