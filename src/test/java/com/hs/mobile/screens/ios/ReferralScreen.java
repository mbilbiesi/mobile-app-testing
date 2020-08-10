package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ReferralScreen {

  //todo implement or find a way to make it  unique -
  private MobileElement btnBack;

  private MobileElement lblReferralCodeHeader;

  @iOSXCUITFindBy(accessibility = "referral_code_title")
  private MobileElement txtReferralCodeTitle;

  @iOSXCUITFindBy(accessibility = "referral_code_value")
  private MobileElement lblReferralCodeValue;


  @iOSXCUITFindBy(accessibility = "referral_code_description")
  private MobileElement txtReferralCodeDescription;

  //todo implement locator
  private MobileElement btnSendCodeViaText;

  //todo implement locator
  private MobileElement btnSendCodeViaWhatsApp;

  //todo implement locator
  private MobileElement btnSendCodeViaMail;

  //todo implement locator
  private MobileElement btnSendCodeViaOthers;

}
