package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class HomeScreen extends AbstractScreen {

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/main_location_text")
    @AssertElementVisibility
    private MobileElement useMyCurrentLocationText;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/imgloc")
    @AssertElementVisibility
    private MobileElement useMyCurrentLocationImage;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnRestaurants")
    @AssertElementVisibility
    private MobileElement findRestaurantsButton;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/restaurants_item")
    @AssertElementVisibility
    private MobileElement restaurantsItem;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/orders_item")
    @AssertElementVisibility
    private MobileElement ordersItem;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/offers_item")
    @AssertElementVisibility
    private MobileElement offersItem;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/more_item")
    @AssertElementVisibility
    private MobileElement moreItem;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//*[@text='تخطى الإعلان' or @text='TBD']")
    private WebElement lnkSkipPromotion;

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }


    public MobileElement getOrdersItem() {
        return ordersItem;
    }

    public MobileElement getFindRestaurantsButton() {
        return findRestaurantsButton;
    }

    @Step("Find restaurants")
    public void findRestaurants() {
        touchAction.tap(tapOptions().withElement(element(findRestaurantsButton))).perform();
    }

    @Step("View saved locations")
    public void viewSavedLocations() {
        tap(useMyCurrentLocationText);
    }

    @Step("Verify that all Homescreen elements are displayed correctly")
    public void verifyThatAllHomeElementsDisplayed() {
        verifyScreenElements();
    }

    @Step("Click the 'My Orders' button")
    public void clickMyOrdersButton() {
        touchAction.tap(tapOptions().withElement(element(getOrdersItem()))).perform();
    }

    @Step("Click the 'Find Restaurants' button")
    public void clickFindRestaurantsButton() {
        touchAction.tap(tapOptions().withElement(element(getFindRestaurantsButton()))).perform();
    }

    @Step("Click on restaurant icon")
    public void clickOnResturantIcon() {
        touchAction.tap(tapOptions().withElement(element(restaurantsItem))).perform();
    }
}
