package com.hs.mobile.core.settings;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TestSettings {

  private final AppiumDriver<MobileElement> driver;
  private final String testLanguage;
}
