package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class ProfileScreen {


    //todo implement locator
    private MobileElement clickableBackBtn;

    //todo implement locator
    private MobileElement txtMyProfileHeader;

    @iOSXCUITFindBy(accessibility = "profile_title")
    private List<MobileElement> profileTitle;

    @iOSXCUITFindBy(accessibility = "profile_name")
    private List<MobileElement> profileNameTxt;

    @iOSXCUITFindBy(accessibility = "profile_number")
    private List<MobileElement> profileNumberTxt;

    @iOSXCUITFindBy(accessibility = "profile_email")
    private List<MobileElement> profileEmailTxt;

    @iOSXCUITFindBy(accessibility = "profile_update")
    private List<MobileElement> clickableProfileUpdateBtn;

    @iOSXCUITFindBy(accessibility = "profile_logout")
    private List<MobileElement> clickableProfileLogoutBtn;





}
