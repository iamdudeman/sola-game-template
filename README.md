# sola-game-template

Template project for building a game using [sola-game-engine](https://github.com/iamdudeman/sola-game-engine).

A [Design document template](docs/DesignDocument.md) is provided inspired by the content found on [develop.games](https://develop.games/)

## Project structure

* [Common game code](game/src)
* [Swing platform code](swing/src)
* [JavaFX platform code](javafx/src)
* [Browser platform code](browser/src)
* [Server code](server/src)

## JSON Schema

[JSON schema definitions](https://github.com/iamdudeman/sola-game-engine/tree/master/json-schema) are provided for
various
asset types. These can assist you in creating valid assets for the sola game engine to load when manually creating or
updating them.

* SpriteSheet
    * https://raw.githubusercontent.com/iamdudeman/sola-game-engine/master/json-schema/SpriteSheet.schema.json
* Font
    * https://raw.githubusercontent.com/iamdudeman/sola-game-engine/master/json-schema/Font.schema.json
* GuiDocument
    * https://raw.githubusercontent.com/iamdudeman/sola-game-engine/master/json-schema/GuiDocument.schema.json
* ControlConfig
    * https://raw.githubusercontent.com/iamdudeman/sola-game-engine/master/json-schema/ControlConfig.schema.json

### IntelliJ setup

1. Open settings
2. Go to `Languages & Frameworks | Schemas and DTDs | JSON Schema Mappings`
3. Click `+` and select the schema file to add
4. Add by file path pattern (recommendations below)
    * SpriteSheet -> `*.sprites.json`
    * Font -> `*.font.json`
    * GuiDocument -> `*.gui.json`
    * ControlConfig -> `*.controls.json`

## Packaging for release

### Browser zip file

Run the following gradle command

```shell
.\gradlew.bat distWebZip
```

The output will be at `dist/browser/<gameName>-browser-<version>.zip`.
This can be deployed to places like `itch.io` when using the "HTML" project type.

### Swing + JavaFx fat jar

Run the following gradle command

```shell
.\gradlew.bat distFatJar
```

The output will be at `dist/swing/<gameName>-swing-<version>.jar`
and `dist/javafx/<gameName>-javafx-<os>-<version>.jar`.
Your users will need to have Java 17 installed to run the jar.

### Swing + JavaFx .exe

You also have the option to use [jpackage](https://docs.oracle.com/en/java/javase/17/jpackage/packaging-overview.html)
to create an executable exe file. Your users will not need to have Java installed.

1. Install [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2. Update $JAVA_HOME path environment variable
    * ex. C:\Program Files\Java\jdk-17.0.5
    * To test configuration run: `jpackage --version`
        * Should see the current jdk version returned: `17.0.5`
3. Run the following gradle command

```shell
.\gradlew.bat distFatJarZip
```

4. Output will be in the `dist` directory
