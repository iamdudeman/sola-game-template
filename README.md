# sola-game-template
Template project for building a game using [sola-game-engine](https://github.com/iamdudeman/sola-game-engine).

## Project structure
* [Common game code](game/src)
* [Swing platform code](swing/src)
* [JavaFX platform code](javafx/src)
* [Browser platform code](browser/src)

## Creating Distributable Games
### Browser zip file
Run the following command
```shell
.\gradlew.bat distWebZip
```
The output will be at `browser/build/<gameName>-browser-<version>.zip`.
This can be deployed to places like `itch.io` when using the "HTML" project type.

### Swing + JavaFx fat jar
Run the following command
```shell
.\gradlew.bat distFatJar
```
The output will be at `swing/build/<gameName>-swing-<version>.jar` and `javafx/build/<gameName>-javafx-<os>-<version>.jar`.
Your users will need to have Java 17 installed to run the jar.

### Swing + JavaFx .exe
You also have the option to use [jpackage](
https://docs.oracle.com/en/java/javase/17/jpackage/packaging-overview.html) to create an executable exe file.
Your users will not need to have Java installed.

1. Install [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2. Update $JAVA_HOME path environment variable
  * ex. C:\Program Files\Java\jdk-17.0.5
  * powershell: $env:JAVA_HOME
  * To test configuration run: `& $env:JAVA_HOME/bin/jpackage.exe --version`
3. Run from sola-game-engine\examples\swing on Windows Powershell
```shell
& $env:JAVA_HOME/bin/jpackage.exe --name GameName --app-version 0.1.0 --vendor sola.technology --dest build --input build/libs --main-jar <gameName>-swing-0.1.1.jar --type app-image
```
4. Run from sola-game-engine\examples\javafx on Windows Powershell
```shell
& $env:JAVA_HOME/bin/jpackage.exe --name GameName --app-version 0.1.0 --vendor sola.technology --dest build --input build/libs --main-jar <gameName>-javafx-win-0.1.1.jar --type app-image
```
