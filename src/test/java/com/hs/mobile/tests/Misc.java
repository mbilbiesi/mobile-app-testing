package com.hs.mobile.tests;

import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.exception.TestInitializationException;
import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.LocationsScreen;
import com.hs.mobile.screens.RestaurantScreen;
import com.hs.mobile.screens.RestaurantsListScreen;
import com.hs.mobile.util.RunCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

@Epic("Allure examples")
@Feature("Junit 4 support")
class Misc extends RunCapabilities {
    private AndroidDriver<MobileElement> driver;
    private HomeScreen homeScreen;
    private LocationsScreen locationsScreen;
    private RestaurantsListScreen restaurantsListScreen;
    private RestaurantScreen restaurantScreen;

    @BeforeAll
    static void startAppiumServer() {
        try {
            service = startServer();
        } catch (Exception e) {
            throw new TestInitializationException("An error occurred while attempting to start the Appium server.", e);
        }
    }

    @AfterAll
    static void stopAppiumServer() {
        if (service != null) {
            service.stop();
        }
    }

    @BeforeEach()
    void startApp() {
        try {
            driver = capabilities("");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            TouchAction touchAction = new TouchAction(driver);
            homeScreen = new HomeScreen(driver, touchAction);
            locationsScreen = new LocationsScreen(driver, touchAction);
            restaurantsListScreen = new RestaurantsListScreen(driver, touchAction);
            restaurantScreen = new RestaurantScreen(driver, touchAction);
        } catch (Exception e) {
            throw new TestInitializationException("An error occurred while attempting to launch the application.", e);
        }
    }

    @Test
    @Feature("Some feature")
    @Severity(SeverityLevel.CRITICAL)
    void verifyThatAllHomeScreenElementsAreDisplayed() {
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
    void addAnItemToCart() {
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

    @AfterEach
    void closeApp() {
        if (driver != null) {
            driver.closeApp();
        }
    }
}
