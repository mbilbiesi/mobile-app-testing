package com.hs.mobile.core.settings;

import com.hs.mobile.data.Language;
import io.appium.java_client.AppiumDriver;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TestSettings {
  private final AppiumDriver<?> driver;
  private final Language testLanguage;
}
