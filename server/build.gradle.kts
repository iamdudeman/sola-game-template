import technology.sola.plugins.SolaJavaDistributionPluginExtension

plugins {
  id("java")
}

apply(plugin = "technology.sola.plugins.sola-java-conventions")
apply(plugin = "technology.sola.plugins.sola-java-distribution")

dependencies {
  implementation("com.github.iamdudeman.sola-game-engine:server:${project.properties["solaVersion"]}")
  implementation(project(":game"))
}

configure<SolaJavaDistributionPluginExtension> {
  mainClass = "${project.properties["basePackage"]}.${project.name}.ServerMain"
}
