package com.hs.mobile.steps;

import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.MyOrdersScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersSteps extends MyOrdersScreen {

    public MyOrdersSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Click on order")
    public void clickOrder(String orderStatus) {
        List<MobileElement> orders;

        if (orderStatus.equalsIgnoreCase("delivered")) {
            orders = getDeliveredOrders();
        } else {
            // ToDo: add code for different order statuses
            orders = getEleOrderTitles();
        }

        try {
            tap(orders.get(0));
        } catch (TestExecutionException e) {
            e.printStackTrace();
        }
    }

    public List<MobileElement> getDeliveredOrders() {
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
            // There are no delivered orders
            // ToDo: Implement a logging mechanism to inform when there are no delivered orders
            deliveredOrders = getEleOrderTitles();
        }

        return deliveredOrders;
    }

    public int getOrdersCount() {
        return getEleOrderTitles().size();
    }

    public void waitUntilMyOrdersScreenLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getEleOrders().get(0)));
    }
}
