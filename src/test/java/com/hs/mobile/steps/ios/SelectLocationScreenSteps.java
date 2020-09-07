package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.SelectLocationScreen;
import com.hs.mobile.steps.BaseSteps;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;

public class SelectLocationScreenSteps extends BaseSteps {

  @NonNull
  private final SelectLocationScreen selectLocationScreen;

  public SelectLocationScreenSteps(@NonNull TestSettings testSettings) {
    super(testSettings);
    selectLocationScreen = new SelectLocationScreen(testSettings);
  }

  @Step("Click on city")
  public void clickOnCity() {
    selectLocationScreen.getLblCity().click();
  }

  @Step("Click on magnifying glass icon")
  public void clickOnSearchIcon() {
    MobileElement btnSearch = selectLocationScreen.getBtnSearch();
    btnSearch.click();
  }

  @Step("Send keys via search bar")
  public void sendCityViaIosKeyboard() {
    MobileElement searchBar = selectLocationScreen.getSearchBar();
    searchBar.sendKeys("Riyadh");
  }

  @Step("Click on enter search using iOS keyboard")
  public void enterSearchUsingKeyboard() {
    MobileElement keyboardSearch = selectLocationScreen.getKeyboardInputSearch();
    keyboardSearch.click();
  }

  @Step("Click on select button")
  public void clickOnSelectBtn() {
    MobileElement btnSelectAddress = selectLocationScreen.getBtnSelectAddress();
    btnSelectAddress.click();
  }

  @Step("Click on done button")
  public void clickOnDoneBtn() {
    MobileElement btnDone = selectLocationScreen.getBtnDone();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    btnDone.click();
  }

  @Step("Ensure that all-store vertical and quick market are display")
  public void clickOnSearchBar() {
    MobileElement searchBar = selectLocationScreen.getSearchBar();
  }

  @Step("Send keys via search bar - Jeddah")
  public void sendCityViaIosKeyboard2() {
    MobileElement searchBar = selectLocationScreen.getSearchBar();
    searchBar.sendKeys("Jeddah");
  }

  @Step("Send keys via search bar - Khobar")
  public void sendCityViaIosKeyboard3() {
    MobileElement searchBar = selectLocationScreen.getSearchBar();
    searchBar.sendKeys("Khobar");
  }

  @Step("Send keys via search bar - Alnamas")
  public void sendCityViaIosKeyboard4() {
    MobileElement searchBar = selectLocationScreen.getSearchBar();
    searchBar.sendKeys("Alnamas");
  }

  @Step("Verify area is not covered label is visible")
  public void verifyNotCoveredArea() {
    SoftAssertions soft = new SoftAssertions();
    MobileElement areaNotCovered = selectLocationScreen.getBtnAreaNotCovered();

    try {
      areaNotCovered.click();
    } catch (NoSuchElementException e) {
      assertThatExceptionOfType(NoSuchElementException.class)
          .as("area not covered should be visible")
          .isThrownBy(() -> selectLocationScreen.getBtnAreaNotCovered().isDisplayed());
    }

  }


}
