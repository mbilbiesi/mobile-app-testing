package com.hs.mobile.service.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
@JsonDeserialize(builder = DeviceInformation.DeviceInformationBuilder.class)
public class DeviceInformation {

  @JsonProperty("success")
  boolean success;

  @JsonProperty("device")
  Device device;
}
