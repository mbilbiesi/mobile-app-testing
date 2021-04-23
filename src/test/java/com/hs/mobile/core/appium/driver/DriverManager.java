package com.hs.mobile.core.appium.driver;

import static com.hs.mobile.exception.ExceptionSupplier.testException;
import static org.openqa.selenium.Platform.ANDROID;
import static org.openqa.selenium.Platform.IOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import java.net.URL;
import java.util.Optional;
import java.util.function.Supplier;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Platform;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;

@Slf4j
@RequiredArgsConstructor
public class DriverManager {
  @NonNull private final DesiredCapabilities desiredCapabilities;

  public AppiumDriver<MobileElement> getAppiumDriver(Platform platform, @NonNull String appiumURL) {
    AppiumDriver<MobileElement> driver = null;

    try {
      URL remoteAddress = new URL(appiumURL);
      if (platform.is(ANDROID)) {
        log.debug("Android driver with following capabilities : {}", desiredCapabilities.asMap());
        driver = retry(() -> new AndroidDriver<>(remoteAddress, desiredCapabilities));
      } else if (platform.is(IOS)) {
        log.debug("iOS driver with following capabilities : {}", desiredCapabilities.asMap());
        driver = retry(() -> new IOSDriver<>(remoteAddress, desiredCapabilities));
      }
    } catch (Exception e) {
      log.error("Error while instantiating driver: ", e);
    }
    return Optional.ofNullable(driver).orElseThrow(testException("failed to initiate drive"));
  }

  private <T> T retry(Supplier<T> retrySupplier) {
    RetryConfig tryAgain =
        RetryConfig.<String>custom()
            .retryExceptions(SessionNotCreatedException.class)
            .maxAttempts(2)
            .build();

    Retry retry = Retry.of("retry", tryAgain);
    return Retry.decorateSupplier(retry, retrySupplier).get();
  }
}
