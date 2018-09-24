name := "spark-pika"

version := "0.0.1"

scalaVersion := "2.11.11"

sparkVersion := "2.3.1"

libraryDependencies += "mrpowers" % "spark-daria" % "2.3.1_0.24.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.1" % "provided"
libraryDependencies += "MrPowers" % "spark-fast-tests" % "2.3.1_0.15.0" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
assemblyJarName in assembly := s"${name.value}_2.11-${sparkVersion.value}_${version.value}.jar"

assemblyShadeRules in assembly := Seq(
  ShadeRule.rename("com.github.mrpowers.spark.daria.**" -> "shadedSparkDariaForSparkPika.@1").inAll
)
