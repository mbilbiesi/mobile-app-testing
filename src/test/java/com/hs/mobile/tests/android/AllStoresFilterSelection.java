package com.hs.mobile.tests.android;

import static org.assertj.core.api.Assumptions.assumeThat;

import com.hs.mobile.tests.BaseSteps;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllStoresFilterSelection extends BaseSteps {

  @BeforeClass
  @Step("User is on 'All stores' screen")
  public void testPrecondition() {
    // Given
    var cityToSearch = "Riyadh";
    landingScreenSteps.handlePromotionPopup();
    landingScreenSteps.selectNewAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();
    assumeThat(verticalsScreenSteps.isAllStoresVerticalDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();
  }

  @Issue("HSAP-469")
  @Test(description = "Verify filter that user can select filter")
  public void userSelectFilter_filterIsSelected() {
    // When
    verticalsScreenSteps.clickOnAllStores();
    restaurantScreenSteps.clickOnFirstFilter();

    // Then
    restaurantScreenSteps.assertFilterSelection();
  }

  @Issue("HSAP-469")
  @Test(
      description = "Verify filter that user can select filter",
      dependsOnMethods = "userSelectFilter_filterIsSelected")
  public void userDeselectFilter_filterIsDeselected() {
    // When
    restaurantScreenSteps.deselectFilter();

    // Then
    restaurantScreenSteps.assertFilterDeselected();
  }
}
