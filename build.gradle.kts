subprojects {
  buildscript {
    repositories {
      gradlePluginPortal()

      maven {
        url = uri("https://jitpack.io")
      }
    }

    dependencies {
      classpath("gradle.plugin.com.github.spotbugs.snom:spotbugs-gradle-plugin:4.7.2")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-java-conventions.gradle.plugin:${project.properties["solaVersion"]}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-java-distribution.gradle.plugin:${project.properties["solaVersion"]}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-web-distribution.gradle.plugin:${project.properties["solaVersion"]}")
    }
  }
}
