package org.training.restassured.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import org.training.restassured.properties.ConfigLoader;

public class MapRequestSpecBuilder {

  private MapRequestSpecBuilder() {
  }

  public static RequestSpecification jsonRequest() throws IOException {
    return new RequestSpecBuilder()
        .addRequestSpecification(baseSpecification())
        .setContentType(ContentType.JSON)
        .build();
  }

  public static RequestSpecification baseSpecification(Map<String, Object> queryParams)
      throws IOException {
    return new RequestSpecBuilder()
        .addRequestSpecification(baseSpecification())
        .addQueryParams(queryParams)
        .build();
  }

  public static RequestSpecification baseSpecification() throws IOException {
    PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
    String baseUri = ConfigLoader.getInstance().getBaseUrl();

    return new RequestSpecBuilder()
        .addFilter(RequestLoggingFilter.logRequestTo(log))
        .setBaseUri(baseUri)
        .addQueryParam("key", "qaclick123")
        .build();
  }
}
