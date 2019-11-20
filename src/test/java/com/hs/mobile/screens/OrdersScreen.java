package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class OrdersScreen extends AbstractScreen {
    public OrdersScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btnaction")
    private MobileElement btnVerify;

    @iOSXCUITFindBy(className = "")
    @AndroidFindBy(className = "android.view.ViewGroup")
    private List<MobileElement> eleOrders;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_title")
    private List<MobileElement> eleOrderTitles;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_price")
    private List<MobileElement> eleOrderPrice;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/img_order")
    private List<MobileElement> imgRestaurant;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_status")
    private List<MobileElement> eleOrderStatus;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_date")
    private List<MobileElement> eleOrderDate;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/restaurants_item")
    private MobileElement btnRestaurants;

    public MobileElement getBtnRestaurants() {
        return btnRestaurants;
    }

    public boolean isBtnVerifyDisplayed() {
        return btnVerify.isDisplayed();
    }

    public boolean isEleOrdersDisplayed() {
        return eleOrders.size() > 0;
    }

    public boolean isEleOrderTitlesDisplayed() {
        return eleOrderTitles.size() > 0;
    }

    public boolean isEleOrderPriceDisplayed() {
        return eleOrderPrice.size() > 0;
    }

    public boolean isImgRestaurantDisplayed() {
        return imgRestaurant.size() > 0;
    }

    public boolean isEleOrderStatusDisplayed() {
        return eleOrderStatus.size() > 0;
    }

    public boolean isEleOrderDateDisplayed() {
        return eleOrderDate.size() > 0;
    }

    public MobileElement getVerifyButton() {
        return btnVerify;
    }

    public List<MobileElement> getOrdersContainer() {
        return eleOrders;
    }

    public List<MobileElement> getOrderTitles() {
        return eleOrderTitles;
    }

    public List<MobileElement> getOrderPrice() {
        return eleOrderPrice;
    }

    public List<MobileElement> getRestaurantsImages() {
        return imgRestaurant;
    }

    public List<MobileElement> getOrderStatus() {
        return eleOrderStatus;
    }

    public List<MobileElement> getOrderDate() {
        return eleOrderDate;
    }

    @Step("Make sure that \"Verify Mobile Number\" button if customer is not logged in")
    public void verifyThatVerifyMobileButtonIsDisplayed() {
        assertAll(
                () -> assertThat(isBtnVerifyDisplayed())
                        .as("Verify mobile number button is not displayed.").isTrue()
        );
    }

    @Step("Make sure that all orders details are displayed if customer is logged in")
    public void verifyThatAllOrdersElementsIsDisplayed() {
        assertAll(
                () -> assertThat(isEleOrdersDisplayed())
                        .as("Customer orders are not displayed.").isTrue(),
                () -> assertThat(isEleOrderTitlesDisplayed()).as(
                        "Customer order titles are not displayed.").isTrue(),
                () -> assertThat(isEleOrderPriceDisplayed()).as(
                        "Order prices are not displayed.").isTrue(),
                () -> assertThat(isEleOrderStatusDisplayed())
                        .as("Orders statuses are not displayed.").isTrue(),
                () -> assertThat(isEleOrderDateDisplayed())
                        .as("Orders item is not displayed.").isTrue(),
                () -> assertThat(isEleOrderDateDisplayed())
                        .as("Orders dates are not displayed.").isTrue()
        );
    }

    @Step("Click the \"Verify\" button")
    public void clickVerifyButton() {
        touchAction.tap(tapOptions().withElement(element(getVerifyButton()))).perform();
    }

    @Step("Navigate back to Restaurants")
    public void navigateToRestaurants() {
        touchAction.tap(tapOptions().withElement(element(getBtnRestaurants()))).perform();
    }
}