package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.tests.base.BaseAndroidSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Invoices Smoke Test")
@Story("Verify elements of the invoices screen ")
@Issue("HSAP-182")
@Listeners(TestListener.class)
public class InvoicesITs extends BaseAndroidSteps {

  boolean hasFirstTestExecuted = false;

  @BeforeMethod
  public void goToInvoices() {
    // When
    if (!hasFirstTestExecuted) {
      homeScreenSteps.clickMyOrdersButton();
      myOrdersSteps.clickVerifyButton();
      verifyAccountScreenSteps.insertMobileNumber(testUser.getMobileNumber());
      verifyAccountScreenSteps.clickNextButton();
      pinCodeVerificationSteps.insertVerificationCode(testUser.getVerificationCode());

      hasFirstTestExecuted = true;
    }
    homeScreenSteps.clickOnMore().goToInvoices();
  }

  @Test(description = "Check invoices screen basic elements")
  public void navigateToInvoicesScreen_basicElementsAreProperlyDisplayed() {
    // Then
    invoicesScreenSteps.verifyInvoicesScreen();
  }

  @Test(description = "Check invoices")
  public void navigateToInvoicesScreen_invoicesAreProperlyDisplayed() {
    // Then
    invoicesScreenSteps.verifyInvoices();
  }
}
