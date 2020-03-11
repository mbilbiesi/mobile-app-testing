package com.hs.mobile.data.messages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hs.mobile.exception.ExceptionSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class MessagesProvider {
    private static final Logger LOG = LoggerFactory.getLogger(MessagesProvider.class);
    private static final String MESSAGES_SOURCE = "data/messages.json";
    private List<Messages> messagesList;
    private List<CreateTicket> createTicketMessages;
    private List<Help> helpMessages;
    private List<Invoices> invoicesMessages;
    private List<Settings> settingsMessages;
    private List<Tickets> ticketsMessages;

    private String language;

    public MessagesProvider(String language) {
        try {
            String messagesFile = Resources.toString(Resources.getResource(MESSAGES_SOURCE), Charsets.UTF_8);
            messagesList =
                    new ObjectMapper().readValue(messagesFile, new TypeReference<List<Messages>>() {
                    });
            this.language = language;
        } catch (IOException e) {
            LOG.error("Failed to read messages json file", e);
        }
    }

    public String getMessage(String screen, String title) {
        CreateTicket createTicketMessage;
        Help helpMessage;
        Invoices invoicesMessage;
        Settings settingsMessage;
        Tickets ticketsMessage;

        String message;

        screen = screen.toLowerCase();

        switch (screen) {
            case "create ticket":
                createTicketMessage = createTicketMessages.stream()
                        .filter(createTicketScr -> createTicketScr.getTitle().contains(title)).findFirst()
                        .orElseThrow(ExceptionSupplier.failedToInitializeTest("unable to find message by it's title"));
                if (language.equalsIgnoreCase("en")) {
                    message = createTicketMessage.getMessageEn();
                } else {
                    message = createTicketMessage.getMessageAr();
                }
            case "help":
                helpMessage = helpMessages.stream()
                        .filter(createTicketScr -> createTicketScr.getTitle().contains(title)).findFirst()
                        .orElseThrow(ExceptionSupplier.failedToInitializeTest("unable to find message by it's title"));
                if (language.equalsIgnoreCase("en")) {
                    message = helpMessage.getMessageEn();
                } else {
                    message = helpMessage.getMessageAr();
                }
            case "invoices":
                invoicesMessage = invoicesMessages.stream()
                        .filter(createTicketScr -> createTicketScr.getTitle().contains(title)).findFirst()
                        .orElseThrow(ExceptionSupplier.failedToInitializeTest("unable to find message by it's title"));
                if (language.equalsIgnoreCase("en")) {
                    message = invoicesMessage.getMessageEn();
                } else {
                    message = invoicesMessage.getMessageAr();
                }
            case "tickets":
                ticketsMessage = ticketsMessages.stream()
                        .filter(createTicketScr -> createTicketScr.getTitle().contains(title)).findFirst()
                        .orElseThrow(ExceptionSupplier.failedToInitializeTest("unable to find message by it's title"));
                if (language.equalsIgnoreCase("en")) {
                    message = ticketsMessage.getMessageEn();
                } else {
                    message = ticketsMessage.getMessageAr();
                }
            case "settings":
                settingsMessage = settingsMessages.stream()
                        .filter(createTicketScr -> createTicketScr.getTitle().contains(title)).findFirst()
                        .orElseThrow(ExceptionSupplier.failedToInitializeTest("unable to find message by it's title"));
                if (language.equalsIgnoreCase("en")) {
                    message = settingsMessage.getMessageEn();
                } else {
                    message = settingsMessage.getMessageAr();
                }
            default:
                message = "message has not been obtained";
        }

        return message;
    }
}
