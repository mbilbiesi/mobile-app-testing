package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Smoke Tests")
@Feature("Restaurants List Tests")
@Story("Restaurant verification cases")
@Listeners(TestListener.class)
public class RestaurantsListTests extends BaseTest {

  int restaurantCount = 0;
  int afterSearchRestaurantCount = 0;
  String keyword = null;
  // ToDO: Find a way to retrieve different test data for restaurants dynamically:
  String recommendedRestaurant = "ماكدونالد";
  String notReadyRecommendedRestaurant = "ليمونة";
  String firstFilterTitle;

  @BeforeMethod
  public void beforeEachTest() {
    // Given
    homeScreenSteps.clickFindRestaurantsButton();
    locationsScreen.searchForRestaurants();
    locationsScreen.insertLocation("riyadh");
    locationsScreen.selectItemArea(3);
    locationsScreen.submitAddress();
    locationsScreen.insertAddressDescription("desc");
  }

  @Issue("HSAP-185")
  @Test(description = "Verify all Restaurant List objects are displayed correctly")
  void navigateToRestaurantListScreen_screenElementAreDisplayed() {
    // When
    locationsScreen.submitAddress();

    // Then
    restaurantsListScreen.verifyRestaurantsListLayout();
  }

  @Issue("HSAP-186")
  @Test(description = "Verify all restaurants that meet the search criteria are returned")
  public void searchForRestaurant_resultsMatchedSearchCriteria() {
    // When
    locationsScreen.submitAddress();
    restaurantCount = restaurantsListScreen.getRestaurantsCount(false);
    keyword = restaurantsListScreen.searchForRestaurant("بيتزا هت");

    // Then
    restaurantsListScreen.verifyReturnedRestaurants(keyword);
  }

  @Issue("HSAP-186")
  @Test(description = "Verify clearing search criteria will reset the list view")
  public void clickToResetSearchCriteria_restaurantListWillBeReset() {
    // When
    locationsScreen.submitAddress();
    restaurantCount = restaurantsListScreen.getRestaurantsCount(false);
    keyword = restaurantsListScreen.searchForRestaurant("بيتزا هت");

    // When
    afterSearchRestaurantCount = restaurantsListScreen.clearSearchCriteria();

    // Then
    restaurantsListScreen.verifyAllRestaurantsAreReturned(
        restaurantCount, afterSearchRestaurantCount);
  }

  @Issue("HSAP-188")
  @Test(description = "Verify recommended badge is displaying next to the recommended restaurants")
  public void navigateToRestaurantsListScreen_checkRecommendedRestaurantsBadge() {
    // When
    locationsScreen.submitAddress();
    restaurantsListScreen.searchForRestaurant(recommendedRestaurant);

    // Then
    restaurantsListScreen.checkRecommendedBadge(true);
    // todo: make sure that this step is going to be executed otherwise next tests will fail
    restaurantsListScreen.clearSearchCriteria();
  }

  @Issue("HSAP-189")
  @Test(
      description =
          "verify recommended badge is only displayed for restaurant with ready status only")
  public void navigateToRestaurantList_recommendedBadgeDisplayOnlyForReadyRestaurant() {
    // When
    locationsScreen.submitAddress();
    restaurantsListScreen.searchForRestaurant(notReadyRecommendedRestaurant);

    // Then
    restaurantsListScreen.checkRecommendedBadge(false);
  }

  @Issue("HSAP-190")
  @Test(
      description =
          "Verify restaurants are sorted according to the distance from the location provided")
  public void navigateToRestaurantsListScreen_verifyRestaurantsSortedByDistance() {
    // When
    locationsScreen.submitAddress();
    restaurantsListScreen.scrollDownRestaurantsList();

    // Then
    restaurantsListScreen.checkIfRestaurantsSortedByDistance();
  }

  @Issue("HSAP-191")
  @Test(
      description = "Verify promoted restaurants are displayed at the top of restaurants list",
      enabled = false)
  public void navigateToRestaurantsListScreen_verifyPromotedRestaurantsDisplayOnTop() {
    // When
    locationsScreen.submitAddress();

    // Then
    restaurantsListScreen.verifyPromotedRestaurantsDisplayOnTop();
  }

  @Issue("HSAP-192")
  @Test(description = "Check if the filters section is displayed below the banners section")
  public void navigateToRestaurantsListScreen_verifyKitchenTypeFiltersAreDisplayed() {
    // When
    locationsScreen.submitAddress();

    // Then
    restaurantsListScreen.verifyRestaurantFiltersAreDisplayed();
  }

  @Issue("HSAP-193")
  @Test(
      description = "Check if the user is eligible to see the 'All' filter among the filters list")
  public void navigateToRestaurantsListScreen_verifyTheAllFilterIsDisplayedAndSelected() {
    // When
    locationsScreen.submitAddress();

    // Then
    restaurantsListScreen.verifyAllFiterIsDisplayed();
    restaurantsListScreen.verifyAllFiterIsSelectedAndColorIsYellow();
  }

  @Issue("HSAP-194")
  @Test(description = "Check if the user is able to swipe left and right on the filters list")
  public void navigateToRestaurantsListScreen_verifyCustomerCanSwipeOnFilters() {
    // When
    locationsScreen.submitAddress();
    firstFilterTitle = restaurantsListScreen.swipeFiltersList();

    // Then
    restaurantsListScreen.verifyFiltersSwipedSuccessfully(firstFilterTitle);
  }

  @Issue("HSAP-195")
  @Test(description = "Check that the top banner image's ratio is 2:1")
  public void navigateToRestaurantsListScreen_verifyTopBannerImgRatioIs2_1() {
    // When
    locationsScreen.submitAddress();

    // Then
    restaurantsListScreen.verifyTopBannerImageRatio();
  }

  @Issue("HSAP-197")
  @Test(description = "Check if the top banner shows restaurant offers")
  public void navigateToRestaurantsListScreen_verifyTopBannerShowsRestaurantOffers() {
    // When
    locationsScreen.submitAddress();

    // Then
    restaurantsListScreen.verifyTopBannerShowsOnlyOffers();
  }
}
