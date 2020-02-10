package com.hs.mobile.steps;

import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.HomeScreenSideMenu;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class HomeScreenSteps {
    private HomeScreen homeScreen;
    private RestaurantListScreenSteps restaurant;
    private AppiumDriver driver;

    public HomeScreenSteps(AppiumDriver driver) {
        this.driver = driver;
        homeScreen = new HomeScreen(driver);
        restaurant = new RestaurantListScreenSteps(driver);
    }


    @Step("Find restaurants")
    public void findRestaurants() {
        homeScreen.tap(homeScreen.getFindRestaurantsButton());
        restaurant.waitUntilRestaurantsAreLoaded();
    }

    @Step("View saved locations")
    public void viewSavedLocations() {
        homeScreen.tap(homeScreen.getUseMyCurrentLocationText());
    }

    @Step("Verify that all 'Homescreen' elements are displayed correctly")
    public void verifyThatAllHomeElementsDisplayed() {
        homeScreen.verifyScreenElements();
    }

    @Step("Click the 'My Orders' button")
    public void clickMyOrdersButton() {
        homeScreen.tap(homeScreen.getOrdersItem());
    }

    @Step("Click the 'Find Restaurants' button")
    public void clickFindRestaurantsButton() {
        homeScreen.tap(homeScreen.getFindRestaurantsButton());
    }

    @Step("Click on restaurant icon")
    public void clickOnResturantIcon() {
        homeScreen.tap(homeScreen.getRestaurantsItem());
    }

    @Step("Click on more")
    public HomeScreenSideMenu clickOnMore() {
        homeScreen.tap(homeScreen.getMoreItem());
        return new HomeScreenSideMenu(driver);
    }
}
