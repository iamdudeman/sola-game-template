import technology.sola.plugins.SolaJavaDistributionPluginExtension

apply(plugin = "technology.sola.plugins.sola-java-conventions")
apply(plugin = "technology.sola.plugins.sola-java-distribution")

configure<JavaPluginExtension> {
  dependencies.add("implementation", "com.github.iamdudeman.sola-game-engine:platform-swing:${project.properties["solaVersion"]}")
  dependencies.add("implementation", project(":game"))
}

configure<SolaJavaDistributionPluginExtension> {
  mainClass = "${project.properties["basePackage"]}.${project.name}.SwingMain"
}
