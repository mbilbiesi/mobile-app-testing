package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.VerticalsScreen;
import com.hs.mobile.steps.BaseSteps;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VerticalsScreenSteps extends BaseSteps {

  @NonNull
  private final VerticalsScreen verticalsScreen;

  public VerticalsScreenSteps(@NonNull TestSettings testSettings) {
    super(testSettings);
    verticalsScreen = new VerticalsScreen(testSettings);
  }

  @Step("verify all verticals are displayed")
  public void assertAllVerticals() {
    SoftAssertions soft = new SoftAssertions();
    MobileElement lblAllStores = verticalsScreen.getLblAllStores();
    soft.assertThat(lblAllStores.isDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();
    soft.assertThat(verticalsScreen.getLblQuickMarket().isDisplayed()).isTrue();
    soft.assertThat(verticalsScreen.getLblOrderAnything().isDisplayed()).isTrue();
    soft.assertAll();
  }

  @Step("click on arrow button")
  public void clickOnArrow() {
    verticalsScreen.getBtnArrow().click();
  }

  @Step("Click on add new address from the verticals page")
  public void clickOnAdd() {
    verticalsScreen.getBtnAdd().click();
  }

  @Step("Verify two verticals are displayed and order-anything verticals is not present")
  public void assertTwoVerticalsAreDisplayed() {
    wait.until(ExpectedConditions.visibilityOf(verticalsScreen.getLblAllStores()));

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
