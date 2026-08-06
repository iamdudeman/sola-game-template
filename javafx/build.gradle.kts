import technology.sola.plugins.SolaJavaDistributionPluginExtension

apply(plugin = "technology.sola.plugins.sola-java-conventions")
apply(plugin = "technology.sola.plugins.sola-javafx")
apply(plugin = "technology.sola.plugins.sola-java-distribution")

configure<JavaPluginExtension> {
  dependencies.add("implementation", "com.github.iamdudeman.sola-game-engine:platform-javafx:${project.property("solaVersion")}")
  dependencies.add("implementation", project(":game"))
}

configure<SolaJavaDistributionPluginExtension> {
  mainClass = "${project.property("basePackage")}.${project.name}.JavaFxMain"
  includeOsClassifier = true
}
