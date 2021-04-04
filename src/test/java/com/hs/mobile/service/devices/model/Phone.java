package com.hs.mobile.service.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
@JsonDeserialize(builder = Phone.PhoneBuilder.class)
public class Phone {

  @JsonProperty("iccid")
  Object iccid;

  @JsonProperty("phoneNumber")
  Object phoneNumber;

  @JsonProperty("imei")
  Object imei;

  @JsonProperty("imsi")
  Object imsi;

  @JsonProperty("network")
  String network;
}
