import technology.sola.plugins.SolaJavaDistributionPluginExtension

plugins {
  id("sola.java-conventions")
}

apply(plugin = "technology.sola.plugins.sola-java-distribution")

dependencies {
  implementation("com.github.iamdudeman.sola-game-engine:editor:${project.properties["solaVersion"]}")
  implementation(project(":game"))
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
