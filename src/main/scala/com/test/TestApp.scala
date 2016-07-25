package com.test

import org.apache.spark.{SparkContext, SparkConf}

object TestApp extends App {
  val spark = new SparkContext(new SparkConf().setAppName("My App").setMaster("local[4]"))

  val raw = spark.textFile("src/main/resources/lotto.txt", 10).cache()

  val artistAlias = raw.flatMap { line =>
    val tokens = line.split('\t')
    if (tokens(0).isEmpty) {
      None
    } else {
      Some((tokens(0).toInt, tokens(2).toInt))
    }
  }.collectAsMap()


//    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
}

class TestApp {

}
