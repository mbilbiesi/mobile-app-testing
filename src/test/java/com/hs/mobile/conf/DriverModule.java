package com.hs.mobile.conf;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hs.mobile.core.appium.driver.DriverManager;
import com.hs.mobile.core.settings.TestParameters;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

@SuppressWarnings("unused")
public class DriverModule extends AbstractModule {

  @Provides
  @Singleton
  public AppiumDriver<?> driver(
      DriverManager driverManager, TestParameters testParameters, TestProperties properties) {
    return driverManager.getAppiumDriver(
        testParameters.getPlatform(), properties.getAppiumServerUrl());
  }

  @Provides
  @Singleton
  public DriverManager driverManager(DesiredCapabilities capabilities) {
    return new DriverManager(capabilities);
  }
}
