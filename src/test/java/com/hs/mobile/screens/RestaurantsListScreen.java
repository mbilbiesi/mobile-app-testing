package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class RestaurantsListScreen extends AbstractScreen {

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
    private List<WebElement> restaurantList;

    public RestaurantsListScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    public void selectRestaurant(int index) {
        touchAction.tap(tapOptions().withElement(element(restaurantList.get(index)))).perform();
    }
}
