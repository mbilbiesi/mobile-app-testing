package com.hs.mobile.tests.ios.searchdiscovery;

import static org.assertj.core.api.Assumptions.assumeThat;

import com.hs.mobile.tests.BaseTestSteps;
import com.hs.mobile.util.annotation.SearchAndDiscovery;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SearchAndDiscovery
@Feature("All Stores vertical")
@Story("Filters verification")
public class AllStoresFilterSelectionITCase extends BaseTestSteps {

  @BeforeClass
  @Step("User is on Restaurant screen")
  public void testPrecondition() {
    // Given
    var cityToSearch = "Riyadh";
    landingScreenSteps.handleLocationPopup();
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
    allStoresScreenSteps.clickOnFirstFilter();

    // Then
    allStoresScreenSteps.assertFilterSelection();
  }

  @Issue("HSAP-469")
  @Test(
      description = "Verify filter that user can select filter",
      dependsOnMethods = "userSelectFilter_filterIsSelected")
  public void userDeselectFilter_filterIsDeselected() {
    // When
    allStoresScreenSteps.deselectFilter();

    // Then
    allStoresScreenSteps.assertFilterDeselected();
  }
}
