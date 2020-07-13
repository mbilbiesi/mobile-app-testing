package com.hs.mobile.data.messages;

import static com.hs.mobile.exception.ExceptionSupplier.failedToInitializeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.data.messages.model.ScreenLabels;
import java.io.IOException;
import java.util.List;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScreenLabelsProvider {

  private static final String MESSAGES_SOURCE = "data/screenLabels.json";
  private static List<ScreenLabels> screenLabelsList;
  @NonNull
  private final TestSettings settings;

  public ScreenLabelsProvider(@NonNull TestSettings settings) {
    this.settings = settings;

    try {
      String messagesFile =
          Resources.toString(Resources.getResource(MESSAGES_SOURCE), Charsets.UTF_8);
      screenLabelsList =
          new ObjectMapper().readValue(messagesFile, new TypeReference<List<ScreenLabels>>() {
          });
    } catch (IOException e) {
      log.error("Unable to read messages test data file", e);
    }
  }

  private ScreenLabels getMessage(String key) {
    return screenLabelsList.stream()
        .filter(labelKey -> labelKey.getKey().equalsIgnoreCase(key))
        .findFirst()
        .orElseThrow(failedToInitializeTest("Unable to find a message by it's title"));
  }

  public String getMessageContent(String key) {
    if (settings.getTestLanguage().equalsIgnoreCase("en")) {
      return getMessage(key).getLabelEn();
    } else {
      return getMessage(key).getLabelAr();
    }
  }
}
