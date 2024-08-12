package org.training.restassured.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import org.training.restassured.data.Place.PlaceBuilder;

@JsonDeserialize(builder = PlaceBuilder.class)
public class Place {

  private final Location location;
  private final int accuracy;
  private final String name;
  @JsonProperty("phone_number")
  private final String phoneNumber;
  private final String address;
  private final List<String> types;
  private final String website;
  private final String language;

  private Place(Location location, int accuracy, String name, String phoneNumber, String address,
      List<String> types, String website, String language) {
    this.location = location;
    this.accuracy = accuracy;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.types = types;
    this.website = website;
    this.language = language;
  }

  @JsonPOJOBuilder(withPrefix = "")
  public static class PlaceBuilder {

    private Location location;
    private int accuracy;
    private String name;
    private String phoneNumber;
    private String address;
    private List<String> types;
    private String website;
    private String language;

    public PlaceBuilder location(Location location) {
      this.location = location;
      return this;
    }

    public PlaceBuilder accuracy(int accuracy) {
      this.accuracy = accuracy;
      return this;
    }

    public PlaceBuilder name(String name) {
      this.name = name;
      return this;
    }

    public PlaceBuilder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public PlaceBuilder address(String address) {
      this.address = address;
      return this;
    }

    public PlaceBuilder types(List<String> types) {
      this.types = types;
      return this;
    }

    public PlaceBuilder website(String website) {
      this.website = website;
      return this;
    }

    public PlaceBuilder language(String language) {
      this.language = language;
      return this;
    }

    public Place build() {
      return new Place(location, accuracy, name, phoneNumber, address, types,
          website, language);
    }
  }

  public Location getLocation() {
    return location;
  }

  public int getAccuracy() {
    return accuracy;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public List<String> getTypes() {
    return types;
  }

  public String getWebsite() {
    return website;
  }

  public String getLanguage() {
    return language;
  }
}
