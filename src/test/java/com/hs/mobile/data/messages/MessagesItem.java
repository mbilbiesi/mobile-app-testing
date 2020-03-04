package com.hs.mobile.data.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MessagesItem {

    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("message")
    private Message message;
}