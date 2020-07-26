package com.hs.mobile.core.appium.driver;

import static org.openqa.selenium.Platform.ANDROID;
import static org.openqa.selenium.Platform.IOS;

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
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

@Slf4j
@RequiredArgsConstructor
public class DriverManager {
  @NonNull private final DesiredCapabilities desiredCapabilities;

  public AppiumDriver<MobileElement> getAppiumDriver(Platform platform, @NonNull String appiumURL) {
    AppiumDriver<MobileElement> driver = null;

    if (platform.is(ANDROID)) {
      try {
        driver = new AndroidDriver<>(new URL(appiumURL), desiredCapabilities);
      } catch (Exception e) {
        log.error("unable to initiate Android driver", e);
      }
    } else if (platform.is(IOS)) {
      try {
        driver = new IOSDriver<>(new URL(appiumURL), desiredCapabilities);
      } catch (Exception e) {
        log.error("unable to initiate iOS driver", e);
      }
    }
    return Optional.ofNullable(driver)
        .orElseThrow(ExceptionSupplier.testException("failed to initiate drive"));
  }
}
