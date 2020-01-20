package com.hs.mobile.tests;

import com.google.common.io.Resources;
import com.hs.mobile.screens.AddReferalCodeScreen;
import com.hs.mobile.screens.CreateTicketScreen;
import com.hs.mobile.screens.HelpScreen;
import com.hs.mobile.screens.LocationsScreen;
import com.hs.mobile.screens.MyOrdersScreen;
import com.hs.mobile.screens.OrderScreen;
import com.hs.mobile.screens.PaymentOptionsScreen;
import com.hs.mobile.screens.PinCodeVerificationScreen;
import com.hs.mobile.screens.RestaurantScreen;
import com.hs.mobile.screens.TicketScreen;
import com.hs.mobile.steps.CheckoutScreenSteps;
import com.hs.mobile.steps.CreateTicketSteps;
import com.hs.mobile.steps.HelpSteps;
import com.hs.mobile.steps.HomeScreenSteps;
import com.hs.mobile.steps.InvoicesScreenSteps;
import com.hs.mobile.steps.LocationScreenSteps;
import com.hs.mobile.steps.MyOrdersSteps;
import com.hs.mobile.steps.OrderSteps;
import com.hs.mobile.steps.ProfileScreenSteps;
import com.hs.mobile.steps.RestaurantListScreenSteps;
import com.hs.mobile.steps.RestaurantScreenSteps;
import com.hs.mobile.steps.SavedLocationsScreenSteps;
import com.hs.mobile.steps.SettingsScreenSteps;
import com.hs.mobile.steps.TicketSteps;
import com.hs.mobile.steps.VerifyAccountScreenSteps;
import com.hs.mobile.steps.WalletScreenSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.URL;

public class BaseTest {

    protected static final String ANDROID_FILE_PATH =
            Resources.getResource("apps/hs-app.apk").getPath();
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    private static final String APPIUM_URL = "http://localhost:4723/wd/hub";
    protected HomeScreenSteps homeScreenSteps;
    protected LocationsScreen locationsScreen;
    LocationScreenSteps locationScreenSteps;
    protected AppiumDriver driver;
    RestaurantListScreenSteps restaurantsListScreen;
    RestaurantScreen restaurantScreen;
    SavedLocationsScreenSteps savedLocationsScreenSteps;
    RestaurantScreenSteps restaurantScreenSteps;
    MyOrdersScreen myOrdersScreen;
    VerifyAccountScreenSteps verifyAccountScreenSteps;
    PinCodeVerificationScreen pinCodeVerificationScreen;
    AddReferalCodeScreen addReferalCodeScreen;
    ProfileScreenSteps profileScreenSteps;
    InvoicesScreenSteps invoicesScreenSteps;
    SettingsScreenSteps settingsScreenSteps;
    PaymentOptionsScreen paymentOptionsScreen;
    WalletScreenSteps walletScreenSteps;
    MyOrdersSteps myOrdersSteps;
    OrderScreen orderScreen;
    OrderSteps orderSteps;
    HelpScreen helpScreen;
    HelpSteps helpSteps;
    TicketScreen ticketScreen;
    TicketSteps ticketSteps;
    CreateTicketScreen createTicketScreen;
    CreateTicketSteps createTicketSteps;
    CheckoutScreenSteps checkoutScreenSteps;

    @BeforeClass
    @Parameters({"platform", "udid", "systemPort"})
    void startAppiumServer(String platform, String udid, String systemPort) {
        String[] platformInfo = platform.split(" ");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "DeviceName");
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
        capabilities.setCapability(MobileCapabilityType.APP, ANDROID_FILE_PATH);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        try {
            driver = new AndroidDriver<MobileElement>(new URL(APPIUM_URL), capabilities);
        } catch (Exception e) {
            LOG.error("unable to initiate Android driver", e);
        }

        homeScreenSteps = new HomeScreenSteps(driver);
        locationsScreen = new LocationsScreen(driver);
        restaurantsListScreen = new RestaurantListScreenSteps(driver);
        restaurantScreen = new RestaurantScreen(driver);
        myOrdersScreen = new MyOrdersScreen(driver);
        verifyAccountScreenSteps = new VerifyAccountScreenSteps(driver);
        pinCodeVerificationScreen = new PinCodeVerificationScreen(driver);
        addReferalCodeScreen = new AddReferalCodeScreen(driver);
        restaurantScreenSteps = new RestaurantScreenSteps(driver);
        savedLocationsScreenSteps = new SavedLocationsScreenSteps(driver);
        profileScreenSteps = new ProfileScreenSteps(driver);
        invoicesScreenSteps = new InvoicesScreenSteps(driver);
        settingsScreenSteps = new SettingsScreenSteps(driver);
        paymentOptionsScreen = new PaymentOptionsScreen(driver);
        walletScreenSteps = new WalletScreenSteps(driver);
        myOrdersSteps = new MyOrdersSteps(driver);
        orderScreen = new OrderScreen(driver);
        orderSteps = new OrderSteps(driver);
        helpScreen = new HelpScreen(driver);
        helpSteps = new HelpSteps(driver);
        ticketScreen = new TicketScreen(driver);
        ticketSteps = new TicketSteps(driver);
        createTicketScreen = new CreateTicketScreen(driver);
        createTicketSteps = new CreateTicketSteps(driver);
        checkoutScreenSteps = new CheckoutScreenSteps(driver);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
