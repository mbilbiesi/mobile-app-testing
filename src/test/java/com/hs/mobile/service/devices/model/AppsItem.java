package com.hs.mobile.service.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
@JsonDeserialize(builder = AppsItem.AppsItemBuilder.class)
public class AppsItem {

  @JsonProperty("system")
  boolean system;

  @JsonProperty("name")
  String name;

  @JsonProperty("developer")
  String developer;

  @JsonProperty("id")
  String id;

  @JsonProperty("type")
  String type;

  @JsonProperty("selected")
  boolean selected;
}
