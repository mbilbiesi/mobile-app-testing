package com.hs.mobile.steps.android;

import static com.hs.mobile.util.CustomConditions.elementIsClicked;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.SelectLocationScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectLocationScreenStepsAndroid extends BaseSteps<SelectLocationScreenStepsAndroid>
    implements SelectLocationScreenSteps {

  @NonNull private final SelectLocationScreen selectLocationScreen;

  public SelectLocationScreenStepsAndroid(@NonNull TestSettings testSettings) {
    super(testSettings);
    selectLocationScreen = new SelectLocationScreen(testSettings);
  }

  @Override
  public void selectCity(String cityLabel) {}

  @Step("Click on magnifying search icon")
  public void clickOnSearchIcon() {
    var elementToClickOn = selectLocationScreen.searchBar();
    var expectedElementAfterClick = selectLocationScreen.searchTextField();
    try {
      wait.until(elementIsClicked(elementToClickOn, expectedElementAfterClick));
    } catch (org.openqa.selenium.TimeoutException e) {

    }
  }

  @Step("Type {0} in search bar")
  public void insertDesiredCity(String cityName) {
    selectLocationScreen.searchTextField().click();
    selectLocationScreen.searchTextField().sendKeys(cityName);
  }

  @Step("Click on enter first search result")
  public void enterSearch() {
    tap(selectLocationScreen.searchResult());
  }

  @Step("Click on select address button")
  public void clickOnSelectAddressButton() {
    selectLocationScreen.btnSelect().click();
  }

  @Override
  @Step("Switch 'Save for later' on")
  public void clickOnSaveForLater() {
    selectLocationScreen.btnSwitchSaveForLater().click();
  }

  @Override
  public void clickOnHomeIcon() {
    selectLocationScreen.btnHomeIcon().click();
  }

  @Override
  public void moveMapPinToNewLocationPoint() {}

  @Step("Click on done button")
  public void clickOnDoneButton() {
    selectLocationScreen.btnSelect().click();
  }

  @Step("Verify 'Area not covered' label is visible in select button")
  public void verifyNotCoveredArea() {
    By selectButtonLocatorId = By.id("com.hungerstation.android.web.debug:id/BtnAddAddress");
    wait.withMessage("Expected not covered area based on the provided area")
        .until(ExpectedConditions.textToBe(selectButtonLocatorId, "Area not covered"));
  }

  @Override
  @Step("Click on order-anything select location")
  public void clickOnSearchBarOA() {
    selectLocationScreen.btnSearchLocationOA().click();
  }

  @Override
  @Step("Enter desired address")
  public void enterSearchAddressOA(String address) {
    selectLocationScreen.enterPickUpAddressOA().sendKeys(address);
  }

  @Override
  public void clickOnSelectedAddressOA() {}

  @Override
  public void clickOnSelectOA() {}
}
