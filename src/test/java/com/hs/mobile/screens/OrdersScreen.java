package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

import java.util.List;

@Getter
public class OrdersScreen extends AbstractScreen {

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

    public OrdersScreen(AppiumDriver driver) {
        super(driver);
    }
}
