package com.hs.mobile.tests;

import com.google.common.io.Resources;
import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.LocationsScreen;
import com.hs.mobile.screens.RestaurantScreen;
import com.hs.mobile.screens.RestaurantsListScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    private static final String ANDROID_FILE_PATH = Resources.getResource("apps/hs-app.apk").getPath();
    private static final String APPIUM_URL = "http://localhost:4723/wd/hub";
    static HomeScreen homeScreen;
    static LocationsScreen locationsScreen;
    static RestaurantsListScreen restaurantsListScreen;
    static RestaurantScreen restaurantScreen;

    private AppiumDriver driver;
    private TouchAction touchAction;

    //@BeforeTest(alwaysRun = true)
    //@Parameters({"platform", "udid", "systemPort"})
    @BeforeEach
    @ParameterizedTest
    @MethodSource("deviceProvider")
    void startAppiumServer(String platform, String udid, String systemPort) {
        String[] platformInfo = platform.split(" ");
        String platformName = platformInfo[0];
        String platformVersion = platformInfo[1];

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Smaz");
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.APP, ANDROID_FILE_PATH);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);

        try {
            driver = new AndroidDriver<MobileElement>(new URL(APPIUM_URL), capabilities);
        } catch (Exception e) {
            LOG.error("unable to initiate Android driver", e);
        }


        homeScreen = new HomeScreen(driver, touchAction);
        locationsScreen = new LocationsScreen(driver, touchAction);
        restaurantsListScreen = new RestaurantsListScreen(driver, touchAction);
        restaurantScreen = new RestaurantScreen(driver, touchAction);
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

    static Stream<Arguments> deviceProvider() {
        return Stream.of(
                arguments("Android 10.0", "emulator-5556", "8200"),
                arguments("Android 10.0", "emulator-5554", "8201")
        );
    }

}
