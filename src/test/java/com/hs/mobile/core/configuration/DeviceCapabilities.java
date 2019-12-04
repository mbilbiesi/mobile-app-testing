package com.hs.mobile.core.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Builder
@Accessors(fluent = true)
public class DeviceCapabilities {

    @JsonProperty
    private String platformName;

    @JsonProperty
    private String platformVersion;

    @JsonProperty
    private String udid;

    @JsonProperty
    private String systemPort;
}
