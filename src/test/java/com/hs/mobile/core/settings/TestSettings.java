package com.hs.mobile.core.settings;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class TestSettings {

  @Setter
  private AppiumDriver<MobileElement> driver;
  @Setter
  private String testLanguage;
  private final String appFilePath;
  private final String appiumURL;
  private final String deviceUDID;
  private final String platformName;
  private final String platformVersion;
  private final String uniquePort;
  private final String assignedTestUserId;
}
