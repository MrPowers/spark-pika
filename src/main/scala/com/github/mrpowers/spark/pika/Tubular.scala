package com.github.mrpowers.spark.pika

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object Tubular {

  def withGoodVibes()(df: DataFrame): DataFrame = {
    df.withColumn(
      "chi",
      lit("happy")
    )
  }

}
