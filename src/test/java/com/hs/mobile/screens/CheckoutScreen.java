package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

@Getter
public class CheckoutScreen extends AbstractScreen {

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_order_amount_val")
  private MobileElement orderAmount;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_delivery_amount_val")
  private MobileElement deliveryAmount;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_total_amount_val")
  private MobileElement totalAmount;

  public CheckoutScreen(AppiumDriver driver) {
    super(driver);
  }
}
