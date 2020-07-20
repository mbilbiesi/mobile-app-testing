package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class OrderScreen extends AbstractScreen {

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/header_component")
  private WebElement eleOrderHeader;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/back_button")
  private WebElement btnBack;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/help_button")
  private WebElement btnHelp;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/help_label")
  private WebElement lblHelp;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/logo")
  private MobileElement imgRestaurantLogo;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/rest_name")
  private WebElement lblRestaurantTitle;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon")
  private List<WebElement> imgOrderDetailsIcons;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/label")
  private List<WebElement> txaOrderDetailsDescriptions;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/state_title")
  private WebElement lblOrderStatus;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/state_background")
  private WebElement imgOrderStatusBackground;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/summary_component")
  private WebElement txaOrderSummary;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/summary_title")
  private WebElement lblSummaryTitle;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_number")
  private WebElement lblOrderNumber;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_items_list")
  private WebElement eleOrderItemsList;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/item_count")
  private List<WebElement> lblOrderItemQuantity;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/item_name")
  private List<WebElement> lblOrderItemsNames;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/price")
  private List<WebElement> lblOrderItemsPrices;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/currency")
  private List<WebElement> lblOrderItemsCurrency;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/item_desc")
  private List<WebElement> txaOrderItemsDescriptions;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/sub_total")
  private WebElement lblOrderSubTotal;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fees")
  private WebElement lblOrderDeliveryFees;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/discount")
  private WebElement lblOrderDiscount;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/total")
  private MobileElement lblOrderTotal;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/vat_message")
  private WebElement lblVatMessage;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/cashback_component")
  private List<WebElement> eleCashback;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title")
  private List<WebElement> lblCashbackTitle;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/description")
  private List<WebElement> txaCashbackDescription;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/cashback_value")
  private List<WebElement> eleCashbackCode;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/copy_icon")
  private List<WebElement> btnCopyCashbackCode;

  public OrderScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
