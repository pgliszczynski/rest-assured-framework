package org.training.restassured.data.constants;

public class ApiResources {

  private final static String ADD_PLACE_API = "maps/api/place/add/json";
  private final static String GET_PLACE_API = "maps/api/place/get/json";
  private final static String DELETE_PLACE_API = "maps/api/place/delete/json";

  private ApiResources() {
  }

  public static String getResourceEndpoint(String resource) {
    return switch (resource.toLowerCase()) {
      case "addplaceapi" -> ADD_PLACE_API;
      case "getplaceapi" -> GET_PLACE_API;
      case "deleteplaceapi" -> DELETE_PLACE_API;
      default -> throw new IllegalArgumentException("Unknown resource");
    };
  }
}
