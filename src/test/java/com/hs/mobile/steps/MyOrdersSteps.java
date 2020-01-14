package com.hs.mobile.steps;

import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.MyOrdersScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class MyOrdersSteps extends MyOrdersScreen {

    public MyOrdersSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Select an order, and click it")
    public void navigateToOrder(String orderStatus) {
        List<MobileElement> orders;

        orders = fetchOrder(orderStatus);
        clickOrder(orders);
    }

    private List<MobileElement> fetchOrder(String orderStatus) {
        List<MobileElement> orders;

        switch (orderStatus) {
            case "delivered":
                orders = getDeliveredOrders();
                break;
            case "in progress":
                orders = getOpenOrders();
                break;
            //ToDo: add all remaining order statuses.. cancelled, etc
            default:
                orders = getEleOrderTitles();
        }

        return orders;
    }

    private void clickOrder(List<MobileElement> orders) {
        try {
            tap(orders.get(0));
        } catch (TestExecutionException e) {
            throw new TestExecutionException("Unable to locate the order which is gonna be clicked " + e);
        }
    }

    private List<MobileElement> getDeliveredOrders() {
        int ordersCount = getOrdersCount();
        String orderStatus;
        List<MobileElement> deliveredOrders = new ArrayList<>();

        for (int i = 0; i < ordersCount; i++) {
            orderStatus = getEleOrderStatus().get(i).getText();
            if (orderStatus.equalsIgnoreCase("delivered") || orderStatus.equals("تم التوصيل")) {
                deliveredOrders.add(getEleOrderTitles().get(i));
            }
        }

        if (deliveredOrders.size() == 0) {
            //There are no delivered orders
            //ToDo: Implement a logging mechanism to inform when there are no delivered orders
            deliveredOrders = getEleOrderTitles();
        }

        return deliveredOrders;
    }

    private List<MobileElement> getOpenOrders() {
        List<MobileElement> openOrders;

        openOrders = getOpenOrderTitle();

        if (openOrders.size() == 0) {
            openOrders = getEleOrders();
        }

        return openOrders;
    }

    private int getOrdersCount() {
        return getEleOrderTitles().size();
    }

    public void waitUntilMyOrdersScreenLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getEleOrders().get(0)));
    }

    @Step("Click the 'Verify' button")
    public void clickVerifyButton() {
        touchAction.tap(tapOptions().withElement(element(getVerifyButton()))).perform();
    }

    @Step("Navigate back to Restaurants")
    public void navigateToRestaurants() {
        tap(getBtnRestaurants());
    }

    @Step("Verify that orders are sorted by date desc")
    public void verifyOrdersSortedByDateDesc() {

        LocalDate orderDate;
    }

    private LocalDate getOrderDate(String date, String locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM uuuu", new Locale(locale));
        LocalDate orderDate = LocalDate.parse(date, formatter);
        return orderDate;
    }
}
