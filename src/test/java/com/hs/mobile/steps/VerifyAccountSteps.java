package com.hs.mobile.steps;

import com.hs.mobile.screens.OrdersScreen;
import com.hs.mobile.screens.VerifyAccountScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Step;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class VerifyAccountSteps extends VerifyAccountScreen {

    public VerifyAccountSteps(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

    @Step("Make sure that all orders details are displayed if customer isn't logged in")
    public void verifyThatAllMyOrdersElementsIsDisplayed() {
        assertAll(
                () -> assertThat(isTxtPhoneNumberDisplayed())
                        .as("Mobile number text box is not displayed.").isTrue(),
                () -> assertThat(isBtnNextDisplayed()).as(
                        "Next button is not displayed.").isTrue()
        );
    }

    @Step("Insert mobile number")
    public void insertMobileNumber(String number){
        //TODO: Add a step to validate whether the entered mobile number is correct or not
        getTxtPhoneNumber().sendKeys(number);
    }

    @Step("Click the \"Next\" button")
    public void clickNextButton() {
        touchAction.tap(tapOptions().withElement(element(getBtnNext()))).perform();
    }
}
