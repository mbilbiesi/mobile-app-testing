package com.hs.mobile.core.appium.driver;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.exception.ExceptionSupplier;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.net.URL;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

@Slf4j
@RequiredArgsConstructor
public class DriverManager {

  @NonNull
  private final TestSettings testSettings;
  @NonNull
  private final DesiredCapabilities desiredCapabilities;

  public AppiumDriver<MobileElement> getAppiumDriver() {
    AppiumDriver<MobileElement> driver = null;
    String platformName = testSettings.getPlatformName();
    String appiumURL = testSettings.getAppiumURL();

    if (platformName.equalsIgnoreCase("android")) {
      try {
        driver = new AndroidDriver<>(new URL(appiumURL), desiredCapabilities);
      } catch (Exception e) {
        log.error("unable to initiate Android driver", e);
      }
    } else if (platformName.equalsIgnoreCase("ios")) {
      try {
        driver = new IOSDriver<>(new URL(appiumURL), desiredCapabilities);
      } catch (Exception e) {
        log.error("unable to initiate iOS driver", e);
      }
    }
    return Optional.ofNullable(driver).orElseThrow(ExceptionSupplier.testException());
  }
}
