package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class PaymentOptionsScreen extends AbstractScreen {
  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/wallet_recycler_view")
  private WebElement btnWallet;

  //@iOSXCUITFindBy(accessibility = "") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title_payment_method_view")
  private List<WebElement> btnCreditCard;

  //@iOSXCUITFindBy(accessibility = "") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/rl_add_credit_card")
  private WebElement btnAddNewCC;

  //@iOSXCUITFindBy(accessibility = "") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title_payment_method_view")
  private WebElement btnRedeemVoucher;

  public PaymentOptionsScreen(AppiumDriver driver) {
    super(driver);
  }
}
