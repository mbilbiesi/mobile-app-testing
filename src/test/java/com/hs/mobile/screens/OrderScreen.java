package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class OrderScreen extends AbstractScreen {

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/header_component")
  private WebElement eleOrderHeader;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/back_button")
  private WebElement btnBack;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/help_button")
  private WebElement btnHelp;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/help_label")
  private WebElement lblHelp;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/logo")
  private MobileElement imgRestaurantLogo;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/rest_name")
  private WebElement lblRestaurantTitle;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon")
  private List<WebElement> imgOrderDetailsIcons;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/label")
  private List<WebElement> txaOrderDetailsDescriptions;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/state_title")
  private WebElement lblOrderStatus;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/state_background")
  private WebElement imgOrderStatusBackground;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/summary_component")
  private WebElement txaOrderSummary;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/summary_title")
  private WebElement lblSummaryTitle;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_number")
  private WebElement lblOrderNumber;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_items_list")
  private WebElement eleOrderItemsList;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/item_count")
  private List<WebElement> lblOrderItemQuantity;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/item_name")
  private List<WebElement> lblOrderItemsNames;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/price")
  private List<WebElement> lblOrderItemsPrices;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/currency")
  private List<WebElement> lblOrderItemsCurrency;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/item_desc")
  private List<WebElement> txaOrderItemsDescriptions;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/sub_total")
  private WebElement lblOrderSubTotal;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fees")
  private WebElement lblOrderDeliveryFees;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/discount")
  private WebElement lblOrderDiscount;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/total")
  private MobileElement lblOrderTotal;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/vat_message")
  private WebElement lblVatMessage;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/cashback_component")
  private List<WebElement> eleCashback;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title")
  private List<WebElement> lblCashbackTitle;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/description")
  private List<WebElement> txaCashbackDescription;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/cashback_value")
  private List<WebElement> eleCashbackCode;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/copy_icon")
  private List<WebElement> btnCopyCashbackCode;

  public OrderScreen(AppiumDriver driver) {
    super(driver);
  }
}
