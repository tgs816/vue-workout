lazy val root = (project in file(".")).enablePlugins(PlayScala)
name :="vresource"
version :="1.0.0"
scalaVersion := "2.11.8"
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
libraryDependencies += jdbc
libraryDependencies += "com.typesafe.play" %% "anorm" % "2.5.0"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1208.jre7"
libraryDependencies += "org.webjars" % "Semantic-UI" % "2.2.2"
libraryDependencies += "org.webjars" % "jquery" % "3.1.1"
libraryDependencies += "org.webjars.bower" % "vue-router" % "0.7.11"
libraryDependencies += "org.webjars" % "vue" % "1.0.24"
libraryDependencies += "org.webjars" % "vue-resource" % "0.9.3"


