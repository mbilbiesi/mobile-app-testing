package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProfileScreen {

  // todo implement locator
  private MobileElement btnBack;

  // todo implement locator
  private MobileElement lblMyProfileHeader;

  private MobileElement lblMyProfileInfo;

  @iOSXCUITFindBy(accessibility = "profile_title")
  private MobileElement lblProfileTitle;

  @iOSXCUITFindBy(accessibility = "profile_name")
  private MobileElement txtProfileName;

  @iOSXCUITFindBy(accessibility = "profile_number")
  private MobileElement txtProfileNumber;

  @iOSXCUITFindBy(accessibility = "profile_email")
  private MobileElement txtProfileEmail;

  @iOSXCUITFindBy(accessibility = "profile_update")
  private MobileElement btnUpdateProfile;

  @iOSXCUITFindBy(accessibility = "profile_logout")
  private MobileElement btnProfileLogout;
}
