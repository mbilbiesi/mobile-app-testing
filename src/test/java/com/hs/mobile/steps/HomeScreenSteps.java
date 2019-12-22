package com.hs.mobile.steps;

import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.HomeScreenSideMenu;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class HomeScreenSteps extends HomeScreen {

    public HomeScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    private RestaurantListScreenSteps restaurant = new RestaurantListScreenSteps(driver);

    @Step("Find restaurants")
    public void findRestaurants() {
        tap(getFindRestaurantsButton());
        restaurant.waitUntilRestaurantsAreLoaded();
    }

    @Step("View saved locations")
    public void viewSavedLocations() {
        tap(getUseMyCurrentLocationText());
    }

    @Step("Verify that all 'Homescreen' elements are displayed correctly")
    public void verifyThatAllHomeElementsDisplayed() {
        verifyScreenElements();
    }

    @Step("Click the 'My Orders' button")
    public void clickMyOrdersButton() {
        tap(getOrdersItem());
    }

    @Step("Click the 'Find Restaurants' button")
    public void clickFindRestaurantsButton() {
        tap(getFindRestaurantsButton());
    }

    @Step("Click on restaurant icon")
    public void clickOnResturantIcon() {
        tap(getRestaurantsItem());
    }

    @Step("Click on more")
    public HomeScreenSideMenu clickOnMore() {
        tap(getMoreItem());
        return new HomeScreenSideMenu(driver);
    }
}
