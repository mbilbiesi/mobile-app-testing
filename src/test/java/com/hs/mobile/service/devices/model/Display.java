package com.hs.mobile.service.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
@JsonDeserialize(builder = Display.DisplayBuilder.class)
public class Display {

  @JsonProperty("density")
  double density;

  @JsonProperty("size")
  double size;

  @JsonProperty("rotation")
  int rotation;

  @JsonProperty("fps")
  double fps;

  @JsonProperty("width")
  int width;

  @JsonProperty("id")
  int id;

  @JsonProperty("secure")
  boolean secure;

  @JsonProperty("ydpi")
  double ydpi;

  @JsonProperty("xdpi")
  double xdpi;

  @JsonProperty("url")
  String url;

  @JsonProperty("height")
  int height;
}
