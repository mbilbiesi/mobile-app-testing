package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import org.openqa.selenium.support.FindBy;

@Getter
@Accessors(fluent = true)
public class OrderAnythingScreen extends AbstractScreen<OrderAnythingScreen> {

  @FindBy(name = "Deliver Anything")
  private MobileElement orderAnythingHeader;

  @iOSXCUITFindBy(accessibility = "shop_from")
  private MobileElement lblShopFrom;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Delivery Fees'`]")
  private MobileElement lblDeliveryFeesOA;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
  private MobileElement btnContinue;

  @iOSXCUITFindBy(iOSNsPredicate = "Makeup")
  private MobileElement txtOrderItem; // todo: add locator

  @iOSXCUITFindBy(iOSNsPredicate = "50-100 SR")
  private MobileElement btnPriceEstimate;

  @iOSXCUITFindBy(iOSNsPredicate = "Place Order")
  private MobileElement btnPlaceOrder;

  @iOSXCUITFindBy(accessibility = "confirmButton")
  private MobileElement btnConfirm;

  public OrderAnythingScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
