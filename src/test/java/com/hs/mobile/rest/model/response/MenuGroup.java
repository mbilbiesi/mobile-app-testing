package com.hs.mobile.rest.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuGroup {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty("name_en")
    private String nameEn;
    @JsonProperty("display_mode")
    private String displayMode;
    @JsonProperty
    private Integer weight;
    @JsonProperty("branch_id")
    private Integer branchId;
    @JsonProperty("working_times")
    private List<Object> workingTimes;
}
