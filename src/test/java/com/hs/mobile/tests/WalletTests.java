package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Feature("Wallet Smoke Test")
@Story("Verify wallet screen elements")
@Issue("HSAP-184")
@Listeners(TestListener.class)
public class WalletTests extends BaseTest {

    @BeforeMethod
    public void goToPaymentOptions() {
        //When
        homeScreen.clickOnMore().goToPaymentOptions();
    }

    @Test(description = "Check wallet screen headers")
    public void verifyWalletScreen() {
        //And
        paymentOptionsScreen.openWallet();
        //Then
        verifyHeaders();
    }

    @Step("Verify that all headers are displayed properly")
    public void verifyHeaders() {
        SoftAssertions assertions = new SoftAssertions();
        List<WebElement> headers = walletScreen.getAllHeaders();
        for (WebElement header : headers) {
            assertions.assertThat(walletScreen.isHeaderActive(header))
                    .as(String.format("%s header should be properly displayed.", walletScreen.getHeaderText(header)))
                    .isTrue();
        }
        driver.navigate().back();
        driver.navigate().back();
        assertions.assertAll();
    }
}
