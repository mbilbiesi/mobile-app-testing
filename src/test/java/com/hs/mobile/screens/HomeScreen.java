package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class HomeScreen extends AbstractScreen {

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/main_location_text")
    private MobileElement useMyCurrentLocationText;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/imgloc")
    private MobileElement useMyCurrentLocationImage;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnRestaurants")
    private MobileElement findRestaurantsButton;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/restaurants_item")
    private MobileElement restaurantsItem;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/orders_item")
    private MobileElement ordersItem;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/offers_item")
    private MobileElement offersItem;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/more_item")
    private MobileElement moreItem;

    public HomeScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    public boolean isUseMyCurrentLocationTextDisplayed() {
        return useMyCurrentLocationText.isDisplayed();
    }

    public boolean isUseMyCurrentLocationImageDisplayed() {
        return useMyCurrentLocationImage.isDisplayed();
    }

    public boolean isFindRestaurantsButtonDisplayed() {
        return findRestaurantsButton.isDisplayed();
    }

    public boolean isRestaurantsItemDisplayed() {
        return restaurantsItem.isDisplayed();
    }

    public boolean isOrdersItemDisplayed() {
        return ordersItem.isDisplayed();
    }

    public boolean isOffersItemDisplayed() {
        takeScreenshot();
        return offersItem.isDisplayed();
    }

    public boolean isMoreItemDisplayed() {
        return moreItem.isDisplayed();
    }

    @Step("Find restaurants")
    public void findRestaurants() {
        touchAction.tap(tapOptions().withElement(element(findRestaurantsButton))).perform();
        takeScreenshot();
    }

    public void viewSavedLocations() {
        tap(useMyCurrentLocationText);
    }
}
