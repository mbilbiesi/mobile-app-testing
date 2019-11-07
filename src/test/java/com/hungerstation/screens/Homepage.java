package com.hungerstation.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Getter
public class Homepage {

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnRestaurants")
    public WebElement btnSearchForRestaurants;

    // TODO: 11/4/2019 add iOS locators.
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/main_location_text")
    private MobileElement useMyCurrentLocationText;

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/imgloc")
    private MobileElement useMyCurrentLocationImage;

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/restaurants_item")
    private MobileElement restaurantsItem;

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/orders_item")
    private MobileElement ordersItem;

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/offers_item")
    private MobileElement offersItem;

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/more_item")
    private MobileElement moreItem;

    public Homepage(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
