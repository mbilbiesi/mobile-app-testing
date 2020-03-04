package com.hs.mobile.data.testData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Locations {

    @JsonProperty("location_ar")
    private String locationAr;

    @JsonProperty("locationId")
    private String locationId;

    @JsonProperty("location_en")
    private String locationEn;

    @JsonProperty("locationType")
    private String locationType;
}