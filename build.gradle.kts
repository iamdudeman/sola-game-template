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
      classpath("com.android.tools.build:gradle:9.1.1")

      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-android-conventions.gradle.plugin:${project.property("solaVersion")}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-android-app.gradle.plugin:${project.property("solaVersion")}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-java-conventions.gradle.plugin:${project.property("solaVersion")}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-javafx.gradle.plugin:${project.property("solaVersion")}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-java-distribution.gradle.plugin:${project.property("solaVersion")}")
      classpath("com.github.iamdudeman.sola-game-engine:technology.sola.plugins.sola-web-distribution.gradle.plugin:${project.property("solaVersion")}")
    }
  }

  tasks.withType<JavaExec>().configureEach {
    if (name.endsWith("main()")) {
      notCompatibleWithConfigurationCache("JavaExec created by IntelliJ")
    }
  }
}
