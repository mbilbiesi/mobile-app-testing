package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class CheckoutScreen extends AbstractScreen {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_order_amount_val")
  private MobileElement orderAmount;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_delivery_amount_val")
  private MobileElement deliveryAmount;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_total_amount_val")
  private MobileElement totalAmount;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/payment_container")
  private MobileElement btnChoosePmtMethod;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_checkout")
  private List<MobileElement> btnSelectPmtMethod;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_checkout")
  private MobileElement btnPlaceOrder;

  public CheckoutScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
