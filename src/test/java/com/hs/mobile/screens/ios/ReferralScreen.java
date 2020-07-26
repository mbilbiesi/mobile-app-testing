package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ReferralScreen {

    //todo implement or find a way to make it  unique -
    private MobileElement clickableBackBtn;

    private MobileElement referralCodeHeaderTxt;

    @iOSXCUITFindBy(accessibility = "referral_code_title")
    private MobileElement referralCodeTitleTxt;

    @iOSXCUITFindBy(accessibility = "referral_code_value")
    private MobileElement referralCodeValue;


    @iOSXCUITFindBy(accessibility = "referral_code_description")
    private MobileElement referralCodeDescriptionTxt;

    //todo implement locator
    private MobileElement sendCodeViaText;

    //todo implement locator
    private MobileElement sendCodeViaWhatsApp;

    //todo implement locator
    private MobileElement sendCodeViaMail;

    //todo implement locator
    private MobileElement sendCodeViaOthers;







}
