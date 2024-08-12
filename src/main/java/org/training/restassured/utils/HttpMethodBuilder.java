package org.training.restassured.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpMethodBuilder {

  private HttpMethodBuilder() {
  }

  public static Response buildHttpMethod(RequestSpecification request, String httpMethod,
      String endpointUri) {
    return switch (httpMethod.toUpperCase()) {
      case "POST" -> request.when().post(endpointUri);
      case "GET" -> request.when().get(endpointUri);
      case "DELETE" -> request.when().delete(endpointUri);
      default -> throw new IllegalArgumentException("Unknown HTTP method");
    };
  }
}
