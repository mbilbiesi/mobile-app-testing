package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class PaymentOptionsScreen extends AbstractScreen {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/wallet_recycler_view")
  private WebElement btnWallet;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title_payment_method_view")
  private List<WebElement> btnCreditCard;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/rl_add_credit_card")
  private WebElement btnAddNewCC;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title_payment_method_view")
  private WebElement btnRedeemVoucher;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/cash_item")
  private WebElement btnCashOnDelivery;

  public PaymentOptionsScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
