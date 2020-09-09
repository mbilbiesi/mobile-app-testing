package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.SelectLocationScreen;
import com.hs.mobile.steps.BaseSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

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

  @Step("Click on magnifying search icon")
  public void clickOnSearchIcon() {
    selectLocationScreen.getBtnSearch().click();
  }

  @Step("Type {0} in search bar")
  public void sendCityViaIosKeyboard(String cityName) {
    selectLocationScreen.getSearchBar().sendKeys(cityName);
  }

  @Step("Click on enter search using iOS keyboard")
  public void enterSearchUsingKeyboard() {
    selectLocationScreen.getKeyboardInputSearch().click();
  }

  @Step("Click on select button")
  public void clickOnSelectBtn() {
    selectLocationScreen.getBtnSelectAddress().click();
  }

  @Step("Click on done button")
  public void clickOnDoneBtn() {
    selectLocationScreen.getBtnDone().click();
  }

  @Step("Verify 'Area not covered' label is visible in select button")
  public void verifyNotCoveredArea() {
    String buttonText = selectLocationScreen.getBtnSelectAddress().getText();
    assertThat(buttonText)
        .as("select button has wrong label")
        .isEqualTo("Area not covered");
  }
}
