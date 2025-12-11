apply(plugin = "technology.sola.plugins.sola-java-conventions")
apply(plugin = "technology.sola.plugins.sola-javafx")

configure<JavaPluginExtension> {
  dependencies.add("implementation", "com.github.iamdudeman.sola-game-engine:editor:${project.properties["solaVersion"]}")
  dependencies.add("implementation", project(":game"))
}
