package com.hs.mobile.steps.ios;

import static com.hs.mobile.util.CustomConditions.elementIsClicked;
import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.SelectLocationScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectLocationScreenStepsIOS extends BaseSteps<SelectLocationScreenStepsIOS>
    implements SelectLocationScreenSteps {

  @NonNull private final SelectLocationScreen selectLocationScreen;
  @NonNull private final AppiumDriver<MobileElement> driver;

  public SelectLocationScreenStepsIOS(@NonNull TestSettings testSettings) {
    super(testSettings);
    selectLocationScreen = new SelectLocationScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Override
  @Step("Click on city : {0}")
  public void selectCity(String cityLabel) {
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.id(cityLabel)).click();
  }

  @Override
  @Step("Click on magnifying search icon")
  public void clickOnSearchIcon() {
    MobileElement btnSearch = selectLocationScreen.getBtnSearch();
    assertThat(btnSearch.isDisplayed()).as("search icon is not displayed").isTrue();
    btnSearch.click();
  }

  @Override
  @Step("Type {0} in search bar")
  public void insertDesiredCity(String cityName) {
    selectLocationScreen.getSearchBar().sendKeys(cityName);
  }

  @Override
  @Step("Click on enter search using iOS keyboard")
  public void enterSearch() {
    selectLocationScreen.getKeyboardInputSearch().click();
  }

  @Override
  @Step("Click on select address button")
  public void clickOnSelectAddressButton() {
    WebElement selectButton = selectLocationScreen.getBtnSelectAddress();
    wait.until(ExpectedConditions.elementToBeClickable(selectButton));
    selectButton.click();
  }

  @Override
  @Step("Click on done button")
  public void clickOnDoneButton() {
    wait.withMessage("could not click on Done")
        .until(elementIsClicked(selectLocationScreen.getBtnDone()));
  }

  @Override
  @Step("Verify 'Area not covered' label is visible in select button")
  public void verifyNotCoveredArea() {
    wait.withMessage("select button has wrong label")
        .until(
            ExpectedConditions.textToBePresentInElement(
                selectLocationScreen.getBtnSelectAddress(), "Area not covered"));
  }
}
