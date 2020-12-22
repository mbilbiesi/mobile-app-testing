package com.hs.mobile.tests.android;

import static org.assertj.core.api.Assumptions.assumeThat;

import com.hs.mobile.tests.BaseTestSteps;
import com.hs.mobile.util.annotation.SearchAndDiscovery;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SearchAndDiscovery
@Feature("Searching")
@Story("Order anything pick up store ")
@Issues({@Issue("HSAP-487"), @Issue("HSAP-481"), @Issue("HSAP-489")})
public class OrderAnythingPickUpITCase extends BaseTestSteps {

  @BeforeClass
  @Step("User is on 'All stores' screen")
  public void testPrecondition() {
    // Given
    var cityToSearch = "Hayat Mall";
    landingScreenSteps.handlePromotionPopup();
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

  @Test(description = "Verify that the user is directed to 'order-anything' vertical")
  public void navigateToOrderAnything() {
    // Given
    verticalsScreenSteps.clickOrderAnything();

    // When
    var pickUpLocation = "Riyadh Park";
    orderAnythingScreenSteps.clickFindStore();
    selectLocationScreenSteps.clickOnSearchBarOA();
    selectLocationScreenSteps.enterSearchAddressOA(pickUpLocation);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.clickOnDoneButton();

    // Then
    orderAnythingScreenSteps.verifyDeliveryFeeIsPresent();
    orderAnythingScreenSteps.clickOnContinue();
  }
}
