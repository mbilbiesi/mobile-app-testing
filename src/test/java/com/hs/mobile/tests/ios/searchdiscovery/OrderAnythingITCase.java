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
@Feature("OrderAnything")
@Story("OrderAnything functionality verification")
public class OrderAnythingITCase extends BaseTestSteps {

  @BeforeClass
  @Step("User is on 'All stores' screen")
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
    assumeThat(verticalsScreenSteps.isAllStoresVerticalDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();
  }

  @Issue("HSAP-521")
  @Test(
      description =
          "Navigate to 'Order Anything' from empty search result in 'All stores' vertical")
  public void orderFromNonExistingStore() {
    // Given
    var nonExistingStore = "xyz";

    // When
    verticalsScreenSteps.clickOnAllStores();
    allStoresScreenSteps.clickOnSearch();
    allStoresScreenSteps.typeSearchKeyword(nonExistingStore);
    allStoresScreenSteps.clickOnTryOrderAnything();

    // Then
    orderAnythingScreenSteps.verifyOrderAnythingVerticalIsAppeared();
  }
}
