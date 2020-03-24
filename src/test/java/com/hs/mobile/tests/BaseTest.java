package com.hs.mobile.tests;

import com.google.common.io.Resources;
import com.hs.mobile.data.locations.LocationsProvider;
import com.hs.mobile.data.messages.MessagesProvider;
import com.hs.mobile.data.restaurants.RestaurantsProvider;
import com.hs.mobile.data.user.TestUser;
import com.hs.mobile.data.user.TestUserProvider;
import com.hs.mobile.steps.CheckoutScreenSteps;
import com.hs.mobile.steps.CreateTicketSteps;
import com.hs.mobile.steps.HelpSteps;
import com.hs.mobile.steps.HomeScreenSteps;
import com.hs.mobile.steps.InvoicesScreenSteps;
import com.hs.mobile.steps.LocationScreenSteps;
import com.hs.mobile.steps.MyOrdersSteps;
import com.hs.mobile.steps.OrderSteps;
import com.hs.mobile.steps.PaymentOptionsSteps;
import com.hs.mobile.steps.PinCodeVerificationSteps;
import com.hs.mobile.steps.ProfileScreenSteps;
import com.hs.mobile.steps.RestaurantListScreenSteps;
import com.hs.mobile.steps.RestaurantScreenSteps;
import com.hs.mobile.steps.SavedLocationsScreenSteps;
import com.hs.mobile.steps.SettingsScreenSteps;
import com.hs.mobile.steps.TicketSteps;
import com.hs.mobile.steps.VerifyAccountScreenSteps;
import com.hs.mobile.steps.WalletScreenSteps;
import com.hs.mobile.steps.WelcomeApplePaySteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.URL;

public class BaseTest {

  private static final String IOS_FILE_PATH =
      Resources.getResource("apps/HungerStation.app").getPath();
  private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
  private static final String APPIUM_URL = "http://localhost:4723/wd/hub";
  private static final TestUserProvider testUserProvider = new TestUserProvider();
  //  private static final String ANDROID_FILE_PATH =
  //          Resources.getResource("apps/hs-app.apk").getPath();
  private static String ANDROID_FILE_PATH =
          "C:\\Users\\Discovery1\\Desktop\\mobile-apps-testing\\src\\test\\resources\\apps\\app-debug-258.apk";
  protected AppiumDriver driver;
  public boolean isLocationValid;
  private Location location;

  TestUser testUser;
  LocationsProvider locationsData;
  RestaurantsProvider restaurantsData;
  MessagesProvider messages;
  HomeScreenSteps homeScreenSteps;
  LocationScreenSteps locationScreenSteps;
  RestaurantListScreenSteps restaurantsListSteps;
  SavedLocationsScreenSteps savedLocationsScreenSteps;
  RestaurantScreenSteps restaurantScreenSteps;
  VerifyAccountScreenSteps verifyAccountScreenSteps;
  PinCodeVerificationSteps pinCodeVerificationSteps;
  ProfileScreenSteps profileScreenSteps;
  InvoicesScreenSteps invoicesScreenSteps;
  SettingsScreenSteps settingsScreenSteps;
  PaymentOptionsSteps paymentOptionsSteps;
  WalletScreenSteps walletScreenSteps;
  MyOrdersSteps myOrdersSteps;
  OrderSteps orderSteps;
  HelpSteps helpSteps;
  TicketSteps ticketSteps;
  CreateTicketSteps createTicketSteps;
  CheckoutScreenSteps checkoutScreenSteps;
  WelcomeApplePaySteps applePaySteps;

  @BeforeClass
  @Parameters({"platform", "udid", "systemPort", "userId", "language", "longitude", "latitude"})
  void startAppiumServer(
          String platform, String udid, String systemPort, String userId, String language, double longitude, double latitude) {
    String[] platformInfo = platform.split(" ");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    //    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "DeviceName");
    //    capabilities.setCapability(MobileCapabilityType.UDID, udid);
    //    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
    //    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
    //    capabilities.setCapability(MobileCapabilityType.APP, ANDROID_FILE_PATH);
    //    capabilities.setCapability("autoGrantPermissions", true);
    //    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

    if (platformInfo[0].equalsIgnoreCase("android")) {
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "DeviceName");
      capabilities.setCapability(MobileCapabilityType.UDID, udid);
      capabilities.setCapability(MobileCapabilityType.APP, ANDROID_FILE_PATH);
      capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
    } else if (platformInfo[0].equalsIgnoreCase("ios")) {
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
      capabilities.setCapability(
          MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
      capabilities.setCapability(MobileCapabilityType.APP, IOS_FILE_PATH);
      capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
    }

    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
    capabilities.setCapability("autoGrantPermissions", true);

    //    try {
    //      driver = new AndroidDriver<MobileElement>(new URL(APPIUM_URL), capabilities);
    //    } catch (Exception e) {
    //      LOG.error("unable to initiate Android driver", e);
    //    }

    driver = createDriver(platformInfo[0], capabilities);

    //location = setDeviceLocation(24.8245, 46.647, true); //Alyasmeen
    location = setDeviceLocation(31.963158, 35.930359, false); //Amman

    driver.setLocation(location);

    testUser = testUserProvider.getUser(userId);
    locationsData = new LocationsProvider(language);
    restaurantsData = new RestaurantsProvider(language);
    messages = new MessagesProvider(language);
    homeScreenSteps = new HomeScreenSteps(driver, language);
    restaurantsListSteps = new RestaurantListScreenSteps(driver, language);
    verifyAccountScreenSteps = new VerifyAccountScreenSteps(driver, language);
    pinCodeVerificationSteps = new PinCodeVerificationSteps(driver, language);
    restaurantScreenSteps = new RestaurantScreenSteps(driver, language);
    savedLocationsScreenSteps = new SavedLocationsScreenSteps(driver, language);
    profileScreenSteps = new ProfileScreenSteps(driver, language);
    invoicesScreenSteps = new InvoicesScreenSteps(driver, language);
    settingsScreenSteps = new SettingsScreenSteps(driver, language);
    paymentOptionsSteps = new PaymentOptionsSteps(driver, language);
    walletScreenSteps = new WalletScreenSteps(driver, language);
    myOrdersSteps = new MyOrdersSteps(driver, language);
    orderSteps = new OrderSteps(driver, language);
    helpSteps = new HelpSteps(driver, language);
    ticketSteps = new TicketSteps(driver, language);
    createTicketSteps = new CreateTicketSteps(driver, language);
    checkoutScreenSteps = new CheckoutScreenSteps(driver, language);
    locationScreenSteps = new LocationScreenSteps(driver, language);
    applePaySteps = new WelcomeApplePaySteps(driver, language);
  }

  private AppiumDriver createDriver(String platform, DesiredCapabilities capabilities) {
    if (platform.equalsIgnoreCase("android")) {
      try {
        driver = new AndroidDriver<MobileElement>(new URL(APPIUM_URL), capabilities);
      } catch (Exception e) {
        LOG.error("unable to initiate Android driver", e);
      }
    } else if (platform.equalsIgnoreCase("ios")) {
      try {
        driver = new IOSDriver<MobileElement>(new URL(APPIUM_URL), capabilities);
      } catch (Exception e) {
        LOG.error("unable to initiate Android driver", e);
      }
    }

    return driver;
  }

  private Location setDeviceLocation(double latitude, double longitude, boolean locValid) {
    Location location = new Location(latitude, longitude, 5.0);
    this.isLocationValid = locValid;
    //Current implementation has to be changed to handle setting location dynamically based on our inputs.

    return location;
  }


  @AfterClass
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
