package com.hs.mobile.steps.android;

import static com.hs.mobile.util.CustomConditions.elementIsClicked;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.SelectLocationScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectLocationScreenStepsAndroid extends BaseSteps<SelectLocationScreenStepsAndroid>
    implements SelectLocationScreenSteps {

  @NonNull private final SelectLocationScreen selectLocationScreen;
  @NonNull private final AppiumDriver<MobileElement> driver;

  public SelectLocationScreenStepsAndroid(@NonNull TestSettings testSettings) {
    super(testSettings);
    selectLocationScreen = new SelectLocationScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Override
  public void selectCity(String cityLabel) {}

  @Step("Click on magnifying search icon")
  public void clickOnSearchIcon() {
    var elementToClickOn = selectLocationScreen.searchBar();
    var expectedElementAfterClick = selectLocationScreen.searchTextField();
    wait.until(elementIsClicked(elementToClickOn, expectedElementAfterClick));
  }

  @Step("Type {0} in search bar")
  public void insertDesiredCity(String cityName) {
    selectLocationScreen.searchTextField().sendKeys(cityName);
  }

  @Step("Click on enter first search result")
  public void enterSearch() {
    tap(selectLocationScreen.searchResult());
  }

  @Step("Click on select address button")
  public void clickOnSelectAddressButton() {
    tap(selectLocationScreen.btnSelect());
  }

  @Step("Click on done button")
  public void clickOnDoneButton() {
    tap(selectLocationScreen.btnSelect());
  }

  @Step("Verify 'Area not covered' label is visible in select button")
  public void verifyNotCoveredArea() {
    By selectButtonLocatorId = By.id("com.hungerstation.android.web.debug:id/BtnAddAddress");
    wait.withMessage("Expected not covered area based on the provided area")
        .until(ExpectedConditions.textToBe(selectButtonLocatorId, "Area not covered"));
  }
}
