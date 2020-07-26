package com.hs.mobile.screens.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RestaurantScreen {
    @iOSXCUITFindBy(accessibility = "header_close")
    private MobileElement ClickableCloseBtn;

    @iOSXCUITFindBy(accessibility = "restaurant_name")
    private MobileElement restaurantNameTxt;

    @iOSXCUITFindBy(accessibility = "rating_score")
    private MobileElement restaurantRatingTxt;

    @iOSXCUITFindBy(accessibility = "kitchen_label")
    private MobileElement kitchenTypeTxt;

    //todo implement or find a way to make it  unique -
    private MobileElement menuText;


}
