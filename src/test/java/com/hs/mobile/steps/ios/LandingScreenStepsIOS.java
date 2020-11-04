package com.hs.mobile.steps.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.LandingScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.LandingScreenSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingScreenStepsIOS extends BaseSteps<LandingScreenStepsIOS>
    implements LandingScreenSteps {

  @NonNull private final LandingScreen landingScreen;
  @NonNull private final AppiumDriver<MobileElement> driver;

  public LandingScreenStepsIOS(@NonNull TestSettings testSettings) {
    super(testSettings);
    landingScreen = new LandingScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Override
  @Step("Handling Location permission popup")
  public void handleLocationPopup() {
    try {
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.findElement(By.id("Allow Once")).click();
    } catch (NoSuchElementException ignored) {
    } finally {
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
  }

  @Override
  @Step("Handle promotion popup")
  public void handlePromotionPopup() {
    try {
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElement(By.id("content information")).click();
    } catch (NoSuchElementException ignored) {
    } finally {
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
  }

  @Override
  @Step("click on 'Select' to choose new address")
  public void selectNewAddress() {
    MobileElement btnDeliver = landingScreen.getBtnDeliveryTo();
    wait.withMessage("select address button is not displayed")
        .until(ExpectedConditions.visibilityOf(btnDeliver));
    btnDeliver.click();
  }

  @Override
  @Step("click on 'More' from tab bar")
  public void clickOnMore() {
    landingScreen.getBtnMore().click();
  }

  @Override
  @Step("Click on more actions")
  public void clickOnMoreActions() {
    landingScreen.getBtnMoreAction().click();
  }

  @Override
  @Step("Get address label")
  public String getAddressLabel() {
    return landingScreen.getAddressLabel().getText();
  }

  @Override
  @Step("Click on 'Edit' address")
  public void clickOnEditAddress() {
    landingScreen.getBtnEditAddress().click();
  }

  @Override
  @Step("Click on 'Delete' address")
  public void clickOnDeleteAddress() {
    landingScreen.getBtnDeleteAddress().click();
  }

  @Override
  @Step("Confirm remove address")
  public void confirmRemoveAddress() {
    landingScreen.getBtnRemove().click();
  }

  @Override
  @Step("Verify '{0}' address type is appeared in search field")
  public void verifySearchFieldValueIsEqualTo(String value) {
    wait.withMessage("Address type is not displayed in search field")
        .until(
            ExpectedConditions.textToBePresentInElementValue(landingScreen.getBtnChoose(), value));
  }
}
