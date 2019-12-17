package com.hs.mobile.rest.model.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItem {
    @JsonProperty
    private Integer id;
    @JsonProperty("menugroup_id")
    private Integer menuGroupId;
    @JsonProperty("product_id")
    private Integer productId;
    @JsonProperty
    private String price;
    @JsonProperty
    private Integer calories;
    @JsonProperty
    private Integer weight;
    @JsonProperty
    private String name;
    @JsonProperty("name_en")
    private String nameEn;
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty
    private String description;
    @JsonProperty
    private List<Object> images;
    @JsonProperty("modifier_group_ids")
    private List<Integer> modifierGroupIds;
    @JsonProperty("list_price")
    private String listPrice;
    @JsonProperty("list_calories")
    private String listCalories;
    @JsonProperty("working_times")
    private List<Object> workingTimes;
}
