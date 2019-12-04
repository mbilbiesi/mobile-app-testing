package com.hs.mobile.tests;


import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.screens.InvoiceScreen;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Feature("Invoices Smoke Test")
@Story("Verify elements of the invoices screen ")
@Issue("HSAP-182")
@Listeners(TestListener.class)
public class InvoicesTests extends BaseTest {
    @BeforeMethod
    public void goToInvoices() {
        //When
        homeScreen.clickOnMore().goToInvoices();
    }

    @Test(description = "Check invoices screen basic elements")
    public void checkInvoicesScreenBasicElements() {
        //Then
        verifyInvoicesScreen();
    }

    @Test(description = "Check invoices")
    public void checkInvoices() {
        //Then
        verifyInvoices();
    }

    @Step("Verify that basic invoices screen elements are displayed correctly")
    public void verifyInvoicesScreen() {
        SoftAssertions assertions = new SoftAssertions();
        String title = invoicesScreen.getTitle();
        boolean isValidTitle =
                new String("الفواتير".getBytes(), StandardCharsets.UTF_8).equals(title) || "Invoices".equals(title);

        assertions.assertThat(isValidTitle).as(String.format("Invalid title: [%s]", title)).isTrue();
        assertions.assertThat(invoicesScreen.isBackButtonActive())
                .as("Return button should be displayed and enabled.").isTrue();
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Verify that invoices are displayed correctly")
    public void verifyInvoices() {
        if (invoicesScreen.areThereInvoices()) {
            verifyFirstAvailableInvoice();
        } else {
            verifyDisplayedMessage();
        }
    }

    @Step("Verify the first available invoice")
    public void verifyFirstAvailableInvoice() {
        Optional<InvoiceScreen> optionalFirstInvoice = invoicesScreen.viewInvoice(0);
        if (optionalFirstInvoice.isEmpty()) {
            driver.navigate().back();
            throw new AssertionError("Unable to open the invoice to verify its components.");
        }

        SoftAssertions assertions = new SoftAssertions();
        InvoiceScreen invoiceScreen = optionalFirstInvoice.get();
        String title = invoiceScreen.getTitle();
        boolean isValidTitle = new String("تفاصيل الفاتورة".getBytes(), StandardCharsets.UTF_8).equals(title)
                || "There are no invoices to be shown at the moment".equals(title);

        assertions.assertThat(isValidTitle).as(String.format("Invalid title: [%s]", title)).isTrue();
        assertions.assertThat(invoiceScreen.isDownloadButtonActive())
                .as("Download button should be active.").isTrue();
        assertions.assertThat(invoiceScreen.isBackButtonActive())
                .as("Return button should be active.").isTrue();
        driver.navigate().back();
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Verify the displayed \"no invoices\" message")
    public void verifyDisplayedMessage() {
        String message = invoicesScreen.getMessage();
        boolean isValidMessage =
                new String("لا يوجد لديك اي فاتورة حالياً".getBytes(), StandardCharsets.UTF_8).equals(message)
                        || "There are no invoices to be shown at the moment".equals(message);
        driver.navigate().back();
        Assertions.assertThat(isValidMessage).as(String.format("Invalid message: [%s]", message)).isTrue();
    }
}
