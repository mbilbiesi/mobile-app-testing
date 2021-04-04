package com.hs.mobile.tests.android.searchdiscovery;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.tests.BaseTestSteps;
import com.hs.mobile.util.annotation.SearchAndDiscovery;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SearchAndDiscovery
@Feature("Address")
@Story("Update and Save address")
public class AddressITCase extends BaseTestSteps {

  @BeforeClass
  @Step("User is logged-in")
  public void testPrecondition() {
    // Given
    landingScreenSteps.handlePromotionPopup();
    landingScreenSteps.clickOnMore();
    moreScreenSteps.clickOnLogin();
    loginScreenSteps.enterPhoneNumber("501020010");
    loginScreenSteps.clickOnNext();
    loginScreenSteps.enterOtpCode("000000");
  }

  @Issue("HSAP-483")
  @Test(description = "Save new address")
  public void userSaveAddress_addressIsSavedForUser() {
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

  @Issue("HSAP-")
  @Test(
      description = "Update saved address",
      dependsOnMethods = "userSaveAddress_addressIsSavedForUser")
  public void userUpdateAddress_addressIsUpdated() {
    // Given
    var cityToSearch = "SULEIMANIA";
    landingScreenSteps.selectNewAddress();
    var beforeUpdateAddress = landingScreenSteps.getAddressLabel();

    // When
    landingScreenSteps.clickOnMoreActions();
    landingScreenSteps.clickOnEditAddress();
    selectLocationScreenSteps.clickOnSearchIcon();
    selectLocationScreenSteps.insertDesiredCity(cityToSearch);
    selectLocationScreenSteps.enterSearch();
    selectLocationScreenSteps.selectCity(cityToSearch);
    selectLocationScreenSteps.clickOnSelectAddressButton();
    selectLocationScreenSteps.clickOnDoneButton();
    landingScreenSteps.selectNewAddress();
    var afterUpdateAddress = landingScreenSteps.getAddressLabel();

    // Then
    assertThat(afterUpdateAddress)
        .as("Address did not change after update location")
        .isNotEqualTo(beforeUpdateAddress);
  }

  @Test(
      description = "Delete saved address",
      dependsOnMethods = "userUpdateAddress_addressIsUpdated",
      alwaysRun = true)
  public void userDeleteAddress_addressIsDeleted() {
    // When
    landingScreenSteps.clickOnMoreActions();
    landingScreenSteps.clickOnDeleteAddress();

    // Then
    landingScreenSteps.verifySearchFieldValueIsEqualTo("...");
  }
}
