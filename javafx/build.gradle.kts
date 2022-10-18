plugins {
  id("application")
  id("sola.java-conventions")
}

application {
  mainClass.set("${project.properties["basePackage"]}.javafx.JavaFxMain")
}

dependencies {
  implementation("com.github.iamdudeman.sola-game-engine:platform-javafx:${project.properties["solaVersion"]}")
  implementation(project(":game"))

  var osClassifier = "win"

  if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_MAC)) {
    osClassifier = "mac"
  } else if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX)) {
    osClassifier = "linux"
  }

  runtimeOnly("org.openjfx", "javafx-base", "17.0.2", classifier = osClassifier)
  runtimeOnly("org.openjfx", "javafx-controls", "17.0.2", classifier = osClassifier)
  runtimeOnly("org.openjfx", "javafx-graphics", "17.0.2", classifier = osClassifier)
}
