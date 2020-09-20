package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.tests.base.BaseSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Smoke Tests")
@Feature("Restaurants List Tests")
@Story("Restaurant verification cases")
@Listeners(TestListener.class)
public class RestaurantsITs extends BaseSteps {

  // ToDo: Some test here have to be skipped based on whether campaigns are enabled
  // or not or whether the location has campaigns or not. We need to implement a way
  // skip test conditionally based on the information above. For now, I'll just manually skip the
  // tests

  private int restaurantCount = 0;
  private String keyword = null;
  // ToDO: Find a way to retrieve different test data for restaurants dynamically:
  private String recommendedRestaurant = "ماكدونالد";
  private String notReadyRecommendedRestaurant = "ليمونة";
  private String firstFilterTitle;

  private boolean hasFirstTestExecuted = false;

  @BeforeMethod
  public void beforeEachTest() {
    // Given
    //    homeScreenSteps.clickFindRestaurantsButton();
    if (!hasFirstTestExecuted) {
      homeScreenSteps.clickSelectLocationManually();
      locationScreenSteps.searchForRestaurants();
      locationScreenSteps.insertDefaultLocation();
      locationScreenSteps.selectItemArea(1);
      locationScreenSteps.submitAddress();
      locationScreenSteps.insertAddressDescription("desc");
      locationScreenSteps.submitAddress();
      hasFirstTestExecuted = true;
    }
    homeScreenSteps.clickViewRestaurantsButton();
  }

  @Issue("HSAP-185")
  @Test(description = "Verify all Restaurant List objects are displayed correctly")
  void navigateToRestaurantListScreen_screenElementAreDisplayed() {
    // When
    // Then
    restaurantsListSteps.verifyRestaurantsListLayout();
  }

  @Issue("HSAP-186")
  @Test(description = "Verify all restaurants that meet the search criteria are returned")
  public void searchForRestaurant_resultsMatchedSearchCriteria() {
    // When
    restaurantCount = restaurantsListSteps.getRestaurantsCount(false);
    keyword =
        restaurantsListSteps.searchForRestaurant(restaurantsData.getRestaurantName("sponsored"));

    // Then
    restaurantsListSteps.verifyReturnedRestaurants(keyword);
  }

  @Issue("HSAP-186")
  @Test(description = "Verify clearing search criteria will reset the list view")
  public void clickToResetSearchCriteria_restaurantListWillBeReset() {
    // When
    restaurantCount = restaurantsListSteps.getRestaurantsCount(false);
    keyword = restaurantsListSteps.searchForRestaurant("بيتزا هت");
    int afterSearchRestaurantCount = restaurantsListSteps.clearSearchCriteria();

    // Then
    restaurantsListSteps.verifyAllRestaurantsAreReturned(
        restaurantCount, afterSearchRestaurantCount);
  }

  @Issue("HSAP-188")
  @Test(
      description = "Verify recommended badge is displaying next to the recommended restaurants",
      enabled = false) // Requires correct up-to-date data of recommended restaurants
  public void navigateToRestaurantsListScreen_checkRecommendedRestaurantsBadge() {
    // When
    restaurantsListSteps.searchForRestaurant(recommendedRestaurant);

    // Then
    restaurantsListSteps.checkRecommendedBadge(true);
  }

  @Issue("HSAP-189")
  @Test(
      description =
          "verify recommended badge is only displayed for restaurant with ready status only",
      enabled = false)
  // Test is disabled because it requires correct up-to-date test data of recommended restaurants
  public void navigateToRestaurantList_recommendedBadgeDisplayOnlyForReadyRestaurant() {
    // When
    restaurantsListSteps.searchForRestaurant(notReadyRecommendedRestaurant);

    // Then
    restaurantsListSteps.checkRecommendedBadge(false);
    // todo: make sure that this step is going to be executed otherwise next tests will fail
    //    restaurantsListSteps.clearSearchCriteria();
  }

  @Issue("HSAP-190")
  @Test(
      description =
          "Verify restaurants are sorted according to the distance from the location provided")
  public void navigateToRestaurantsListScreen_verifyRestaurantsSortedByDistance() {
    boolean restaurantsWithBadges;
    // When
    restaurantsWithBadges = restaurantsListSteps.scrollDownRestaurantsList();

    // Then
    restaurantsListSteps.checkIfRestaurantsSortedByDistance(restaurantsWithBadges);
  }

