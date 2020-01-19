package com.hs.mobile.steps;

import com.hs.mobile.screens.VerifyAccountScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class VerifyAccountScreenSteps extends VerifyAccountScreen {

    public VerifyAccountScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    public boolean isTxtPhoneNumberDisplayed() {
        return getTxtPhoneNumber().isDisplayed();
    }

    public boolean isBtnNextDisplayed() {
        return getBtnNext().isDisplayed();
    }

    public MobileElement getPhoneNumberTextbox() {
        return getTxtPhoneNumber();
    }

    public MobileElement getNextButton() {
        return getBtnNext();
    }

    @Step("Make sure that all orders details are displayed if customer isn't logged in")
    public void verifyThatAllMyOrdersElementsIsDisplayed() {
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(isTxtPhoneNumberDisplayed())
                .as("Mobile number text box is not displayed.")
                .isTrue();
        soft.assertThat(isBtnNextDisplayed()).as("Next button is not displayed.").isTrue();
        soft.assertAll();
    }

    @Step("Insert mobile number")
    public void insertMobileNumber(String number) {
        // TODO: Add a step to validate whether the entered mobile number is correct or not
        getPhoneNumberTextbox().sendKeys(number);
    }

    @Step("Click the \"Next\" button")
    public void clickNextButton() {
        touchAction.tap(tapOptions().withElement(element(getNextButton()))).perform();
    }
}
