package com.hs.mobile.service.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
@JsonDeserialize(builder = AllDevices.AllDevicesBuilder.class)
public class AllDevices {

  @JsonProperty("devices")
  List<DevicesItem> devices;

  @JsonProperty("success")
  boolean success;

  @JsonProperty("description")
  String description;
}
