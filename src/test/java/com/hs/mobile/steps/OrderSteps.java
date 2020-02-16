package com.hs.mobile.steps;

import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.OrderScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSteps extends BaseSteps {
  private OrderScreen orderScreen;

  public OrderSteps(AppiumDriver driver) {
    super(driver);
    orderScreen = new OrderScreen(driver);
  }

  @Step("Click on 'Help' button")
  public void clickHelp() {
    try {
      tap(orderScreen.getBtnHelp());
    } catch (TestExecutionException e) {
      throw new TestExecutionException("Unable to locate 'Help' button " + e);
    }
  }

  public void navigateBackToAllOrders() {
    tap(orderScreen.getBtnBack());
  }

  public void waitUntilOrderScreenLoaded() {
    wait.until(ExpectedConditions.visibilityOfAllElements(orderScreen.getEleOrderHeader()));
  }

  @Step("Verify that 'Order' screen elements are showing properly")
  public void verifyAllOrderElements() {
    SoftAssertions soft = new SoftAssertions();

    verifyOrderHeaderElements(soft);

    verifyOrderSummaryElements(soft);

    swipe(orderScreen.getLblOrderTotal(), orderScreen.getImgRestaurantLogo());
    verifyCashbackElements(soft);

    navigateBack(1);

    soft.assertAll();
  }

  private void verifyOrderHeaderElements(SoftAssertions soft) {
    if (orderScreen.getImgOrderDetailsIcons().size() == 3) {
      soft.assertThat(orderScreen.getImgOrderDetailsIcons().get(0).isDisplayed())
          .as("Location icon isn't displayed")
          .isTrue();
      soft.assertThat(orderScreen.getImgOrderDetailsIcons().get(1).isDisplayed())
          .as("Order payment method icon isn't displayed")
          .isTrue();
      soft.assertThat(orderScreen.getImgOrderDetailsIcons().get(2).isDisplayed())
          .as("Delivery type icon isn't displayed")
          .isTrue();
    } else {
      soft.assertThat(false).as("Not all order details icons are displayed").isTrue();
    }
    verifyScreenElements(soft);
  }

  private void verifyOrderSummaryElements(SoftAssertions soft) {
    soft.assertThat(orderScreen.getLblOrderItemQuantity().size() > 0)
        .as("Quantity value isn't displayed for all order items")
        .isTrue();
    soft.assertThat(orderScreen.getLblOrderItemsNames().size() > 0)
        .as("Item name isn't displayed for all order items")
        .isTrue();
    soft.assertThat(orderScreen.getLblOrderItemsPrices().size() > 0)
        .as("Price isn't displayed for all order items")
        .isTrue();
    soft.assertThat(orderScreen.getLblOrderItemsCurrency().size() > 0)
        .as("Currency isn't displayed for all order item prices")
        .isTrue();
  }

  private void verifyCashbackElements(SoftAssertions soft) {
    soft.assertThat(orderScreen.getEleCashback().size() > 0)
        .as("Cashback component does not exist")
        .isTrue();
    soft.assertThat(orderScreen.getLblCashbackTitle().size() > 0)
        .as("Cashback component title isn't displayed")
        .isTrue();
    soft.assertThat(orderScreen.getTxaCashbackDescription().size() > 0)
        .as("Cashback description isn't displayed")
        .isTrue();
    soft.assertThat(orderScreen.getEleCashbackCode().size() > 0)
        .as("Cashback code isn't displayed")
        .isTrue();
    soft.assertThat(orderScreen.getBtnCopyCashbackCode().size() > 0)
        .as("Copy Cashback Code button isn't displayed")
        .isTrue();
  }
}
