package com.hs.mobile.tests;

import com.hs.mobile.steps.LocationSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Epic("Smoke Tests")
@Feature("Restaurants List Tests")
@Execution(ExecutionMode.CONCURRENT)
class RestaurantsListTests extends BaseTest {

    LocationSteps locationSteps = new LocationSteps();
    int restaurantCount = 0;
    int afterSearchRestaurantCount = 0;
    String keyword = null;
    //ToDO: Find a way to retrieve different test data for restaurants dynamically:
    String recommendedRestaurant = "ماكدونالد";
    String notReadyRecommendedRestaurant = "ليمونة";

    @Test
    @Issue("HSAP-185")
    @Story("Check Restaurants List Screen Layout")
    @Description("Make sure that all Restaurant List objects are displayed correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void checkRestaurantsListLayout(TestInfo testInfo){
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

    @Test
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
        restaurantCount = restaurantsListScreen.getRestaurantsCount();

        //And searches for specific restaurants
        keyword = restaurantsListScreen.searchForRestaurant("بيتزا هت");

        //Then verify that the returned restaurants match the search criteria
        restaurantsListScreen.verifyReturnedRestaurants(keyword);

        //When: customer clears search criteria
        afterSearchRestaurantCount = restaurantsListScreen.clearSearchCriteria();

        //Then verify that all restaurants are returned
        restaurantsListScreen.verifyAllRestaurantsAreReturned(restaurantCount, afterSearchRestaurantCount);

    }

    @Test
    @Issue("HSAP-188")
    @Story("Check if recommended flag appears on the restaurants list")
    @Description("Make sure that the recommended badge shows next to the recommended restaurants")
    @Severity(SeverityLevel.CRITICAL)
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
    }

    @Test
    @Issue("HSAP-189")
    @Story("Check if recommended flag appears for non-ready restaurants")
    @Description("Make sure that the recommended badge doesn't show for recommended " +
            "restaurants with a status other than ready")
    @Severity(SeverityLevel.CRITICAL)
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
    }

}
