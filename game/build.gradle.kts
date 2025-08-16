apply(plugin = "technology.sola.plugins.sola-java-conventions")

configure<JavaPluginExtension> {
  dependencies.add("implementation", "com.github.iamdudeman.sola-game-engine:sola-engine:${project.properties["solaVersion"]}")
}
