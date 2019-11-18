package com.hs.mobile.tests;

import com.hs.mobile.core.appium.AppiumController;
import com.hs.mobile.screens.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest extends AppiumController {
    static HomeScreen homeScreen;
    static LocationsScreen locationsScreen;
    static RestaurantsListScreen restaurantsListScreen;
    static RestaurantScreen restaurantScreen;
    static SavedLocationsScreen savedLocationsScreen;

    @BeforeAll
    static void startAppiumServer() {
        platform = OperatingSystem.valueOf("android".toUpperCase());

        if (platform.equals(OperatingSystem.ANDROID)) {
            udid = "emulator-5554";
            automationName = "UiAutomator2";
        } else if (platform.equals(OperatingSystem.IOS)) {
            automationName = "XCUITest";
        }

        startAppium();

        homeScreen = new HomeScreen(driver, touchAction);
        locationsScreen = new LocationsScreen(driver, touchAction);
        restaurantsListScreen = new RestaurantsListScreen(driver, touchAction);
        restaurantScreen = new RestaurantScreen(driver, touchAction);
        savedLocationsScreen = new SavedLocationsScreen(driver, touchAction);
    }

    @AfterAll
    static void closeApp() {
        stopAppium();
    }
}
