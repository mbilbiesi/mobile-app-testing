package com.hungerstation.screens.updated;

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

public class RestaurantsListScreen extends BaseScreen {
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
    private List<WebElement> restaurantList;

    public RestaurantsListScreen(AndroidDriver<MobileElement> driver, TouchAction touchAction) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.touchAction = touchAction;
    }

    public void selectRestaurant(int index) {
        touchAction.tap(tapOptions().withElement(element(restaurantList.get(index)))).perform();
    }
}
