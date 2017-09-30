package com.github.mrpowers.spark.pika

import org.apache.spark.sql.SparkSession

trait SparkSessionWrapper {

  lazy val spark: SparkSession = {
    SparkSession
      .builder()
      .master("local")
      .appName("spark pika")
      .getOrCreate()
  }

}
