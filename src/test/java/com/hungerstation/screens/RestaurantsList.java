package com.hungerstation.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RestaurantsList {
    public RestaurantsList(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
    public List<WebElement> eleRestaurant;

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/value")
    public List<WebElement> labelClosed;
}
