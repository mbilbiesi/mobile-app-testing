package com.hungerstation.test;

import com.hungerstation.exception.TestExecutionException;
import com.hungerstation.exception.TestInitializationException;
import com.hungerstation.screens.updated.HomeScreen;
import com.hungerstation.screens.updated.LocationsScreen;
import com.hungerstation.screens.updated.RestaurantScreen;
import com.hungerstation.screens.updated.RestaurantsListScreen;
import com.hungerstation.util.RunCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static com.hungerstation.constant.TestConstants.HS_APP_REFERENCE;


public class MiscTests extends RunCapabilities {
    private AndroidDriver<MobileElement> driver;
    private HomeScreen homeScreen;
    private LocationsScreen locationsScreen;
    private RestaurantsListScreen restaurantsListScreen;
    private RestaurantScreen restaurantScreen;

    @BeforeClass
    public static void startAppiumServer() {
        try {
            service = startServer();
        } catch (Exception e) {
            throw new TestInitializationException("An error occurred while attempting to start the Appium server.", e);
        }
    }

    @BeforeTest()
    public void startApp() {
        try {
            driver = capabilities(HS_APP_REFERENCE);
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
    public void verifyThatAllHomeScreenElementsAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homeScreen.isUseMyCurrentLocationTextDisplayed(),
                "Use my current location text is not displayed.");
        softAssert.assertTrue(homeScreen.isUseMyCurrentLocationImageDisplayed(),
                "Use my current location image is not displayed.");
        softAssert.assertTrue(homeScreen.isFindRestaurantsButtonDisplayed(),
                "Find restaurant button is not displayed.");
        softAssert.assertTrue(homeScreen.isRestaurantsItemDisplayed(), "Restaurants item is not displayed.");
        softAssert.assertTrue(homeScreen.isOrdersItemDisplayed(), "Orders item is not displayed.");
        softAssert.assertTrue(homeScreen.isOffersItemDisplayed(), "Offers item is not displayed.");
        softAssert.assertTrue(homeScreen.isMoreItemDisplayed(), "More item is not displayed.");
        softAssert.assertAll();
    }

    @Test
    public void addAnItemToCart() {
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

    @AfterTest
    public void closeApp() {
        if (driver != null) {
            driver.closeApp();
        }
    }

    @AfterClass
    public void stopAppiumServer() {
        if (service != null) {
            service.stop();
        }
    }
}
