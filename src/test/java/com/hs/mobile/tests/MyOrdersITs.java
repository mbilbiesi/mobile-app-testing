package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.tests.base.BaseStepsInitiator;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import java.text.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Orders Smoke Test")
@Story("Verify Orders test cases")
@Listeners(TestListener.class)
class MyOrdersITs extends BaseStepsInitiator {

  boolean hasFirstTestExecuted = false;

  @BeforeMethod
  public void beforeEachTest() {
    // Given
    homeScreenSteps.clickMyOrdersButton();
    if (!hasFirstTestExecuted) {
      myOrdersSteps.clickVerifyButton();
      verifyAccountScreenSteps.insertMobileNumber(testUser.getMobileNumber());
      verifyAccountScreenSteps.clickNextButton();
      pinCodeVerificationSteps.insertVerificationCode(testUser.getVerificationCode());
      myOrdersSteps.waitUntilMyOrdersScreenLoaded();

      hasFirstTestExecuted = true;
    }
  }

  @Issue("HSAP-229")
  @Test(description = "Verify that orders are sorted by date from newest to oldest")
  public void navigateToOrders_OrdersShouldBeSortedByDate() throws ParseException {
    // Then
    myOrdersSteps.verifyOrdersSortedByDateDesc("ar");
  }

  @Issue("HSAP-230")
  @Test(description = "Verify that orders are sorted by date from newest to oldest")
  public void navigateToOrder_OrderSummaryShouldDisplayCorrectly() {
    // When
    myOrdersSteps.navigateToOrder("delivered");
    orderSteps.waitUntilOrderScreenLoaded();

    // Then
    orderSteps.verifyAllOrderElements();
  }
}
