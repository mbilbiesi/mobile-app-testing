package com.hs.mobile.steps;

import com.hs.mobile.screens.OrdersScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Step;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class OrdersSteps extends OrdersScreen {

    public OrdersSteps(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

    @Step("Make sure that \"Verify Mobile Number\" button if customer is not logged in")
    public void verifyThatVerifyMobileButtonIsDisplayed() {
        assertAll(
                () -> assertThat(isBtnVerifyDisplayed())
                        .as("Verify mobile number button is not displayed.").isTrue()
        );
    }

    @Step("Make sure that all orders details are displayed if customer is logged in")
    public void verifyThatAllOrdersElementsIsDisplayed() {
        assertAll(
                () -> assertThat(isEleOrdersDisplayed())
                        .as("Customer orders are not displayed.").isTrue(),
                () -> assertThat(isEleOrderTitlesDisplayed()).as(
                        "Customer order titles are not displayed.").isTrue(),
                () -> assertThat(isEleOrderPriceDisplayed()).as(
                        "Order prices are not displayed.").isTrue(),
                () -> assertThat(isEleOrderStatusDisplayed())
                        .as("Orders statuses are not displayed.").isTrue(),
                () -> assertThat(isEleOrderDateDisplayed())
                        .as("Orders item is not displayed.").isTrue(),
                () -> assertThat(isEleOrderDateDisplayed())
                        .as("Orders dates are not displayed.").isTrue()
        );
    }

    @Step("Click the \"Verify\" button")
    public void clickVerifyButton() {
        touchAction.tap(tapOptions().withElement(element(getBtnVerify()))).perform();
    }

    @Step("Navigate back to Restaurants")
    public void navigateToRestaurants(){
        touchAction.tap(tapOptions().withElement(element(getBtnRestaurants()))).perform();
    }
}
