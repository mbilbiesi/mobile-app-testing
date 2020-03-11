package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

import java.util.List;

@Getter
public class CheckoutScreen extends AbstractScreen {

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_order_amount_val")
  private MobileElement orderAmount;

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_delivery_amount_val")
  private MobileElement deliveryAmount;

  //@iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_total_amount_val")
  private MobileElement totalAmount;

  @iOSXCUITFindBy(accessibility = "Choose New") //todo:ChangeArabicId
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/payment_container")
  private MobileElement btnChoosePmtMethod;

  @iOSXCUITFindBy(accessibility = "Select Payment Method")  //todo:ChangeArabicId
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_checkout")
  private List<MobileElement> btnSelectPmtMethod;

  @iOSXCUITFindBy(accessibility = "Place Order")  //todo:ChangeArabicId
  //todo:This button's locator has to have the same locator as btnSelectPmtMethod button
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_checkout")
  private MobileElement btnPlaceOrder;

  public CheckoutScreen(AppiumDriver driver) {
    super(driver);
  }
}
