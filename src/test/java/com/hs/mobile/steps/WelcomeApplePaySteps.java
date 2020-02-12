package com.hs.mobile.steps;

import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.HomeScreenSideMenu;
import com.hs.mobile.screens.WelcomeApplePayIOS;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class WelcomeApplePaySteps extends WelcomeApplePayIOS {

    public WelcomeApplePaySteps(AppiumDriver driver) {
        super(driver);
    }

    HomeScreenSteps homescreen = new HomeScreenSteps(driver);

    @Step("Click Later")
    public void skipApplePay() {
        tap(getBtnSkipApplePay());
        homescreen.waitUntilHomescreenIsLoaded();
    }
}
