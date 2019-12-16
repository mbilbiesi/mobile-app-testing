package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

@Getter
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

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(className = "androidx.appcompat.app.ActionBar$Tab")
    private List<WebElement> menuGroups;

    public RestaurantScreen(AppiumDriver driver) {
        super(driver);
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

    public void swipe(WebElement startElement, WebElement endElement) {
        touchAction.longPress(longPressOptions().withElement(element(startElement))
                .withDuration(Duration.ofMillis(500))).moveTo(element(endElement))
                .release().perform();
    }
}
