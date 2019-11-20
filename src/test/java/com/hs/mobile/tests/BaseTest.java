package com.hs.mobile.tests;

import com.hs.mobile.core.appium.AppiumController;
import com.hs.mobile.screens.AddReferalCodeScreen;
import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.LocationsScreen;
import com.hs.mobile.screens.VerifyAccountScreen;
import com.hs.mobile.screens.OrdersScreen;
import com.hs.mobile.screens.PinCodeVerificationScreen;
import com.hs.mobile.screens.RestaurantScreen;
import com.hs.mobile.screens.RestaurantsListScreen;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest extends AppiumController {
    static HomeScreen homeScreen;
    static LocationsScreen locationsScreen;
    static RestaurantsListScreen restaurantsListScreen;
    static RestaurantScreen restaurantScreen;
    static OrdersScreen ordersScreen;
    static VerifyAccountScreen verifyAccountScreen;
    static PinCodeVerificationScreen pinCodeVerificationScreen;
    static AddReferalCodeScreen addReferalCodeScreen;

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
        ordersScreen = new OrdersScreen(driver, touchAction);
        verifyAccountScreen = new VerifyAccountScreen(driver, touchAction);
        pinCodeVerificationScreen = new PinCodeVerificationScreen(driver, touchAction);
        addReferalCodeScreen = new AddReferalCodeScreen(driver, touchAction);
    }

    @AfterAll
    static void closeApp() {
        stopAppium();
    }
}
