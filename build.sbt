name := "spark-pika"

version := "0.0.1"

scalaVersion := "2.11.11"

sparkVersion := "2.2.0"
sparkComponents ++= Seq("sql")

libraryDependencies += "MrPowers" % "spark-fast-tests" % "2.2.0_0.5.0" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "mrpowers" % "spark-daria" % "2.2.0_0.12.0" % "test"

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "_" + sv.binary + "-" + sparkVersion.value + "_" + module.revision + "." + artifact.extension
}
