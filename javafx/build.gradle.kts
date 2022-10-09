plugins {
  id("application")
  id("sola.java-conventions")
}

application {
  mainClass.set("${project.properties["basePackage"]}.javafx.JavaFxMain")
}

repositories {
  mavenCentral()

  maven {
    url = uri("https://jitpack.io")
  }
}

dependencies {
  implementation("com.github.iamdudeman.sola-game-engine:platform-javafx:${project.properties["solaVersion"]}")
  implementation(project(":game"))

  // todo figure out how to do this per platform instead of hardcoded to windows
  runtimeOnly("org.openjfx", "javafx-base", "17.0.2", classifier = "win")
  runtimeOnly("org.openjfx", "javafx-controls", "17.0.2", classifier = "win")
  runtimeOnly("org.openjfx", "javafx-graphics", "17.0.2", classifier = "win")
}

tasks.withType<Zip>() {
  duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.withType<Tar>() {
  duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
