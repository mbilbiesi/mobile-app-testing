package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Wallet Smoke Test")
@Story("Verify wallet screen elements")
@Issue("HSAP-184")
@Listeners(TestListener.class)
public class WalletTests extends BaseTest {

  @BeforeMethod
  public void goToPaymentOptions() {
    // Given
    homeScreenSteps.clickOnMore().goToPaymentOptions();
  }

  @Test(description = "Check wallet screen headers")
  public void navigateToWalletScreen_headersAreProperlyDisplayed() {
    // When
    paymentOptionsScreen.openWallet();

    // Then
    walletScreenSteps.verifyHeaders();
  }
}
