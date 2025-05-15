package technology.sola.editor;

import technology.sola.engine.editor.SolaEditor;
import technology.sola.logging.JavaSolaLoggerFactory;
import technology.sola.logging.SolaLogLevel;
import technology.sola.logging.SolaLogger;

public class EditorMain {
  static {
    SolaLogger.configure(SolaLogLevel.INFO, new JavaSolaLoggerFactory());
  }

  public static void main(String[] args) {
    new SolaEditor().run();
  }
}
