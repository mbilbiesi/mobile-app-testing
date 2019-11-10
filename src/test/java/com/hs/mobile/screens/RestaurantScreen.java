package com.hs.mobile.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class RestaurantScreen extends AbstractScreen {
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_item_name")
    private List<WebElement> menuItems;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
    private WebElement addMenuItemButton;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
    private WebElement cartButton;

    public RestaurantScreen(AndroidDriver<MobileElement> driver, TouchAction touchAction) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.touchAction = touchAction;
    }

    public void selectMenuItem(int index) {
        touchAction.tap(tapOptions().withElement(element(menuItems.get(index)))).perform();
    }

    public void addMenuItem() {
        touchAction.tap(tapOptions().withElement(element(addMenuItemButton))).perform();
    }

    public void goToCart() {
        touchAction.tap(tapOptions().withElement(element(cartButton))).perform();
    }
}
