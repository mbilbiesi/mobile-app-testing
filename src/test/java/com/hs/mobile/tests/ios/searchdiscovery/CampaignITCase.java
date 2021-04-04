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
@Feature("Campaign")
@Story("Verify campaign banners are exist and clickable")
@Issue("HSAP-472")
public class CampaignITCase extends BaseTestSteps {

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

  @Test(description = "verify campaign banners are displayed in All Stores vertical")
  public void navigateToAllStoresVertical_campaignBannersAreDisplayed() {
    // When
    verticalsScreenSteps.clickOnAllStores();

    // Then
    allStoresScreenSteps.verifyCampaignBannersAreDisplayed();
  }

  @Test(
      description = "verify navigating to banner screen",
      dependsOnMethods = "navigateToAllStoresVertical_campaignBannersAreDisplayed")
  public void clickOnBanner_bannerScreenIsDisplayed() {
    // When
    allStoresScreenSteps.clickOnCampaign();

    // Then
    campaignScreenSteps.verifyCampaignScreenIsDisplayed();
  }

  @Test(
      description = "verify closing banner screen will navigate back to `All Stores` vertical",
      dependsOnMethods = "clickOnBanner_bannerScreenIsDisplayed")
  public void closeBannerScreen_allStoresDisplayed() {
    // When
    campaignScreenSteps.closeCampaignScreen();

    // Then
    allStoresScreenSteps.verifyCampaignBannersAreDisplayed();
  }
}
