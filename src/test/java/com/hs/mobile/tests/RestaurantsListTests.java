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
}
