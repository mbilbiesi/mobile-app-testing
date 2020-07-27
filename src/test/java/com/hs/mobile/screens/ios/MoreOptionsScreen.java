package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MoreOptionsScreen {

    //Note for improvements - changing the name of the ID to a more descriptive name relates to the btn


    @iOSXCUITFindBy(accessibility = "cell_0")
    private MobileElement btnReferralCode;

    @iOSXCUITFindBy(accessibility = "cell_2")
    private MobileElement btnMyProfile;

    @iOSXCUITFindBy(accessibility = "cell_3")
    private MobileElement btnPaymentOptions;

    @iOSXCUITFindBy(accessibility = "cell_4")
    private MobileElement btnInvoices;

    @iOSXCUITFindBy(accessibility = "cell_5")
    private MobileElement btnSupport;

    @iOSXCUITFindBy(accessibility = "cell_7")
    private MobileElement btnSettings;

}
