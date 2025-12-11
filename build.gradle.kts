subprojects {
  buildscript {
    repositories {
      gradlePluginPortal()
      google()

      maven {
        url = uri("https://jitpack.io")
      }
    }

    dependencies {
      classpath("com.android.tools.build:gradle:8.12.3")

      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-android-conventions.gradle.plugin:${project.properties["solaVersion"]}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-android-app.gradle.plugin:${project.properties["solaVersion"]}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-java-conventions.gradle.plugin:${project.properties["solaVersion"]}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-javafx.gradle.plugin:${project.properties["solaVersion"]}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-java-distribution.gradle.plugin:${project.properties["solaVersion"]}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-web-distribution.gradle.plugin:${project.properties["solaVersion"]}")
    }
  }
}
