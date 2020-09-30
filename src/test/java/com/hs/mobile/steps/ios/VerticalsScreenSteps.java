package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.VerticalsScreen;
import com.hs.mobile.steps.BaseSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import java.time.Duration;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
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
    touchAction
        .tap(
            TapOptions.tapOptions()
                .withElement(ElementOption.element(verticalsScreen.getLblNewLocation())))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
        .perform();
  }

  @Step("verify all verticals are displayed")
  public void assertAllVerticals() {
    expectedNumberOfVerticals(3);

    SoftAssertions soft = new SoftAssertions();
    soft.assertThat(verticalsScreen.getLblAllStores().isEnabled())
        .as("'All stores' vertical is not displayed")
        .isTrue();
    soft.assertThat(verticalsScreen.getLblQuickMarket().isEnabled())
        .as("'Quick Market' vertical is not displayed")
        .isTrue();
    soft.assertThat(verticalsScreen.getLblOrderAnything().isEnabled())
        .as("'Order Anything' vertical is not displayed")
        .isTrue();
    soft.assertAll();
  }

  @Step("Verify two verticals are displayed and order-anything verticals is not present")
  public void assertTwoVerticalsAreDisplayed() {
    expectedNumberOfVerticals(2);

    SoftAssertions soft = new SoftAssertions();
    soft.assertThat(verticalsScreen.getLblAllStores().isEnabled())
        .as("'All stores' vertical is not displayed")
        .isTrue();
    soft.assertThat(verticalsScreen.getLblQuickMarket().isEnabled())
        .as("Quick Market vertical is not displayed")
        .isTrue();
    soft.assertAll();
  }

  @Step("Verify all-stores vertical is displayed")
  public void verifyAllStoresVertical() {
    expectedNumberOfVerticals(1);

    assertThat(verticalsScreen.getLblAllStores().isEnabled())
        .as("'All stores' vertical is not displayed")
        .isTrue();
  }

  private void expectedNumberOfVerticals(@NonNull int expectedNumberOfVerticals) {
    var failureMessage =
        String.format(
            "Expected only %s vertical(s) to be displayed for the provided address",
            expectedNumberOfVerticals);
    wait.withMessage(failureMessage)
        .until(
            ExpectedConditions.numberOfElementsToBe(
                By.name("title_label"), expectedNumberOfVerticals));
  }
}
