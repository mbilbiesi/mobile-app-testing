package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.SelectLocationScreen;
import com.hs.mobile.steps.BaseSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;
import org.openqa.selenium.By;

public class SelectLocationScreenSteps extends BaseSteps {

  @NonNull private final SelectLocationScreen selectLocationScreen;
  @NonNull private final AppiumDriver<MobileElement> driver;

  public SelectLocationScreenSteps(@NonNull TestSettings testSettings) {
    super(testSettings);
    selectLocationScreen = new SelectLocationScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Step("Click on city : {0}")
  public void selectCity(String cityLabel) {
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.id(cityLabel)).click();
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

  @Step("Click on select address button")
  public void clickOnSelectAddressButton() {
    selectLocationScreen.getBtnSelectAddress().click();
  }

  @Step("Click on done button")
  public void clickOnDoneButton() {
    selectLocationScreen.getBtnDone().click();
  }

  @Step("Verify 'Area not covered' label is visible in select button")
  public void verifyNotCoveredArea() {
    String buttonText = selectLocationScreen.getBtnSelectAddress().getText();
    assertThat(buttonText).as("select button has wrong label").isEqualTo("Area not covered");
  }
}
