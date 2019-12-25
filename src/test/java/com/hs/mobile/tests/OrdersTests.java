package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Smoke Tests")
@Feature("Orders Tests")
@Story("Orders verification cases")
@Listeners(TestListener.class)
public class OrdersTests extends BaseTest {

    @BeforeMethod
    public void beforeEachTest() {
        //Given

    }

    @Issue("HSAP-232")
    public void createOrder_verifyOrderCreated() {
        homeScreenSteps.clickFindRestaurantsButton();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("riyadh");
        locationsScreen.selectItemArea(3);
        locationsScreen.submitAddress();
        locationsScreen.insertAddressDescription("desc");
        locationsScreen.submitAddress();

    }

    @AfterMethod
    public void afterEachTest() {

    }
}