package com.hs.mobile.steps.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.VerticalsScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;
import com.hs.mobile.util.CustomConditions;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VerticalsScreenStepsIOS extends BaseSteps<VerticalsScreenStepsIOS>
    implements VerticalsScreenSteps {

  @NonNull private final VerticalsScreen verticalsScreen;
  AppiumDriver<?> driver;

  public VerticalsScreenStepsIOS(@NonNull TestSettings testSettings) {
    super(testSettings);
    verticalsScreen = new VerticalsScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Override
  @Step("click on the address from the address bar")
  public void clickOnAddress() {
    verticalsScreen.getBtnChoose().click();
  }

  @Override
  @Step("Click on add new address from the verticals page")
  public void clickOnAddNewLocation() {
    wait.withMessage("Could not click on 'Add new location'")
        .until(CustomConditions.elementIsClicked(verticalsScreen.getLblNewLocation()));
  }

  @Override
  @Step("verify 'All Stores' vertical is displayed")
  public boolean isAllStoresVerticalDisplayed() {
    return verticalsScreen.getLblAllStores().isDisplayed();
  }

  @Override
  @Step("verify all verticals are displayed")
  public void assertAllVerticals() {
    wait.withMessage("'All stores' vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblAllStores()));
    wait.withMessage("Quick Market vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblQuickMarket()));
    wait.withMessage("'Order Anything' vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblOrderAnything()));
  }

  @Override
  @Step("Verify two verticals are displayed and order-anything verticals is not present")
  public void assertTwoVerticalsAreDisplayed() {
    wait.withMessage("'All stores' vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblAllStores()));
    wait.withMessage("Quick Market vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblQuickMarket()));
    wait.withMessage("'Order Anything' vertical expect not to be displayed")
        .until(CustomConditions.elementIsNotDisplayed(verticalsScreen.getLblOrderAnything()));
  }

  @Override
  @Step("Verify all-stores vertical is displayed")
  public void verifyAllStoresVertical() {
    wait.withMessage("'All stores' vertical is not displayed")
        .until(ExpectedConditions.visibilityOf(verticalsScreen.getLblAllStores()));
    wait.withMessage("Quick Market vertical expect no to be displayed")
        .until(CustomConditions.elementIsNotDisplayed(verticalsScreen.getLblQuickMarket()));
    wait.withMessage("'Order Anything' vertical expect not to be displayed")
        .until(CustomConditions.elementIsNotDisplayed(verticalsScreen.getLblOrderAnything()));
  }

  @Override
  @Step("click on all-stores vertical")
  public void clickOnAllRestaurants() {
    verticalsScreen.getLblAllStores().click();
  }
}
