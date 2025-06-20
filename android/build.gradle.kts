import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

// todo cleanup

//plugins {
//  id("sola-android-app") version "0.11.0"
//}

apply(plugin = "technology.sola.plugins.sola-android-conventions")
apply(plugin = "technology.sola.plugins.sola-android-app")

//repositories {
//  mavenCentral()
//  google()
//  gradlePluginPortal() // so that external plugins can be resolved in dependencies section
//}

configure<BaseAppModuleExtension> {
  dependencies.add("implementation", "com.github.iamdudeman.sola-game-engine:platform-android:${project.properties["solaVersion"]}")
  dependencies.add("implementation", project(":game"))
}

dependencies {
//  implementation("com.github.iamdudeman.sola-game-engine:platform-android:${project.properties["solaVersion"]}")
//  implementation(project(":game"))
}

//solaJavaDist {
//  mainClass = "${project.properties["basePackage"]}.${project.name}.AndroidMain"
//}
