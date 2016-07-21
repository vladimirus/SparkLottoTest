package com.test

import org.apache.spark.{SparkContext, SparkConf}

object TestApp extends App {
  val textFile = "src/main/resources/lotto.txt"
  val conf = new SparkConf().setAppName("My App").setMaster("local[2]")
  val sc = new SparkContext(conf)
  val logData = sc.textFile(textFile, 2).cache()
  val numAs = logData.filter(line => line.contains("Guinevere")).count()
  val numBs = logData.filter(line => line.contains("Arthur")).count()
  println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
}

class TestApp {

}
