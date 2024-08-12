package org.training.restassured.steps;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.training.restassured.data.ApiBody;
import org.training.restassured.data.Location;
import org.training.restassured.data.Place;
import org.training.restassured.data.Place.PlaceBuilder;
import org.training.restassured.data.constants.ApiResources;
import org.training.restassured.utils.HttpMethodBuilder;
import org.training.restassured.utils.JsonPathUtils;
import org.training.restassured.utils.MapRequestSpecBuilder;

public class StepDefinition {

  private static String placeId;
  private RequestSpecification request;
  private Response response;

  @Given("Add Place Payload with {string} {string} {string}")
  public void add_place_payload(String name, String language, String address) throws IOException {
    Place place = new PlaceBuilder()
        .accuracy(50)
        .address(address)
        .language(language)
        .location(new Location(-36.745, 34.225))
        .phoneNumber("1112222333")
        .name(name)
        .types(List.of("cafe", "place"))
        .website("https://google.com")
        .build();

    request = given()
        .spec(MapRequestSpecBuilder.jsonRequest())
        .body(place);
  }

  @Given("Delete Place Payload")
  public void delete_place_payload() throws IOException {
    request = given().spec(MapRequestSpecBuilder.jsonRequest())
                     .body(ApiBody.buildDeleteBody(placeId));
  }

  @When("User calls {string} with {string} HTTP request")
  public void user_calls_with_http_request(String resource, String httpMethod) {
    response = HttpMethodBuilder.buildHttpMethod(request, httpMethod,
                                    ApiResources.getResourceEndpoint(resource)).
        then()
              .log().all()
              .assertThat()
              .extract()
              .response();
  }

  @Then("The response returns status code {int}")
  public void the_response_returns_status_code(int statusCode) {
    assertEquals(Integer.valueOf(statusCode), response.getStatusCode());
  }

  @Then("{string} is {string}")
  public void is(String key, String value) {
    String returnedValue = JsonPathUtils.getKey(response, key);
    assertEquals(value, returnedValue);
  }

  @Then("verify place_id created maps to {string} using {string}")
  public void verifyPlace_idCreatedMapsToUsing(String name, String resource) throws IOException {
    placeId = JsonPathUtils.getPlaceId(response);

    request = given()
        .spec(MapRequestSpecBuilder.baseSpecification(
            Map.of("place_id", placeId)
        ));
    user_calls_with_http_request(resource, "GET");

    String placeName = JsonPathUtils.getName(response);
    assertEquals(placeName, name);
  }

  public static String getPlaceId() {
    return placeId;
  }
}
