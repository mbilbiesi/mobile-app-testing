package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

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

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    @Step("Is 'Use my current location'")
    public boolean isUseMyCurrentLocationTextDisplayed() {
        return useMyCurrentLocationText.isDisplayed();
    }

    public boolean isUseMyCurrentLocationImageDisplayed() {
        return useMyCurrentLocationImage.isDisplayed();
    }

    public boolean isFindRestaurantsButtonDisplayed() {
        return findRestaurantsButton.isDisplayed();
    }

    public boolean isRestaurantsIconDisplayed() {
        return restaurantsItem.isDisplayed();
    }

    public boolean isOrdersIconDisplayed() {
        return ordersItem.isDisplayed();
    }

    public boolean isOffersIconDisplayed() {
        return offersItem.isDisplayed();
    }

    public boolean isMoreIconDisplayed() {
        return moreItem.isDisplayed();
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
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(isUseMyCurrentLocationTextDisplayed())
                .as("Use my current location text is not displayed.").isTrue();
        soft.assertThat(isUseMyCurrentLocationImageDisplayed()).as(
                "Use my current location image is not displayed.").isTrue();
        soft.assertThat(isFindRestaurantsButtonDisplayed()).as(
                "Find restaurant button is not displayed.").isTrue();
        soft.assertThat(isRestaurantsIconDisplayed())
                .as("Restaurants icon is not displayed.").isTrue();
        soft.assertThat(isOrdersIconDisplayed())
                .as("Orders icon is not displayed.").isTrue();
        soft.assertThat(isOffersIconDisplayed())
                .as("Offers icon is not displayed.").isTrue();
        soft.assertThat(isMoreIconDisplayed())
                .as("More icon is not displayed.").isTrue();
        soft.assertAll();
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
