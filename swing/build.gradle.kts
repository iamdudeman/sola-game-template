plugins {
  id("application")
  id("sola.java-conventions")
}

application {
  mainClass.set("technology.sola.swing.SwingMain")
}

repositories {
  mavenCentral()
}

dependencies {
  api(files("../libs/sola-engine-swing-fat-${project.properties["solaVersion"]}.jar"))
  implementation(project(":game"))
}

tasks.withType<Jar>() {
  manifest {
    attributes["Main-Class"] = "technology.sola.swing.SwingMain"
  }

  duplicatesStrategy = DuplicatesStrategy.EXCLUDE
  dependsOn(configurations.runtimeClasspath)

  from({
    configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
  })

  archiveBaseName.set("sola-game-template-${project.name}")
}

tasks.withType<Zip>() {
  duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.withType<Tar>() {
  duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
