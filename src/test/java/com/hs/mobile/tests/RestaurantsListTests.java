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
@Listeners(TestListener.class)
class RestaurantsListTests extends BaseTest {

    int restaurantCount = 0;
    int afterSearchRestaurantCount = 0;
    String keyword = null;
    //ToDO: Find a way to retrieve different test data for restaurants dynamically:
    String recommendedRestaurant = "ماكدونالد";
    String notReadyRecommendedRestaurant = "ليمونة";

    @Test(priority = 1)
    @Issue("HSAP-185")
    @Story("Check Restaurants List Screen Layout")
    @Description("Make sure that all Restaurant List objects are displayed correctly")
    public void checkRestaurantsListLayout() {
        //When customer selects an address
        homeScreen.clickFindRestaurantsButton();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("riyadh");
        locationsScreen.selectItemArea(3);
        locationsScreen.submitAddress();
        locationsScreen.insertAddressDescription("desc");

        //And searches for restaurants
        locationsScreen.submitAddress();

        //Then verify that all restaurant list elements are displayed correctly
        restaurantsListScreen.verifyRestaurantsListLayout();
    }

    @Test(priority = 2)
    @Issue("HSAP-186")
    @Story("Search for a specific restaurant")
    @Description("Make sure that all restaurants meet the search criteria are returned correctly")
    @Severity(SeverityLevel.NORMAL)
    public void searchForASpecificRestaurant(){
        //When customer selects an address
        homeScreen.clickFindRestaurantsButton();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("riyadh");
        locationsScreen.selectItemArea(3);
        locationsScreen.submitAddress();
        locationsScreen.insertAddressDescription("desc");
        locationsScreen.submitAddress();

        //And clicks "Search for Restaurants" button
        restaurantCount = restaurantsListScreen.getRestaurantsCount(false);

        //And searches for specific restaurants
        keyword = restaurantsListScreen.searchForRestaurant("بيتزا هت");

        //Then verify that the returned restaurants match the search criteria
        restaurantsListScreen.verifyReturnedRestaurants(keyword);

        //When: customer clears search criteria
        afterSearchRestaurantCount = restaurantsListScreen.clearSearchCriteria();

        //Then verify that all restaurants are returned
        restaurantsListScreen.verifyAllRestaurantsAreReturned(restaurantCount, afterSearchRestaurantCount);

    }

    @Test(priority = 3)
    @Issue("HSAP-188")
    @Story("Check if recommended flag appears on the restaurants list")
    @Description("Make sure that the recommended badge shows next to the recommended restaurants")
    @Severity(SeverityLevel.NORMAL)
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

        //Then "Recommended" badge should display next to the recommended restaurants
        restaurantsListScreen.checkRecommendedBadge(true);
        restaurantsListScreen.clearSearchCriteria();
    }

    @Test(priority = 4)
    @Issue("HSAP-189")
    @Story("Check if recommended flag appears for non-ready restaurants")
    @Description("Make sure that the recommended badge doesn't show for recommended " +
            "restaurants with a status other than ready")
    @Severity(SeverityLevel.NORMAL)
    public void checkRecommendedRestaurantsBadgeNotReady() {
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
        restaurantsListScreen.clearSearchCriteria();
    }

    @Test(priority = 5)
    @Issue("HSAP-190")
    @Story("Check if user can see restaurants stored by distance")
    @Description("Make sure that restaurants are sorted according their distance from the searched location")
    @Severity(SeverityLevel.NORMAL)
    public void verifyRestaurantsSortedByDistance() {
        //When customer selects an
//        homeScreen.clickFindRestaurantsButton();
//        locationsScreen.searchForRestaurants();
//        locationsScreen.insertLocation("riyadh");
//        locationsScreen.selectItemArea(3);
//        locationsScreen.submitAddress();
//        locationsScreen.insertAddressDescription("desc");
//
//        //And clicks "Search for Restaurants"
//        locationsScreen.submitAddress();

        //And scrolls down the restaurants list to get more restaurants displayed
        restaurantsListScreen.scrollDownRestaurantsList();

        //Then, verify that restaurants are sorted by their distance
        restaurantsListScreen.checkIfRestaurantsSortedByDistance();
    }

}
