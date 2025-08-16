import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

apply(plugin = "technology.sola.plugins.sola-android-conventions")
apply(plugin = "technology.sola.plugins.sola-android-app")

configure<BaseAppModuleExtension> {
  dependencies.add("implementation", "com.github.iamdudeman.sola-game-engine:platform-android:${project.properties["solaVersion"]}")
  dependencies.add("implementation", project(":game"))
}
