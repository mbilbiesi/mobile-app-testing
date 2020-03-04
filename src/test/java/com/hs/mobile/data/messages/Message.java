package com.hs.mobile.data.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Message {

    @JsonProperty("ar")
    private String ar;

    @JsonProperty("en")
    private String en;
}