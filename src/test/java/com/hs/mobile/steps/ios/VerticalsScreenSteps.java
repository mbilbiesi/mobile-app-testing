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

public class VerticalsScreenSteps extends BaseSteps {

  @NonNull
  private final VerticalsScreen verticalsScreen;

  public VerticalsScreenSteps(@NonNull TestSettings testSettings) {
    super(testSettings);
    verticalsScreen = new VerticalsScreen(testSettings);
  }

  @Step("Asseert that all verticals are displayed")
  public void assertAllVerticals() {
    SoftAssertions soft = new SoftAssertions();
    MobileElement lblAllStores = verticalsScreen.getLblAllStores();
    soft.assertThat(lblAllStores.isDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();

    MobileElement lblQuickMarket = verticalsScreen.getLblQuickMarket();
    soft.assertThat(lblQuickMarket.isDisplayed()).isTrue();

    MobileElement lblOrderAnything = verticalsScreen.getLblOrderAnything();
    soft.assertThat(lblOrderAnything.isDisplayed()).isTrue();

    soft.assertAll();
    System.out.println("Verticals are present");
  }

  @Step("click on arrow button")
  public void clickOnArrow() {
    MobileElement btnArrow = verticalsScreen.getBtnArrow();
    btnArrow.click();
  }

  @Step("Click on add new address from the verticals page")
  public void clickOnAdd() {
    MobileElement btnAddLocation = verticalsScreen.getBtnAdd();
    btnAddLocation.click();
  }

  @Step("Verify that two verticals are displayed and assert that order-anything verticals is not present")
  public void assertTwoVerticalsAreDisplayed() {

    SoftAssertions soft = new SoftAssertions();

    soft.assertThat(verticalsScreen.getLblAllStores().isDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

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
    soft.assertThat(allStores.isDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();

  }


}
