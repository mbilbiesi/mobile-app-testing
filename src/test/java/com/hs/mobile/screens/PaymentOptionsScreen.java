package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class PaymentOptionsScreen extends AbstractScreen {

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/wallet_recycler_view")
  private WebElement wallet;

  public PaymentOptionsScreen(AppiumDriver driver) {
    super(driver);
  }
}
