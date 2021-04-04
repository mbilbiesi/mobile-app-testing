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
@JsonDeserialize(builder = Device.DeviceBuilder.class)
public class Device {

  @JsonProperty("usage")
  Object usage;

  @JsonProperty("channel")
  String channel;

  @JsonProperty("cpuPlatform")
  String cpuPlatform;

  @JsonProperty("battery")
  Battery battery;

  @JsonProperty("operator")
  Object operator;

  @JsonProperty("platform")
  String platform;

  @JsonProperty("manufacturer")
  String manufacturer;

  @JsonProperty("network")
  Network network;

  @JsonProperty("createdAt")
  String createdAt;

  @JsonProperty("statusChangedAt")
  String statusChangedAt;

  @JsonProperty("usageChangedAt")
  String usageChangedAt;

  @JsonProperty("presenceChangedAt")
  String presenceChangedAt;

  @JsonProperty("provider")
  Provider provider;

  @JsonProperty("ready")
  boolean ready;

  @JsonProperty("browser")
  Browser browser;

  @JsonProperty("remoteConnectUrl")
  Object remoteConnectUrl;

  @JsonProperty("model")
  String model;

  @JsonProperty("group")
  Group group;

  @JsonProperty("owner")
  Object owner;

  @JsonProperty("product")
  String product;

  @JsonProperty("using")
  boolean using;

  @JsonProperty("display")
  Display display;

  @JsonProperty("abi")
  String abi;

  @JsonProperty("remoteConnect")
  boolean remoteConnect;

  @JsonProperty("version")
  String version;

  @JsonProperty("marketName")
  String marketName;

  @JsonProperty("airplaneMode")
  boolean airplaneMode;

  @JsonProperty("logs_enabled")
  boolean logsEnabled;

  @JsonProperty("openGLESVersion")
  String openGLESVersion;

  @JsonProperty("phone")
  Phone phone;

  @JsonProperty("serial")
  String serial;

  @JsonProperty("sdk")
  String sdk;

  @JsonProperty("present")
  boolean present;

  @JsonProperty("reverseForwards")
  List<Object> reverseForwards;

  @JsonProperty("status")
  int status;
}
