package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

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

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/phone_number")
  private MobileElement txtPhoneNumber;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/input_edit")
  private MobileElement txtCvvCode;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/continue_button")
  private MobileElement btnContinue;

  @AndroidFindBy(className = "android.widget.EditText")
  private WebElement txtCheckoutViaSimulator;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/primary_label")
  private MobileElement btnDone;

  @AndroidFindBy(className = "android.widget.Button")
  private WebElement btnContinueViaSimulator;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_number")
  private MobileElement lblOrderNumber;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/primary_label")
  private MobileElement btnContinueToFailedPaymentScreen;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/payment_button")
  private MobileElement btnChangePayment;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/productSuggestions")
  private MobileElement lblCrossSellSection;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_item_price")
  private MobileElement lblTotalPrice;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_item_name")
  private MobileElement lblItemName;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_item_quantity")
  private MobileElement lblItemQuantity;

  public CheckoutScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
