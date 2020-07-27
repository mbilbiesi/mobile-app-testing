package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class ProfileScreen {


    //todo implement locator
    private MobileElement btnBack;

    //todo implement locator
    private MobileElement txtMyProfileHeader;

    @iOSXCUITFindBy(accessibility = "profile_title")
    private List<MobileElement> lblProfileTitle;

    @iOSXCUITFindBy(accessibility = "profile_name")
    private List<MobileElement> txtProfileName;

    @iOSXCUITFindBy(accessibility = "profile_number")
    private List<MobileElement> txtProfileNumber;

    @iOSXCUITFindBy(accessibility = "profile_email")
    private List<MobileElement> txtProfileEmailTxt;

    @iOSXCUITFindBy(accessibility = "profile_update")
    private List<MobileElement> btnUpdateProfile;

    @iOSXCUITFindBy(accessibility = "profile_logout")
    private List<MobileElement> clickableProfileLogoutBtn;





}
