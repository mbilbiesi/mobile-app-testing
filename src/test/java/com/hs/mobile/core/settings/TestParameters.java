package com.hs.mobile.core.settings;

import lombok.Builder;
import lombok.Getter;
import org.openqa.selenium.Platform;

@Builder
@Getter
public class TestParameters {

  private final String deviceUDID;
  private final Platform platform;
  private final String platformVersion;
  private final String uniquePort;
  private final String assignedTestUserId;
  private final String appiumURL;
}