  @Issue("HSAP-191")
  @Test(
      description = "Verify promoted restaurants are displayed at the top of restaurants list",
      enabled = false)
  public void navigateToRestaurantsListScreen_verifyPromotedRestaurantsDisplayOnTop() {
    // When
    // Then
    restaurantsListSteps.verifyPromotedRestaurantsDisplayOnTop();
  }

  @Issue("HSAP-192")
  @Test(description = "Check if the filters section is displayed below the banners section")
  public void navigateToRestaurantsListScreen_verifyKitchenTypeFiltersAreDisplayed() {
    // When
    // Then
    restaurantsListSteps.verifyRestaurantFiltersAreDisplayed();
  }

  @Issue("HSAP-193")
  @Test(
      description = "Check if the user is eligible to see the 'All' filter among the filters list")
  public void navigateToRestaurantsListScreen_verifyTheAllFilterIsDisplayedAndSelected() {
    // When
    // Then
    restaurantsListSteps.verifyAllFiterIsDisplayed();
    restaurantsListSteps.verifyAllFiterIsSelectedAndColorIsYellow();
  }

  @Issue("HSAP-194")
  @Test(description = "Check if the user is able to swipe left and right on the filters list")
  public void navigateToRestaurantsListScreen_verifyCustomerCanSwipeOnFilters() {
    // When
    firstFilterTitle = restaurantsListSteps.swipeFiltersList();

    // Then
    restaurantsListSteps.verifyFiltersSwipedSuccessfully(firstFilterTitle);
  }

  @Issue("HSAP-195")
  @Test(description = "Check that the top banner image's ratio is 2:1", enabled = true)
  public void navigateToRestaurantsListScreen_verifyTopBannerImgRatioIs2_1() {
    // When
    // Then
    restaurantsListSteps.verifyTopBannerImageRatio();
  }

  @Issue("HSAP-197")
  @Test(description = "Check if the top banner shows restaurant offers")
  public void navigateToRestaurantsListScreen_verifyTopBannerShowsRestaurantOffers() {
    // When
    // Then
    restaurantsListSteps.verifyTopBannerShowsOnlyOffers();
  }

  @Issue("HSAP-198")
  @Test(description = "Check if the the campaigns are displayed in a separate carousel ")
  public void navigateToRestaurantsListScreen_verifyCampaignsDisplayedInSeparateCarousel() {
    // When
    // Then
    restaurantsListSteps.verifyCampaignsDisplayInSeparateCarousel(true);
  }

  @Issue("HSAP-199")
  @Test(description = "Check if the Max number of campaigns shown in campaign carousel is 8")
  public void navigateToRestaurantsListScreen_verifyMaxNumberOfCampaignsDisplayed() {
    // When
    // Then
    restaurantsListSteps.verifyMaxCampaginsNumberInCarousel();
  }

  @Issue("HSAP-200")
  @Test(description = "Verify that restaurants will be displayed based on the selected campaign")
  public void clickCampaign_verifyRestaurantsWithCampaignDisplayed() {
    // When
    restaurantsListSteps.clickCampaign(true);

    // Then
    restaurantsListSteps.verifyCampaignRestaurants();
  }

  @Issue("HSAP-201")
  @Test(description = "Check that no campaigns are displayed to customer " + "if they are disabled")
  public void navigateToRestaurantsListScreen_verifyNoCampaignsAreShowedToCustomer() {
    // When
    // Then
    restaurantsListSteps.verifyCampaignsDisplayInSeparateCarousel(true);
  }

  @Issue("HSAP-202")
  @Test(description = "Check if the the top campaign width set to ratio 2:1")
  public void clickCampaign_verifyTopCampaignWidthRatioIs2_1() {
    // When
    restaurantsListSteps.clickCampaign(true);

    // Then
    restaurantsListSteps.verifyCampaignImageRatio(true);
  }

  @AfterMethod
  public void afterEachTest() {
    restaurantsListSteps.navigateBackToRestaurantsList();
    driver.navigate().back();
  }
}
