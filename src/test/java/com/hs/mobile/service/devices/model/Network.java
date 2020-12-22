package com.hs.mobile.service.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
@JsonDeserialize(builder = Network.NetworkBuilder.class)
public class Network {

  @JsonProperty("connected")
	boolean connected;

  @JsonProperty("roaming")
	boolean roaming;

  @JsonProperty("failover")
	boolean failover;

  @JsonProperty("subtype")
	String subtype;

  @JsonProperty("type")
	String type;
}
