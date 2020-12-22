package com.hs.mobile.service.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
@JsonDeserialize(builder = LifeTime.LifeTimeBuilder.class)
public class LifeTime {

  @JsonProperty("stop")
	String stop;

  @JsonProperty("start")
	String start;
}
