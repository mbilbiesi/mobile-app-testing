package com.hs.mobile.steps.ios;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assumptions.assumeThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.LandingScreen;
import com.hs.mobile.steps.BaseSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LandingScreenSteps extends BaseSteps {

  @NonNull private final LandingScreen landingScreen;
  @NonNull private final AppiumDriver<MobileElement> driver;

  public LandingScreenSteps(@NonNull TestSettings testSettings) {
    super(testSettings);
    landingScreen = new LandingScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Step("Handling Location popup")
  public void handleLocationPopup() {
    try {
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.findElement(By.id("Allow Once")).click();
    } catch (NoSuchElementException ignored) {
    } finally {
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
  }

  @Step("click on 'Select' to choose new address")
  public void selectNewAddress() {
    MobileElement btnDeliver = landingScreen.getBtnDeliveryTo();
    assumeThat(btnDeliver.isDisplayed()).as("select address button is not displayed").isTrue();

    touchAction
        .tap(tapOptions().withElement(element(btnDeliver)))
        .waitAction(waitOptions(Duration.ofMillis(250)))
        .perform();
  }
}
