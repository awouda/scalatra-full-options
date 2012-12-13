import sbt._


object ScalatraFullOptionsBuild extends Build {
    lazy val root = Project(id = "scala-full-options",
                            base = file(".")) aggregate(web,domain)

  lazy val web = Project(id = "scalatra-project",
                           base = file("scalatra-project")) dependsOn(domain)

  lazy val domain = Project(id = "domain-project",
                           base = file("domain-project"))
}
