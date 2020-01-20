package com.hs.mobile.steps;

import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.OrderScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSteps extends OrderScreen {

    public OrderSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Click on 'Help' button")
    public void clickHelp() {
        try {
            tap(getBtnHelp());
        } catch (TestExecutionException e) {
            throw new TestExecutionException("Unable to locate 'Help' button " + e);
        }
    }

    public void navigateBackToAllOrders() {
        tap(getBtnBack());
    }

    public void waitUntilOrderScreenLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getEleOrderHeader()));
    }

    @Step("Verify that 'Order' screen elements are showing properly")
    public void verifyAllOrderElements() {
        SoftAssertions soft = new SoftAssertions();

        verifyOrderHeaderElements(soft);

        verifyOrderSummaryElements(soft);

        swipe(getLblOrderTotal(), getImgRestaurantLogo());
        verifyCashbackElements(soft);

        driver.navigate().back();

        soft.assertAll();
    }

    private void verifyOrderHeaderElements(SoftAssertions soft) {
        if (getImgOrderDetailsIcons().size() == 3) {
            soft.assertThat(getImgOrderDetailsIcons().get(0).isDisplayed())
                    .as("Location icon isn't displayed").isTrue();
            soft.assertThat(getImgOrderDetailsIcons().get(1).isDisplayed())
                    .as("Order payment method icon isn't displayed").isTrue();
            soft.assertThat(getImgOrderDetailsIcons().get(2).isDisplayed())
                    .as("Delivery type icon isn't displayed").isTrue();
        } else {
            soft.assertThat(false)
                    .as("Not all order details icons are displayed").isTrue();
        }
        verifyScreenElements(soft);
    }

    private void verifyOrderSummaryElements(SoftAssertions soft) {
        soft.assertThat(getLblOrderItemQuantity().size() > 0)
                .as("Quantity value isn't displayed for all order items").isTrue();
        soft.assertThat(getLblOrderItemsNames().size() > 0)
                .as("Item name isn't displayed for all order items").isTrue();
        soft.assertThat(getLblOrderItemsPrices().size() > 0)
                .as("Price isn't displayed for all order items").isTrue();
        soft.assertThat(getLblOrderItemsCurrency().size() > 0)
                .as("Currency isn't displayed for all order item prices").isTrue();
    }

    private void verifyCashbackElements(SoftAssertions soft) {
        soft.assertThat(getEleCashback().size() > 0)
                .as("Cashback component does not exist").isTrue();
        soft.assertThat(getLblCashbackTitle().size() > 0)
                .as("Cashback component title isn't displayed").isTrue();
        soft.assertThat(getTxaCashbackDescription().size() > 0)
                .as("Cashback description isn't displayed").isTrue();
        soft.assertThat(getEleCashbackCode().size() > 0)
                .as("Cashback code isn't displayed").isTrue();
        soft.assertThat(getBtnCopyCashbackCode().size() > 0)
                .as("Copy Cashback Code button isn't displayed").isTrue();
    }
}
