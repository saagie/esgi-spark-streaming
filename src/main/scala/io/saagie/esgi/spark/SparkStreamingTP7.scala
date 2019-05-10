package io.saagie.esgi.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

object SparkStreamingTP7 {

  val schema: StructType = new StructType()
    .add("topic", StringType)
    .add("timestamp", StringType)
    .add("device", StringType)
    .add("value", IntegerType)


  def main(args: Array[String]) {

    val spark = SparkSession
      .builder
      .appName("TP7")
      .getOrCreate()

  }
}
