package com.hs.mobile.tests;

import com.google.common.io.Resources;
import com.hs.mobile.core.configuration.DeviceCapabilities;
import com.hs.mobile.core.configuration.DeviceParameterResolver;
import com.hs.mobile.screens.AddReferalCodeScreen;
import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.LocationsScreen;
import com.hs.mobile.screens.OrdersScreen;
import com.hs.mobile.screens.PinCodeVerificationScreen;
import com.hs.mobile.screens.RestaurantScreen;
import com.hs.mobile.screens.RestaurantsListScreen;
import com.hs.mobile.screens.SavedLocationsScreen;
import com.hs.mobile.screens.VerifyAccountScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

@ExtendWith(DeviceParameterResolver.class)
public class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    protected static final String ANDROID_FILE_PATH = Resources.getResource("apps/hs-app.apk").getPath();
    private static final String APPIUM_URL = "http://localhost:4723/wd/hub";
    protected HomeScreen homeScreen;
    protected LocationsScreen locationsScreen;
    protected RestaurantsListScreen restaurantsListScreen;
    RestaurantScreen restaurantScreen;
    protected SavedLocationsScreen savedLocationsScreen;
    OrdersScreen ordersScreen;
    VerifyAccountScreen verifyAccountScreen;
    PinCodeVerificationScreen pinCodeVerificationScreen;
    AddReferalCodeScreen addReferalCodeScreen;

    protected static AppiumDriver driver;


    @BeforeEach
    void startAppiumServer(DeviceCapabilities device) {
        Capabilities capabilities = getCapabilities(device);

        try {
            driver = new AndroidDriver<MobileElement>(new URL(APPIUM_URL), capabilities);
        } catch (Exception e) {
            LOG.error("unable to initiate Android driver", e);
        }

        homeScreen = new HomeScreen(driver);
        locationsScreen = new LocationsScreen(driver);
        restaurantsListScreen = new RestaurantsListScreen(driver);
        restaurantScreen = new RestaurantScreen(driver);
        ordersScreen = new OrdersScreen(driver);
        verifyAccountScreen = new VerifyAccountScreen(driver);
        pinCodeVerificationScreen = new PinCodeVerificationScreen(driver);
        addReferalCodeScreen = new AddReferalCodeScreen(driver);
        savedLocationsScreen = new SavedLocationsScreen(driver);
    }

    public DesiredCapabilities getCapabilities(DeviceCapabilities device) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Smaz");
        capabilities.setCapability(MobileCapabilityType.UDID, device.udid());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device.platformName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device.platformVersion());
        capabilities.setCapability(MobileCapabilityType.APP, ANDROID_FILE_PATH);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, device.systemPort());
        return capabilities;
    }

    @AfterEach
    void closeApp() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                LOG.error("unable to stop appium", e);
            }
        }
    }
}
