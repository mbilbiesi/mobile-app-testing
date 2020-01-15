package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class OrderScreen extends AbstractScreen {

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/header_component")
    private WebElement eleOrderHeader;

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/back_button")
    private WebElement btnBack;

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/help_button")
    private WebElement btnHelp;

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/help_label")
    private WebElement lblHelp;

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/logo")
    private WebElement imgRestaurantLogo;

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/rest_name")
    private WebElement lblRestaurantTitle;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon")
    private List<WebElement> imgOrderDetailsIcons;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/label")
    private List<WebElement> txaOrderDetailsDescriptions;

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/state_title")
    private WebElement lblOrderStatus;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/state_background")
    private WebElement imgOrderStatusBackground;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/summary_component")
    private WebElement txaOrderSummary;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/summary_title")
    private WebElement lblSummaryTitle;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_number")
    private WebElement lblOrderNumber;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_items_list")
    private WebElement eleOrderItemsList;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/item_count")
    private List<WebElement> lblOrderItemQuantity;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/item_name")
    private List<WebElement> lblOrderItemsNames;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/price")
    private List<WebElement> lblOrderItemsPrices;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/currency")
    private List<WebElement> lblOrderItemsCurrency;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/item_desc")
    private List<WebElement> txaOrderItemsDescriptions;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/sub_total")
    private WebElement lblOrderSubTotal;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fees")
    private WebElement lblOrderDeliveryFees;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/discount")
    private WebElement lblOrderDiscount;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/total")
    private WebElement lblOrderTotal;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/vat_message")
    private WebElement lblVatMessage;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/cashback_component")
    private WebElement eleCashback;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title")
    private WebElement lblCashbackTitle;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/description")
    private WebElement txaCashbackDescription;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/cashback_value")
    private WebElement eleCashbackCode;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/copy_icon")
    private WebElement btnCopyCashbackCode;

    public OrderScreen(AppiumDriver driver) {
        super(driver);
    }
}
