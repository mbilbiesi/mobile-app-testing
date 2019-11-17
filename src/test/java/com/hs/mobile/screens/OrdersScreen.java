package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class OrdersScreen extends AbstractScreen {
    public OrdersScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btnaction")
    private MobileElement btnVerify;

    @iOSXCUITFindBy(className = "")
    @AndroidFindBy(className = "android.view.ViewGroup")
    private List<MobileElement> eleOrders;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_title")
    private List<MobileElement> eleOrderTitles;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_price")
    private List<MobileElement> eleOrderPrice;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/img_order")
    private List<MobileElement> imgRestaurant;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_status")
    private List<MobileElement> eleOrderStatus;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_date")
    private List<MobileElement> eleOrderDate;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/restaurants_item")
    private MobileElement btnRestaurants;

    public MobileElement getBtnRestaurants() {
        return btnRestaurants;
    }

    public boolean isBtnVerifyDisplayed() {
        return btnVerify.isDisplayed();
    }

    public boolean isEleOrdersDisplayed() {
        return eleOrders.size() > 0;
    }

    public boolean isEleOrderTitlesDisplayed() {
        return eleOrderTitles.size() > 0;
    }

    public boolean isEleOrderPriceDisplayed() {
        return eleOrderPrice.size() > 0;
    }

    public boolean isImgRestaurantDisplayed() {
        return imgRestaurant.size() > 0;
    }

    public boolean isEleOrderStatusDisplayed() {
        return eleOrderStatus.size() > 0;
    }

    public boolean isEleOrderDateDisplayed() {
        return eleOrderDate.size() > 0;
    }

    public MobileElement getBtnVerify() {
        return btnVerify;
    }

    public List<MobileElement> getEleOrders() {
        return eleOrders;
    }

    public List<MobileElement> getEleOrderTitles() {
        return eleOrderTitles;
    }

    public List<MobileElement> getEleOrderPrice() {
        return eleOrderPrice;
    }

    public List<MobileElement> getImgRestaurant() {
        return imgRestaurant;
    }

    public List<MobileElement> getEleOrderStatus() {
        return eleOrderStatus;
    }

    public List<MobileElement> getEleOrderDate() {
        return eleOrderDate;
    }
}
