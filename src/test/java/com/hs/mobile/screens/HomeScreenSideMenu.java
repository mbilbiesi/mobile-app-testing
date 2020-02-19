package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class HomeScreenSideMenu extends AbstractScreen {
  @iOSXCUITFindBy(accessibility = "Profile")  //todo:ChangeArabicId
  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='2']")
  private WebElement btnProfile;

  @iOSXCUITFindBy(accessibility = "Invoices")  //todo:ChangeArabicId
  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='3']")
  private WebElement btnInvoices;

  @iOSXCUITFindBy(accessibility = "Payment Options") //todo:ChangeArabicId
  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='4']")
  private WebElement btnPaymentOptions;

  @iOSXCUITFindBy(accessibility = "Settings")  //todo:ChangeArabicId
  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='6']")
  private WebElement btnSettings;

  @iOSXCUITFindBy(accessibility = "Referral Code")  //todo:ChangeArabicId
  private WebElement btnReferralCode;

  @iOSXCUITFindBy(accessibility = "Support")  //todo:ChangeArabicId
  private WebElement btnSupport;

//  @iOSXCUITFindBy(accessibility = "") ///todo:id
//  private WebElement btnProfileUpdate;

  @iOSXCUITFindBy(accessibility = "Developer Options")  //todo:ChangeArabicId
  private WebElement btnDeveloperOptions;

  public HomeScreenSideMenu(AppiumDriver driver) {
    super(driver);
  }
}
