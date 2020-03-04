package com.hs.mobile.data.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class Help {

    @JsonProperty("messages")
    private List<MessagesItem> messages;
}