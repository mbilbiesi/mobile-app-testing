package com.hs.mobile.tests;

import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.LocationsScreen;
import com.hs.mobile.screens.RestaurantScreen;
import com.hs.mobile.screens.RestaurantsListScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Epic("Allure examples")
@Feature("Junit 4 support")
@Execution(ExecutionMode.CONCURRENT)
class Demo extends BaseTest {
    private AndroidDriver<MobileElement> driver;
    private HomeScreen homeScreen;
    private LocationsScreen locationsScreen;
    private RestaurantsListScreen restaurantsListScreen;
    private RestaurantScreen restaurantScreen;



    @Test
    @Feature("Some feature")
    @Severity(SeverityLevel.CRITICAL)
    void verifyThatAllHomeScreenElementsAreDisplayed(TestInfo testInfo) {
        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(homeScreen.isUseMyCurrentLocationTextDisplayed()).as(
                "Use my current location text is not displayed.").isTrue();
        soft.assertThat(homeScreen.isUseMyCurrentLocationImageDisplayed()).as(
                "Use my current location image is not displayed.").isTrue();
        soft.assertThat(homeScreen.isFindRestaurantsButtonDisplayed()).as(
                "Find restaurant button is not displayed.").isTrue();
        soft.assertThat(homeScreen.isRestaurantsItemDisplayed()).as("Restaurants item is not displayed.").isTrue();
        soft.assertThat(homeScreen.isOrdersItemDisplayed()).as("Orders item is not displayed.").isTrue();
        soft.assertThat(homeScreen.isOffersItemDisplayed()).as("Offers item is not displayed.").isTrue();
        soft.assertThat(homeScreen.isMoreItemDisplayed()).as("More item is not displayed.").isTrue();
        soft.assertAll();
    }

    @Test
    void addAnItemToCart(TestInfo testInfo) {
        homeScreen.findRestaurants();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("Riyadh");
        locationsScreen.selectItemArea(0);
        locationsScreen.submitAddress();
        locationsScreen.insertAddressDescription("Test");
        locationsScreen.submitAddress();
        restaurantsListScreen.selectRestaurant(0);
        restaurantScreen.selectMenuItem(0);
        try {
            restaurantScreen.addMenuItem();
        } catch (Exception e) {
            throw new TestExecutionException("All restaurants are closed!", e);
        }
        restaurantScreen.goToCart();
    }

}
