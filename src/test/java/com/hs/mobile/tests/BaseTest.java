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
import com.hs.mobile.steps.AddReferalCodeSteps;
import com.hs.mobile.steps.HomescreenSteps;
import com.hs.mobile.steps.OrdersSteps;
import com.hs.mobile.steps.PinCodeVerificationSteps;
import com.hs.mobile.steps.VerifyAccountSteps;
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
    static HomescreenSteps homescreenSteps;
    static OrdersSteps ordersSteps;
    static VerifyAccountSteps verifyAccountSteps;
    static PinCodeVerificationSteps pinCodeVerificationSteps;
    static AddReferalCodeSteps addReferalCodeSteps;

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

        //pages
        homeScreen = new HomeScreen(driver, touchAction);
        locationsScreen = new LocationsScreen(driver, touchAction);
        restaurantsListScreen = new RestaurantsListScreen(driver, touchAction);
        restaurantScreen = new RestaurantScreen(driver, touchAction);
        ordersScreen = new OrdersScreen(driver, touchAction);
        verifyAccountScreen = new VerifyAccountScreen(driver, touchAction);
        pinCodeVerificationScreen = new PinCodeVerificationScreen(driver, touchAction);
        addReferalCodeScreen = new AddReferalCodeScreen(driver, touchAction);

        //steps
        homescreenSteps = new HomescreenSteps(driver, touchAction);
        ordersSteps = new OrdersSteps(driver, touchAction);
        verifyAccountSteps = new VerifyAccountSteps(driver, touchAction);
        pinCodeVerificationSteps = new PinCodeVerificationSteps(driver, touchAction);
        addReferalCodeSteps = new AddReferalCodeSteps(driver, touchAction);

    }

    @AfterAll
    static void closeApp() {
        stopAppium();
    }
}
