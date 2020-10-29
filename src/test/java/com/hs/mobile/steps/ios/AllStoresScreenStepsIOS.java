package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.exception.ExceptionSupplier;
import com.hs.mobile.screens.ios.AllStoresScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.RestaurantScreenSteps;
import com.hs.mobile.util.CustomConditions;
import io.qameta.allure.Step;
import lombok.NonNull;

public class AllStoresScreenStepsIOS extends BaseSteps<AllStoresScreenStepsIOS>
    implements RestaurantScreenSteps {

  @NonNull private final AllStoresScreen allStoresScreen;

  public AllStoresScreenStepsIOS(@NonNull TestSettings testSettings) {
    super(testSettings);
    allStoresScreen = new AllStoresScreen(testSettings);
  }

  @Step("Select `{0}` restaurant")
  public void selectRestaurantByName(String name) {
    allStoresScreen.getRestaurantList().stream()
        .filter(mobileElement -> mobileElement.getText().contains(name))
        .findFirst()
        .orElseThrow(ExceptionSupplier.testException("Could not find desired restaurant"))
        .click();
  }

  @Override
  @Step("verify location is appeared in screen header")
  public void verifyLocationIsAppearedScreenHeader() {
    assertThat(allStoresScreen.getHeaderLocation().getText())
        .as("Wrong value in header screen")
        .isNotEmpty();
  }

  @Override
  @Step("Select fast food filter")
  public void clickOnFirstFilter() {
    wait.withMessage("could not select a filter")
        .until(
            CustomConditions.elementIsClicked(
                allStoresScreen.getFastFoodFilter(), allStoresScreen.getFastFoodSection()));
  }

  @Override
  @Step("Verify filter is selected")
  public void assertFilterSelection() {
    assertThat(allStoresScreen.getFastFoodSection().isDisplayed())
        .as("select filter is not working")
        .isTrue();
  }

  @Step("deselect fast food filter")
  public void deselectFilter() {
    allStoresScreen.getFastFoodFilter().click();
  }

  @Step("verify filter is deselected")
  public void assertFilterDeselected() {
    assertThat(allStoresScreen.getAllFilterSection().isDisplayed())
        .as("deselect filter is not working")
        .isTrue();
  }
}
