package org.training.restassured.steps;

import io.cucumber.java.Before;
import java.io.IOException;

public class Hooks {

  @Before("@DeletePlace")
  public void beforeScenario() throws IOException {
    if (StepDefinition.getPlaceId() == null) {
      StepDefinition stepDefinition = new StepDefinition();
      stepDefinition.add_place_payload("Shetty", "French", "Asia");
      stepDefinition.user_calls_with_http_request("AddPlaceAPI", "POST");
      stepDefinition.verifyPlace_idCreatedMapsToUsing("Shetty", "GetPlaceAPI");
    }
  }
}
