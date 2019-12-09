package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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
    //ToDO: Find a way to retrieve different test data for restaurants dynamically:
    String recommendedRestaurant = "ماكدونالد";
    String notReadyRecommendedRestaurant = "ليمونة";

    @Issue("HSAP-185")
    @Test(priority = 1, description = "Make sure that all Restaurant List objects are displayed correctly")
    @Story("Check Restaurants List Screen Layout")
    void navigateToResturantListScreen_screenElementAreDisplayed() {
        //Given
        homeScreen.clickFindRestaurantsButton();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("riyadh");
        locationsScreen.selectItemArea(3);
        locationsScreen.submitAddress();
        locationsScreen.insertAddressDescription("desc");

        //When
        locationsScreen.submitAddress();

        //Then
        restaurantsListScreen.verifyRestaurantsListLayout();
    }

    @Test(priority = 2, description = "Make sure that all restaurants meet the search criteria are returned correctly")
    @Issue("HSAP-186")
    @Story("Search for a specific restaurant")
    public void searchForRestaurant_resultsMatchedSearchCriteria() {
        //Given
        homeScreen.clickFindRestaurantsButton();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("riyadh");
        locationsScreen.selectItemArea(3);
        locationsScreen.submitAddress();
        locationsScreen.insertAddressDescription("desc");
        locationsScreen.submitAddress();

        //And
        restaurantCount = restaurantsListScreen.getRestaurantsCount();

        //And
        keyword = restaurantsListScreen.searchForRestaurant("بيتزا هت");

        //Then
        restaurantsListScreen.verifyReturnedRestaurants(keyword);

        //When
        afterSearchRestaurantCount = restaurantsListScreen.clearSearchCriteria();

        //Then
        restaurantsListScreen.verifyAllRestaurantsAreReturned(restaurantCount, afterSearchRestaurantCount);
    }

    @Issue("HSAP-188")
    @Test(priority = 3, description = "Make sure that the recommended badge shows next to the recommended restaurants")
    @Story("Check if recommended flag appears on the restaurants list")
    public void checkRecommendedRestaurantsBadge() {
        //When customer selects an address
        homeScreen.clickFindRestaurantsButton();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("riyadh");
        locationsScreen.selectItemArea(3);
        locationsScreen.submitAddress();
        locationsScreen.insertAddressDescription("desc");

        //And clicks "Search for Restaurants'
        locationsScreen.submitAddress();

        //And searches for a recommended restaurant
        restaurantsListScreen.searchForRestaurant(recommendedRestaurant);

        //Then
        restaurantsListScreen.checkRecommendedBadge(true);
        restaurantsListScreen.clearSearchCriteria();
    }

    @Test(priority = 4, description = "verify recommended badge is only displayed for restaurant with ready status only")
    @Issue("HSAP-189")
    @Story("Check if recommended flag appears for non-ready restaurants")
    public void navigateToRestaurantList_recommnededBadgeDisplayOnlyForReadyRestaurant() {
        //When customer selects an
        homeScreen.clickFindRestaurantsButton();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("riyadh");
        locationsScreen.selectItemArea(3);
        locationsScreen.submitAddress();
        locationsScreen.insertAddressDescription("desc");

        //And clicks "Search for Restaurants"
        locationsScreen.submitAddress();

        //And searches for a recommended restaurant which is not with a 'Ready' status
        restaurantsListScreen.searchForRestaurant(notReadyRecommendedRestaurant);

        //Then verify that the "Recommended" badge doesn't show next to the restaurant
        restaurantsListScreen.checkRecommendedBadge(false);
    }

    @Test(priority = 5)
    @Issue("HSAP-190")
    @Story("Check if user can see restaurants stored by distance")
    @Description("Make sure that restaurants are sorted according their distance from the searched location")
    @Severity(SeverityLevel.NORMAL)
    public void verifyRestaurantsSortedByDistance() {

        //When
        //Already executed in the previous test case

        //And scrolls down the restaurants list to get more restaurants displayed
        restaurantsListScreen.scrollDownRestaurantsList();

        //Then, verify that restaurants are sorted by their distance
        restaurantsListScreen.checkIfRestaurantsSortedByDistance();
    }
}
