package org.training.restassured.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

  private PropertyUtils() {
  }

  public static Properties loadProperties(String resourceFilePath) throws IOException {
    String fullFilePath = "src"
        + File.separator + "main"
        + File.separator + "resources"
        + File.separator + resourceFilePath;
    Properties properties = new Properties();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fullFilePath))) {
      properties.load(bufferedReader);
    }

    return properties;
  }
}
