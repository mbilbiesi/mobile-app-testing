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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.URL;

public class BaseTest {

  private static final String ANDROID_FILE_PATH =
          Resources.getResource("apps/hs-app.apk").getPath();
  private static final String IOS_FILE_PATH =
      Resources.getResource("apps/HungerStation.app").getPath();
  private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
  private static final String APPIUM_URL = "http://localhost:4723/wd/hub";
  private static final TestUserProvider testUserProvider = new TestUserProvider();
  protected AppiumDriver driver;

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
  @Parameters({"platform", "udid", "systemPort", "userId", "language"})
  void startAppiumServer(
          String platform, String udid, String systemPort, String userId, String language) {
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

    testUser = testUserProvider.getUser(userId);
    locationsData = new LocationsProvider(language);
    restaurantsData = new RestaurantsProvider(language);
    messages = new MessagesProvider(language);
    homeScreenSteps = new HomeScreenSteps(driver);
    restaurantsListSteps = new RestaurantListScreenSteps(driver);
    verifyAccountScreenSteps = new VerifyAccountScreenSteps(driver);
    pinCodeVerificationSteps = new PinCodeVerificationSteps(driver);
    restaurantScreenSteps = new RestaurantScreenSteps(driver);
    savedLocationsScreenSteps = new SavedLocationsScreenSteps(driver);
    profileScreenSteps = new ProfileScreenSteps(driver);
    invoicesScreenSteps = new InvoicesScreenSteps(driver);
    settingsScreenSteps = new SettingsScreenSteps(driver);
    paymentOptionsSteps = new PaymentOptionsSteps(driver);
    walletScreenSteps = new WalletScreenSteps(driver);
    myOrdersSteps = new MyOrdersSteps(driver);
    orderSteps = new OrderSteps(driver);
    helpSteps = new HelpSteps(driver);
    ticketSteps = new TicketSteps(driver);
    createTicketSteps = new CreateTicketSteps(driver);
    checkoutScreenSteps = new CheckoutScreenSteps(driver);
    locationScreenSteps = new LocationScreenSteps(driver);
    applePaySteps = new WelcomeApplePaySteps(driver);
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

  @AfterClass
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
