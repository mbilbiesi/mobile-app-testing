package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MoreOptionsScreen {

    //Note for improvements - changing the name of the ID to a more descriptive name relates to the btn


    @iOSXCUITFindBy(accessibility = "cell_0")
    private MobileElement referralCodeBtn;

    @iOSXCUITFindBy(accessibility = "cell_2")
    private MobileElement myProfileBtn;

    @iOSXCUITFindBy(accessibility = "cell_3")
    private MobileElement paymentOptionsBtn;

    @iOSXCUITFindBy(accessibility = "cell_4")
    private MobileElement invoicesBtn;

    @iOSXCUITFindBy(accessibility = "cell_5")
    private MobileElement supportBtn;

    @iOSXCUITFindBy(accessibility = "cell_7")
    private MobileElement settingBtn;

}
