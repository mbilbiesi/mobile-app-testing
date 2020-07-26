package com.hs.mobile.data;

import com.hs.mobile.exception.TestInitializationException;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public enum Language {
  AR("ar", "العربية"),
  EN("en", "English");

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

  public static Language fromString(String name) {
    for (Language language : values()) {
      if (language.toString().equalsIgnoreCase(name)) {
        return language;
      }
    }
    throw new TestInitializationException("Unrecognized language: " + name);
  }

  public boolean is(Language compareWith) {
    return this == compareWith;
  }
}
