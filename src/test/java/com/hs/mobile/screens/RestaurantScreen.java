package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class RestaurantScreen extends AbstractScreen {
    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_item_name")
    private List<WebElement> menuItems;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
    private WebElement addMenuItemButton;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
    private WebElement cartButton;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(className = "androidx.appcompat.app.ActionBar$Tab")
    private List<WebElement> menuGroups;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/header_value")
    private WebElement menuGroupHeader;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/header_title")
    private WebElement restaurantTitle;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/calories_icon")
    private WebElement caloriesIcon;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tv_calories_total")
    private WebElement caloriesLabel;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']")
    private WebElement firstMenuItem;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_item_name")
    private WebElement firstMenuItemName;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_value")
    private WebElement deliveryAmount;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/primary_label")
    private WebElement viewCart;

    public RestaurantScreen(AppiumDriver driver) {
        super(driver);
    }
}
