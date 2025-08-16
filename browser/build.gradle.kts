apply(plugin = "technology.sola.plugins.sola-java-conventions")
apply(plugin = "technology.sola.plugins.sola-web-distribution")

configure<JavaPluginExtension> {
  dependencies.add("implementation", "com.github.iamdudeman.sola-game-engine:platform-browser:${project.properties["solaVersion"]}")
  dependencies.add("implementation", project(":game"))
}
