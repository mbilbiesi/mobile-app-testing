package com.hs.mobile.data;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public enum Language {
  ARABIC("ar", "العربية"),
  ENGLISH("en", "English");

  private String value;
  private String label;

  Language(String value, String label) {
    this.value = value;
    this.label = label;
  }

  public static Optional<Language> getByLabel(String label) {
    if (StringUtils.isBlank(label)) {
      return Optional.empty();
    }

    for (Language language : Language.values()) {
      if (language.label.equals(label)) {
        return Optional.of(language);
      }
    }
    return Optional.empty();
  }
}
