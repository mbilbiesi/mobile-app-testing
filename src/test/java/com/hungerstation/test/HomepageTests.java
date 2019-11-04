package com.hungerstation.test;

import com.hungerstation.exception.TestInitializationException;
import com.hungerstation.screens.Homepage;
import com.hungerstation.util.RunCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.hungerstation.constant.Constants.HS_APP_NAME;
import static com.hungerstation.constant.ErrorMessages.APP_LAUNCH_ERROR_MESSAGE;


public class HomepageTests extends RunCapabilities {

    private static Homepage homepage;

    @BeforeClass
    public static void start() {
        service = startServer();
        try {
            AndroidDriver<MobileElement> driver = capabilities(HS_APP_NAME);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            homepage = new Homepage(driver);
        } catch (Exception e) {
            throw new TestInitializationException(APP_LAUNCH_ERROR_MESSAGE, e);
        }
    }

    @Test
    public void verifyThatAllHomeScreenElementsAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homepage.getUseMyCurrentLocationText().isDisplayed(),
                "Use my current location text is not displayed.");
        softAssert.assertTrue(homepage.getUseMyCurrentLocationImage().isDisplayed(),
                "Use my current location image is not displayed.");
        softAssert.assertTrue(homepage.getBtnSearchForRestaurants().isDisplayed(),
                "Find restaurant button is not displayed.");
        softAssert.assertTrue(homepage.getRestaurantsItem().isDisplayed(),
                "Restaurants item is not displayed.");
        softAssert.assertTrue(homepage.getOrdersItem().isDisplayed(), "Orders item is not displayed.");
        softAssert.assertTrue(homepage.getOffersItem().isDisplayed(), "Offers item is not displayed.");
        softAssert.assertTrue(homepage.getMoreItem().isDisplayed(), "More item is not displayed.");
        softAssert.assertAll();
    }

    @AfterClass
    public void finish() {
        service.stop();
    }
}
