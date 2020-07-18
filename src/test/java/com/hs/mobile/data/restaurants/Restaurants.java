package com.hs.mobile.data.restaurants;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Restaurants {

  @JsonProperty("ar")
  private String ar;

  @JsonProperty("restaurantType")
  private String restaurantType;

  @JsonProperty("en")
  private String en;

  @JsonProperty("restaurantId")
  private String restaurantId;

  @JsonProperty("status")
  private String status;
}
