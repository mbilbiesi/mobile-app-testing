package com.hs.mobile.data.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Messages {

    @JsonProperty("message_ar")
    private String messageAr;

    @JsonProperty("message_en")
    private String messageEn;

    @JsonProperty("screen")
    private String screen;

    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("title")
    private String title;
}