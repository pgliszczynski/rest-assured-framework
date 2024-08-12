package org.training.restassured.properties;

import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

  private static ConfigLoader configLoader;
  private final Properties properties;

  private ConfigLoader() throws IOException {
    this.properties = PropertyUtils.loadProperties("global.properties");
  }

  public static ConfigLoader getInstance() throws IOException {
    if (configLoader == null) {
      configLoader = new ConfigLoader();
    }
    return configLoader;
  }

  public String getBaseUrl() {
    return properties.getProperty("baseUrl");
  }
}
