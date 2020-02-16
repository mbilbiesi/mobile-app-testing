package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

@Getter
public class WelcomeApplePayIosScreen extends AbstractScreen {

  @iOSXCUITFindBy(iOSClassChain = "XCUIElementTypeWindow/*/*/*/XCUIElementTypeButton[1]")
  @AssertElementVisibility
  private MobileElement btnProceedWithApplePay;

  @iOSXCUITFindBy(iOSClassChain = "XCUIElementTypeWindow/*/*/*/XCUIElementTypeButton[2]")
  @AssertElementVisibility
  private MobileElement btnSkipApplePay;

  public WelcomeApplePayIosScreen(AppiumDriver driver) {
    super(driver);
  }
}
