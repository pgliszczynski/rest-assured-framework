package org.training.restassured.utils;

import io.restassured.response.Response;

public class JsonPathUtils {

  private final static String PLACE_ID = "place_id";
  private final static String NAME = "name";

  private JsonPathUtils() {
  }

  public static String getPlaceId(Response response) {
    return getKey(response, PLACE_ID);
  }

  public static String getName(Response response) {
    return getKey(response, NAME);
  }

  public static String getKey(Response response, String key) {
    return response.jsonPath().getString(key);
  }
}
