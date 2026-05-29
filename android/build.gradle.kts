import com.android.build.api.dsl.ApplicationExtension

apply(plugin = "technology.sola.plugins.sola-android-conventions")
apply(plugin = "technology.sola.plugins.sola-android-app")

configure<ApplicationExtension> {
  dependencies.add("implementation", "com.github.iamdudeman.sola-game-engine:platform-android:${project.properties["solaVersion"]}")
  dependencies.add("implementation", project(":game"))
}
