import technology.sola.plugins.SolaJavaDistributionPluginExtension

apply(plugin = "technology.sola.plugins.sola-java-conventions")
apply(plugin = "technology.sola.plugins.sola-java-distribution")

configure<JavaPluginExtension> {
  dependencies.add("implementation", "com.github.iamdudeman.sola-game-engine:editor:${project.properties["solaVersion"]}")
  dependencies.add("implementation", project(":game"))
}

configure<SolaJavaDistributionPluginExtension> {
  mainClass = "${project.properties["basePackage"]}.${project.name}.EditorMain"
  useJavaFx = true
}

project.afterEvaluate {
  tasks.named("distFatJar") {
    enabled = false
  }

  tasks.named("distWinJPackageZip") {
    enabled = false
  }

  tasks.named("distWinJPackage") {
    enabled = false
  }
}
