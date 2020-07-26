package com.hs.mobile.data.messages.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ScreenLabels {

  @JsonProperty("key")
  private String key;

  @JsonProperty("ar")
  private String labelAr;

  @JsonProperty("en")
  private String labelEn;
}
