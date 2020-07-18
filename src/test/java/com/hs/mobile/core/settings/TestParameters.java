package com.hs.mobile.core.settings;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TestParameters {

  private final String deviceUDID;
  private final String platformName;
  private final String platformVersion;
  private final String uniquePort;
  private final String assignedTestUserId;
  private final String appiumURL;
}
