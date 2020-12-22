package com.hs.mobile.service.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
@JsonDeserialize(builder = Battery.BatteryBuilder.class)
public class Battery {

  @JsonProperty("temp")
	double temp;

  @JsonProperty("level")
	int level;

  @JsonProperty("health")
	String health;

  @JsonProperty("scale")
	int scale;

  @JsonProperty("source")
	String source;

  @JsonProperty("status")
	String status;

  @JsonProperty("voltage")
	double voltage;
}
