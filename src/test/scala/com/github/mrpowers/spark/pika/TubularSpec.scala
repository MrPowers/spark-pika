package com.github.mrpowers.spark.pika

import org.scalatest.FunSpec

import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{StringType, StructField, StructType}

import com.github.mrpowers.spark.fast.tests.DataFrameComparer

class TubularSpec
  extends FunSpec
  with SparkSessionWrapper
  with DataFrameComparer {

  import spark.implicits._

  describe("withGoodVibes") {

    it("appends a chi column to a DataFrame") {

      val sourceDF = List("sue", "fan").toDF("name")

      val actualDF = sourceDF.transform(Tubular.withGoodVibes())

      val expectedSchema = List(
        StructField("name", StringType, true),
        StructField("chi", StringType, false)
      )

      val expectedData = List(
        Row("sue", "happy"),
        Row("fan", "happy")
      )

      val expectedDF = spark.createDataFrame(
        spark.sparkContext.parallelize(expectedData),
        StructType(expectedSchema)
      )

      assertSmallDataFrameEquality(actualDF, expectedDF)

    }

  }

}
