package com.hs.mobile.service.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
@JsonDeserialize(builder = Owner.OwnerBuilder.class)
public class Owner {

  @JsonProperty("name")
	String name;

  @JsonProperty("email")
	String email;
}
