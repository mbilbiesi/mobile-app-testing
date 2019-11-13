package com.hs.mobile.tests;

import com.hs.mobile.core.appium.AppiumController;
import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.LocationsScreen;
import com.hs.mobile.screens.RestaurantScreen;
import com.hs.mobile.screens.RestaurantsListScreen;
import com.hs.mobile.steps.HomescreenSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest extends AppiumController {
    static HomeScreen homeScreen;
    static LocationsScreen locationsScreen;
    static RestaurantsListScreen restaurantsListScreen;
    static RestaurantScreen restaurantScreen;
    static HomescreenSteps homescreenSteps;

    @BeforeAll
    static void startAppiumServer() {
        platform = OperatingSystem.valueOf("android".toUpperCase());

        if (platform.equals(OperatingSystem.ANDROID)) {
            udid = "Abdulla_Pixel_3_Emulator";
            automationName = "UiAutomator2";
        } else if (platform.equals(OperatingSystem.IOS)) {
            automationName = "XCUITest";
        }

        startAppium();

        homeScreen = new HomeScreen(driver, touchAction);
        locationsScreen = new LocationsScreen(driver, touchAction);
        restaurantsListScreen = new RestaurantsListScreen(driver, touchAction);
        restaurantScreen = new RestaurantScreen(driver, touchAction);
        homescreenSteps = new HomescreenSteps(driver, touchAction);
    }

    @AfterAll
    static void closeApp() {
        stopAppium();
    }
}
