package com.hs.mobile.steps;

import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.MyOrdersScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;

public class MyOrdersSteps {
    private MyOrdersScreen myOrdersScreen;
    private AppiumDriver driver;

    public MyOrdersSteps(AppiumDriver driver) {
        this.driver = driver;
        myOrdersScreen = new MyOrdersScreen(driver);
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
            // ToDo: add all remaining order statuses.. cancelled, etc
            default:
                orders = myOrdersScreen.getEleOrderTitles();
        }

        return orders;
    }

    private void clickOrder(List<MobileElement> orders) {
        try {
            myOrdersScreen.tap(orders.get(0));
        } catch (TestExecutionException e) {
            throw new TestExecutionException("Unable to locate the order which is gonna be clicked " + e);
        }
    }

    private List<MobileElement> getDeliveredOrders() {
        int ordersCount = getOrdersCount();
        String orderStatus;
        List<MobileElement> deliveredOrders = new ArrayList<>();

        for (int i = 0; i < ordersCount; i++) {
            orderStatus = myOrdersScreen.getEleOrderStatus().get(i).getText();
            if (orderStatus.equalsIgnoreCase("delivered") || orderStatus.equals("تم التوصيل")) {
                deliveredOrders.add(myOrdersScreen.getEleOrderTitles().get(i));
            }
        }

        if (deliveredOrders.size() == 0) {
            // There are no delivered orders
            // ToDo: Implement a logging mechanism to inform when there are no delivered orders
            deliveredOrders = myOrdersScreen.getEleOrderTitles();
        }

        return deliveredOrders;
    }

    private List<MobileElement> getOpenOrders() {
        List<MobileElement> openOrders;

        openOrders = myOrdersScreen.getOpenOrderTitle();

        if (openOrders.size() == 0) {
            openOrders = myOrdersScreen.getEleOrders();
        }

        return openOrders;
    }

    private int getOrdersCount() {
        return myOrdersScreen.getEleOrderTitles().size();
    }

    public void waitUntilMyOrdersScreenLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(myOrdersScreen.getEleOrders().get(0)));
    }

    @Step("Click the 'Verify' button")
    public void clickVerifyButton() {
        myOrdersScreen
                .touchAction
                .tap(tapOptions().withElement(element(myOrdersScreen.getVerifyButton())))
                .perform();
    }

    @Step("Navigate back to Restaurants")
    public void navigateToRestaurants() {
        myOrdersScreen.tap(myOrdersScreen.getBtnRestaurants());
    }

    @Step("Verify that orders are sorted by date desc")
    public void verifyOrdersSortedByDateDesc(String locale) throws ParseException {
        List<Date> actualOrderDates;
        List<Date> expectedOrderDates;

        actualOrderDates = getOrdersDates(locale);
        expectedOrderDates = getExpectedOrderDates(actualOrderDates);

        assertThat(actualOrderDates.equals(expectedOrderDates))
                .as("Orders are not sorted from newest to oldest")
                .isTrue();
    }

    private List<Date> getOrdersDates(String locale) throws ParseException {
        int size = myOrdersScreen.getEleOrderDate().size();
        List<Date> orderDates = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            orderDates.add(
                    getDate(myOrdersScreen.getEleOrderDate().get(i).getText().replace(",", ""), locale));
        }

        return orderDates;
    }

    private Date getDate(String date, String locale) throws ParseException {
        SimpleDateFormat formatter;

        if (locale.equalsIgnoreCase("ar")) {
            formatter = new SimpleDateFormat("MMMM d yyyy", Locale.forLanguageTag("ar-SA-nu-arab"));
        } else {
            formatter = new SimpleDateFormat("MMMM d yyyy");
        }

        return formatter.parse(date);
    }

    private List<Date> getExpectedOrderDates(List<Date> orderDates) {
        Collections.sort(orderDates, Collections.reverseOrder());
        return orderDates;
    }
}
