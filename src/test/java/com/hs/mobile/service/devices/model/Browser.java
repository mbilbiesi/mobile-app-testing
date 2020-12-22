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
@JsonDeserialize(builder = Browser.BrowserBuilder.class)
public class Browser {

  @JsonProperty("selected")
	boolean selected;

  @JsonProperty("apps")
	List<AppsItem> apps;
}
