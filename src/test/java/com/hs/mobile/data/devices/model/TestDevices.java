package com.hs.mobile.data.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TestDevices {

  @JsonProperty("deviceName")
  String deviceName;

  @JsonProperty("serial")
  String serial;

  @JsonProperty("port")
  String port;

  @JsonProperty("platform")
  String platform;
}
