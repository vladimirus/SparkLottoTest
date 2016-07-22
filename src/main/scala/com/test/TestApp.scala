package com.test

import org.apache.spark.{SparkContext, SparkConf}

object TestApp extends App {
  val spark = new SparkContext(new SparkConf().setAppName("My App").setMaster("local[4]"))

  val logData = spark.textFile("src/main/resources/lotto.txt", 10).cache()

  val numAs = logData.filter(line => line.contains("Guinevere")).count()
  val numBs = logData.filter(line => line.contains("Arthur")).count()
  println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
}

class TestApp {

}
