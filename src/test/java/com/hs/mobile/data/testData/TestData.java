package com.hs.mobile.data.testData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class TestData {

    @JsonProperty
    private List<Restaurants> restaurants;

    @JsonProperty
    private List<Locations> locations;
}