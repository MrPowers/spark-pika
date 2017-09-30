package com.github.mrpowers.spark.pika

import org.scalatest.FunSpec

import org.apache.spark.sql.types.StringType

import com.github.mrpowers.spark.fast.tests.DataFrameComparer
import com.github.mrpowers.spark.daria.sql.SparkSessionExt._

class TubularSpec
  extends FunSpec
  with SparkSessionWrapper
  with DataFrameComparer {

  describe("withGoodVibes") {

    it("appends a chi column to a DataFrame") {

      val sourceDF = spark.createDF(
        List(
          "sue",
          "fan"
        ), List(
          ("name", StringType, true)
        )
      )

      val actualDF = sourceDF.transform(Tubular.withGoodVibes())

      val expectedDF = spark.createDF(
        List(
          ("sue", "happy"),
          ("fan", "happy")
        ), List(
          ("name", StringType, true),
          ("chi", StringType, false)
        )
      )

      assertSmallDataFrameEquality(actualDF, expectedDF)

    }

  }

}

