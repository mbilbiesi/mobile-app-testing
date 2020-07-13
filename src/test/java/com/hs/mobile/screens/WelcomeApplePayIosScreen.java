package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class WelcomeApplePayIosScreen extends AbstractScreen {

  @iOSXCUITFindBy(iOSClassChain = "XCUIElementTypeWindow/*/*/*/XCUIElementTypeButton[1]") // todo:id
  @AssertElementVisibility
  private MobileElement btnProceedWithApplePay;

  @iOSXCUITFindBy(iOSClassChain = "XCUIElementTypeWindow/*/*/*/XCUIElementTypeButton[2]") // todo:id
  @AssertElementVisibility
  private MobileElement btnSkipApplePay;

  public WelcomeApplePayIosScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
