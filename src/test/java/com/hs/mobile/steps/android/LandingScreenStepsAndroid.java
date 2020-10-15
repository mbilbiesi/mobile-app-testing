package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.LandingScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.LandingScreenSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LandingScreenStepsAndroid extends BaseSteps<LandingScreenStepsAndroid>
    implements LandingScreenSteps {

  @NonNull private final LandingScreen landingScreen;
  @NonNull private final AppiumDriver<MobileElement> driver;

  public LandingScreenStepsAndroid(@NonNull TestSettings testSettings) {
    super(testSettings);
    landingScreen = new LandingScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Override
  public void handleLocationPopup() {}

  @Override
  @Step("Handle promotion popup")
  public void handlePromotionPopup() {
    try {
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      driver.findElement(By.xpath("//android.view.View[@content-desc=\"تخطى الإعلان\"]")).click();
    } catch (NoSuchElementException ignored) {
    } finally {
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
  }

  @Step("click on 'Select' to choose new address")
  public void selectNewAddress() {
    tap(landingScreen.getLblDelivery());
  }
}
