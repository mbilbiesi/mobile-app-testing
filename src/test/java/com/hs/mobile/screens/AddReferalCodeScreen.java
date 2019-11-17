package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddReferalCodeScreen extends AbstractScreen {
    public AddReferalCodeScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

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
}
