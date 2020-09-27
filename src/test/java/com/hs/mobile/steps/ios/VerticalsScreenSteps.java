package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.VerticalsScreen;
import com.hs.mobile.steps.BaseSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import java.time.Duration;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VerticalsScreenSteps extends BaseSteps {

  @NonNull private final VerticalsScreen verticalsScreen;
  AppiumDriver<?> driver;

  public VerticalsScreenSteps(@NonNull TestSettings testSettings) {
    super(testSettings);
    verticalsScreen = new VerticalsScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Step("verify all verticals are displayed")
  public void assertAllVerticals() {
    wait.until(ExpectedConditions.numberOfElementsToBe(By.name("title_label"), 3));
    SoftAssertions soft = new SoftAssertions();
    soft.assertThat(verticalsScreen.getLblAllStores().isDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();
    soft.assertThat(verticalsScreen.getLblQuickMarket().isDisplayed())
        .as("'Quick Market' vertical is not displayed")
        .isTrue();
    soft.assertThat(verticalsScreen.getLblOrderAnything().isDisplayed())
        .as("'Order Anything' vertical is not displayed")
        .isTrue();
    soft.assertAll();
  }

  @Step("click on the address from the address bar")
  public void clickOnAddress() {
    verticalsScreen.getBtnChoose().click();
  }

  @Step("Click on add new address from the verticals page")
  public void clickOnAddNewLocation() {
    touchAction.tap(TapOptions.tapOptions()
        .withElement(ElementOption.element(verticalsScreen.getLblNewLocation())))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
        .perform();
  }

  @Step("Verify two verticals are displayed and order-anything verticals is not present")
  public void assertTwoVerticalsAreDisplayed() {
    wait.until(ExpectedConditions.visibilityOf(verticalsScreen.getLblAllStores()));
    wait.until(ExpectedConditions.visibilityOf(verticalsScreen.getLblQuickMarket()));

    SoftAssertions soft = new SoftAssertions();
    soft.assertThat(verticalsScreen.getLblAllStores().isDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();
    soft.assertThat(verticalsScreen.getLblQuickMarket().isDisplayed())
        .as("Quick Market vertical is not displayed")
        .isTrue();
    assertThatExceptionOfType(NoSuchElementException.class)
        .as("OrderAnything should not be displayed")
        .isThrownBy(() -> verticalsScreen.getLblOrderAnything().isDisplayed());
    soft.assertAll();
  }

  @Step("Verify all-stores vertical is displayed")
  public void verifyAllStoresVertical() {
    SoftAssertions soft = new SoftAssertions();
    MobileElement allStores = verticalsScreen.getLblAllStores();
    soft.assertThat(allStores.isDisplayed()).as("'All stores' vertical is not displayed").isTrue();
  }
}
