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
@Feature("Searching")
@Story("Search for a selected store from 'All-Stores' screen ")
@Issue("HSAP-477")
public class SearchForStoreITCase extends BaseTestSteps {

  @BeforeClass
  @Step("User is on Restaurant screen")
  public void testPrecondition() {
    // Given
    var cityToSearch = "Riyadh";
    landingScreenSteps.handleLocationPopup();
    landingScreenSteps.selectNewAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();
    assumeThat(verticalsScreenSteps.isRestaurantVerticalDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();
  }

  @Test(description = "Search for a selected store and verify it is displayed")
  public void navigateToAllStoresVertical_searchForStore() {
    // Given
    var nonExistingStore = "Al Reef Al Hindi";

    // When
    verticalsScreenSteps.clickOnRestaurantVertical();
    allStoresScreenSteps.clickOnSearch();
    allStoresScreenSteps.typeSearchKeyword(nonExistingStore);

    // Then
    allStoresScreenSteps.verifyStoreSelectedIsAppeared();
  }
}
