package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RestaurantScreen {
    @iOSXCUITFindBy(accessibility = "header_close")
    private MobileElement btnClose;

    @iOSXCUITFindBy(accessibility = "restaurant_name")
    private MobileElement txtRestaurantName;

    @iOSXCUITFindBy(accessibility = "rating_score")
    private MobileElement txtRestaurantRating;


    @iOSXCUITFindBy(accessibility = "kitchen_label")
    private MobileElement lblKitchenType;

    @iOSXCUITFindBy(accessibility = "min_order_value")
    private MobileElement txtMinOrderValue;

    @iOSXCUITFindBy(accessibility = "delivery_fees_value")
    private MobileElement txtDeliveryFee;

    @iOSXCUITFindBy(accessibility = "delivery_eta_value")
    private MobileElement txtEtaDeliveryValue;

    private MobileElement btnFilerMenuItem;


    //todo implement or find a way to make it  unique -
    @iOSXCUITFindBy(accessibility = "menu_item_0")
    private MobileElement txtMenuItem;




}
