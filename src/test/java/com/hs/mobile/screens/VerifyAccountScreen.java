package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class VerifyAccountScreen extends AbstractScreen {

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/phone_number")
    private MobileElement txtPhoneNumber;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_login")
    private MobileElement btnNext;

    public VerifyAccountScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isTxtPhoneNumberDisplayed() {
        return txtPhoneNumber.isDisplayed();
    }

    public boolean isBtnNextDisplayed() {
        return btnNext.isDisplayed();
    }

    public MobileElement getPhoneNumberTextbox() {
        return txtPhoneNumber;
    }

    public MobileElement getNextButton() {
        return btnNext;
    }

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
    public void insertMobileNumber(String number) {
        //TODO: Add a step to validate whether the entered mobile number is correct or not
        getPhoneNumberTextbox().sendKeys(number);
    }

    @Step("Click the \"Next\" button")
    public void clickNextButton() {
        touchAction.tap(tapOptions().withElement(element(getNextButton()))).perform();
    }
}
