package org.training.restassured.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

  @JsonProperty("lat")
  private final double latitude;
  @JsonProperty("lng")
  private final double longitude;

  public Location(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }
}
