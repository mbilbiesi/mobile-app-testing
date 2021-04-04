package com.hs.mobile.tests.android;

import com.hs.mobile.tests.BaseTestSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Payments")
@Story("Check card charge verification while adding new card")
@Issue("HSAP-552")
public class CardVerificationITCase extends BaseTestSteps {

  @Test(description = "Verify payment")
  public void navigateToMoreScreen_verifyCCPayment() {

    // When
    landingScreenSteps.clickOnMore();
    moreScreenSteps.clickOnLogin();

    loginScreenSteps.enterPhoneNumber("501020010");
    loginScreenSteps.clickOnNext();
    loginScreenSteps.enterOtpCode("000000");

    landingScreenSteps.clickOnMore();
    moreScreenSteps.clickOnPaymentOptions();
    paymentOptionsScreenSteps.clickOnAddCC();

    // Then
    addNewCardScreenSteps.verifyCreditCardNote();
  }
}
