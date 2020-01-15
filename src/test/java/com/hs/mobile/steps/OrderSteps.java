package com.hs.mobile.steps;

import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.OrderScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class OrderSteps extends OrderScreen {

    public OrderSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Click on 'Help' button")
    public void clickHelp() {
        try {
            tap(getBtnHelp());
        } catch (TestExecutionException e) {
            throw new TestExecutionException("Unable to locate 'Help' button " + e);
        }
    }

    public void navigateBackToAllOrders() {
        tap(getBtnBack());
    }
}
