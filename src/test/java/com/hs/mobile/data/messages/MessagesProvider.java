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
    private static final String MESSAGES_SOURCE = "data/messagess.json";
    List<Messages> messagesList;

    String language;

    public MessagesProvider(String language) {
        this.language = language;
        try {
            String messagesFile =
                    Resources.toString(Resources.getResource(MESSAGES_SOURCE), Charsets.UTF_8);
            messagesList =
                    new ObjectMapper().readValue(messagesFile, new TypeReference<List<Messages>>() {
                    });
        } catch (IOException e) {
            LOG.error("Unable to read messages test data file", e);
        }
    }

    private Messages getMessage(String messageTitle) {
        return messagesList.stream()
                .filter(msg -> msg.getTitle().equalsIgnoreCase(messageTitle))
                .findFirst()
                .orElseThrow(
                        ExceptionSupplier.failedToInitializeTest("Unable to find a message by it's title"));
    }

    public String getMessageContent(String messageTitle) {
        if (language.equalsIgnoreCase("en")) {
            return getMessage(messageTitle).getMessageEn();
        } else {
            return getMessage(messageTitle).getMessageAr();
        }
    }
}
