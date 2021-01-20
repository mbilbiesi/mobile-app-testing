package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class OrderAnythingScreen extends AbstractScreen<OrderAnythingScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/pickupLocationLabel")
  private MobileElement lblPickUpLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/deliveryFeeLabel")
  private MobileElement lblDeliveryFee;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/primary_label")
  private MobileElement btnContinue;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/itemDesc")
  private MobileElement txtOrder;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/costRadioOne")
  private MobileElement btnPriceEstimate;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btnPlaceOrder")
  private MobileElement btnPlaceOrder;


  public OrderAnythingScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
