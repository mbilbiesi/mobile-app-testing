package com.hs.mobile.steps.ios;

import static io.appium.java_client.touch.TapOptions.tapOptions;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.VerticalsScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.util.CustomConditions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VerticalsScreenSteps extends BaseSteps {

  @NonNull private final VerticalsScreen verticalsScreen;
  AppiumDriver<?> driver;

  public VerticalsScreenSteps(@NonNull TestSettings testSettings) {
    super(testSettings);
    verticalsScreen = new VerticalsScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Step("click on the address from the address bar")
  public void clickOnAddress() {
    verticalsScreen.getBtnChoose().click();
  }

  @Step("Click on add new address from the verticals page")
  public void clickOnAddNewLocation() {
    touchAction.tap(
        tapOptions().withElement(ElementOption.element(verticalsScreen.getLblNewLocation())))
        .waitAction()
        .perform();
  }

  @Step("verify all verticals are displayed")
  public void assertAllVerticals() {
    wait.withMessage("'All stores' vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblAllStores()));
    wait.withMessage("Quick Market vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblQuickMarket()));
    wait.withMessage("'Order Anything' vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblOrderAnything()));
  }

  @Step("Verify two verticals are displayed and order-anything verticals is not present")
  public void assertTwoVerticalsAreDisplayed() {
    wait.withMessage("'All stores' vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblAllStores()));
    wait.withMessage("Quick Market vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblQuickMarket()));
    wait.withMessage("'Order Anything' vertical expect not to be displayed")
        .until(CustomConditions.elementIsNotDisplayed(verticalsScreen.getLblOrderAnything()));
  }

  @Step("Verify all-stores vertical is displayed")
  public void verifyAllStoresVertical() {
    wait.withMessage("'All stores' vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblAllStores()));
    wait.withMessage("Quick Market vertical expect no to be displayed")
        .until(CustomConditions.elementIsNotDisplayed(verticalsScreen.getLblQuickMarket()));
    wait.withMessage("'Order Anything' vertical expect not to be displayed")
        .until(CustomConditions.elementIsNotDisplayed(verticalsScreen.getLblOrderAnything()));
  }
}
