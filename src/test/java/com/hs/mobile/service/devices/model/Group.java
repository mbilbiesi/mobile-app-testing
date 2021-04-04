package com.hs.mobile.service.devices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
@JsonDeserialize(builder = Group.GroupBuilder.class)
public class Group {

  @JsonProperty("owner")
  Owner owner;

  @JsonProperty("origin")
  String origin;

  @JsonProperty("name")
  String name;

  @JsonProperty("lock")
  boolean lock;

  @JsonProperty("id")
  String id;

  @JsonProperty("lifeTime")
  LifeTime lifeTime;

  @JsonProperty("class")
  String jsonMemberClass;

  @JsonProperty("repetitions")
  int repetitions;

  @JsonProperty("originName")
  String originName;
}
