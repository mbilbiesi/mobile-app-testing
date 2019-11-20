package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AddReferalCodeScreen extends AbstractScreen {
    public AddReferalCodeScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

    @iOSXCUITFindBy(className = "")
    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement btnClose;

    @iOSXCUITFindBy(className = "")
    @AndroidFindBy(className = "android.widget.ImageView")
    private MobileElement imgReferralCode;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_code_label")
    private MobileElement lblReferralCode;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_referral")
    private MobileElement txtReferralCode;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_verify")
    private MobileElement btnVerifyReferralCode;

    public boolean isBtnCloseDisplayed(){
        return btnClose.isDisplayed();
    }

    public boolean isImgReferralCodeDisplayed(){
        return imgReferralCode.isDisplayed();
    }

    public boolean isLblReferralCodeDisplayed(){
        return lblReferralCode.isDisplayed();
    }

    public boolean isTxtReferralCodeDisplayed(){
        return txtReferralCode.isDisplayed();
    }

    public boolean isBtnVerifyReferralCodeDisplayed(){
        return btnVerifyReferralCode.isDisplayed();
    }

    public MobileElement getBtnClose() {
        return btnClose;
    }

    public MobileElement getImgReferralCode() {
        return imgReferralCode;
    }

    public MobileElement getLblReferralCode() {
        return lblReferralCode;
    }

    public MobileElement getTxtReferralCode() {
        return txtReferralCode;
    }

    public MobileElement getBtnVerifyReferralCode() {
        return btnVerifyReferralCode;
    }

    @Step("Make sure that all Add Referal Code screen elements are displayed")
    public void verifyThatAllAddReferalCodeScreenElementsIsDisplayed() {
        assertAll(
                () -> assertThat(isBtnCloseDisplayed())
                        .as("Close button is not displayed.").isTrue(),
                () -> assertThat(isImgReferralCodeDisplayed())
                        .as("Referral Code Image is not displayed.").isTrue(),
                () -> assertThat(isLblReferralCodeDisplayed())
                        .as("Referral Code Label is not displayed.").isTrue(),
                () -> assertThat(isTxtReferralCodeDisplayed())
                        .as("Referral Code Text is not displayed.").isTrue(),
                () -> assertThat(isBtnVerifyReferralCodeDisplayed()).as(
                        "Verify Referral Code button is not displayed.").isTrue()
        );
    }

    @Step("Click the Close button")
    public void clickCloseButton() {
        hideKeyboard();
        touchAction.tap(tapOptions().withElement(element(getBtnClose()))).perform();
    }
}
