package com.hs.mobile.tests.android.searchdiscovery;

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
@Feature("Swimlane Section")
@Story("Select a store from swimlane ")
@Issue("HSAP-474")
public class SwimlaneStoreSelectionITCase extends BaseTestSteps {

  @BeforeClass
  @Step("User is on 'All stores' screen")
  public void testPrecondition() {
    // Given
    var cityToSearch = "Riyadh";
    landingScreenSteps.selectNewAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();
    assumeThat(verticalsScreenSteps.isOrderAnythingVerticalDisplayed())
        .as("'All stores' vertical is not displayed")
        .isTrue();
  }

  @Test(description = "Verify that the a store can be selected from swimlane section")
  public void navigateToAllStores_assertSwimlaneSection() {
    // When
    verticalsScreenSteps.clickOnAllStores();
    allStoresScreenSteps.selectStoreFromSwimlane();

    // Then
    restaurantMenuScreenSteps.verifyThatCloseButtonExist();
  }
}
