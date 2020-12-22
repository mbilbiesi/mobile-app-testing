package com.hs.mobile.tests.ios;

import com.hs.mobile.tests.BaseTestSteps;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectExistingAddressITCase extends BaseTestSteps {

  @BeforeClass
  @Step("User is logged-in")
  public void testPrecondition() {
    // Given
    landingScreenSteps.handleLocationPopup();
    landingScreenSteps.handlePromotionPopup();
    landingScreenSteps.clickOnOrders();
    moreScreenSteps.clickOnLogin();
    loginScreenSteps.enterPhoneNumber("501020010");
    loginScreenSteps.clickOnNext();
    loginScreenSteps.enterOtpCode("000000");
    moreScreenSteps.clickOnHome();
  }

  @Test
  public void clickOnSavedAddress() {
    // When
    var cityToSearch = "Riyadh";
    landingScreenSteps.selectNewAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnSaveForLater();
    selectLocationScreenSteps.clickOnHomeIcon();
    selectLocationScreenSteps.clickOnDoneButton();

    // Then
    landingScreenSteps.verifySearchFieldValueIsEqualTo("Home");
  }
}
