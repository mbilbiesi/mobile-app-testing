package com.hs.mobile.data.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ScreensItem {

    @JsonProperty("settings")
    private Settings settings;

    @JsonProperty("invoices")
    private Invoices invoices;

    @JsonProperty("help")
    private Help help;

    @JsonProperty("createTicket")
    private CreateTicket createTicket;

    @JsonProperty("tickets")
    private Tickets tickets;
}