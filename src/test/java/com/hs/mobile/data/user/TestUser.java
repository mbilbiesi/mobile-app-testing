package com.hs.mobile.data.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TestUser {

  @JsonProperty("id")
  private String id;

  @JsonProperty("mobileNumber")
  private String mobileNumber;

  @JsonProperty("verificationCode")
  private String verificationCode;

  @JsonProperty("language")
  private String language;
}
