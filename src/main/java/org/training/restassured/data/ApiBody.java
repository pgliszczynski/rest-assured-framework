package org.training.restassured.data;

public class ApiBody {

  private final static String DELETE_BODY = """
      {
        "place_id": "%s"
      }
      """;

  public static String buildDeleteBody(String placeId) {
    return String.format(DELETE_BODY, placeId);
  }
}
