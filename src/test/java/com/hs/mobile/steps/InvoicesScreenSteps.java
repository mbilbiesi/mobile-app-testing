package com.hs.mobile.steps;

import com.hs.mobile.screens.InvoicesScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.Optional;

import static com.hs.mobile.data.ElementAttribute.TEXT;

public class InvoicesScreenSteps extends InvoicesScreen {

    public InvoicesScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Verify that basic invoices screen elements are displayed correctly")
    public void verifyInvoicesScreen() {
        SoftAssertions assertions = new SoftAssertions();
        String title = getTitle();
        boolean isValidTitle = "الفواتير".equals(title) || "Invoices".equals(title);

        assertions.assertThat(isValidTitle).as(String.format("Invalid title: [%s]", title)).isTrue();
        assertions
                .assertThat(isBackButtonActive())
                .as("Return button should be displayed and enabled.")
                .isTrue();
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Verify that invoices are displayed correctly")
    public void verifyInvoices() {
        if (areThereInvoices()) {
            verifyFirstAvailableInvoice();
        } else {
            verifyDisplayedMessage();
        }
    }

    @Step("Verify the first available invoice")
    public void verifyFirstAvailableInvoice() {
        Optional<InvoiceScreenSteps> optionalFirstInvoice = viewInvoice(0);
        if (optionalFirstInvoice.isEmpty()) {
            driver.navigate().back();
            throw new AssertionError("Unable to open the invoice to verify its components.");
        }

        SoftAssertions assertions = new SoftAssertions();
        InvoiceScreenSteps invoiceScreen = optionalFirstInvoice.get();
        String title = invoiceScreen.getTitle();
        boolean isValidTitle = "تفاصيل الفاتورة".equals(title) || "Invoice details".equals(title);

        assertions.assertThat(isValidTitle).as(String.format("Invalid title: [%s]", title)).isTrue();
        assertions
                .assertThat(invoiceScreen.isDownloadButtonActive())
                .as("Download button should be active.")
                .isTrue();
        assertions
                .assertThat(invoiceScreen.isBackButtonActive())
                .as("Return button should be active.")
                .isTrue();
        driver.navigate().back();
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Verify the displayed \"no invoices\" message")
    public void verifyDisplayedMessage() {
        String message = getMessage();
        boolean isValidMessage =
                "لا يوجد لديك اي فاتورة حالياً".equals(message)
                        || "There are no invoices to be shown at the moment".equals(message);
        driver.navigate().back();
        Assertions.assertThat(isValidMessage)
                .as(String.format("Invalid message: [%s]", message))
                .isTrue();
    }

    private String getTitle() {
        return getElementAttributeValue(getLblTitle(), TEXT);
    }

    private Boolean isBackButtonActive() {
        return isElementActive(getLblTitle());
    }

    private Boolean areThereInvoices() {
        return CollectionUtils.isNotEmpty(getLstInvoices());
    }

    private String getMessage() {
        return getElementAttributeValue(getLblMessage(), TEXT);
    }

    private Optional<InvoiceScreenSteps> viewInvoice(int index) {
        if (CollectionUtils.isNotEmpty(getLstInvoices()) && index >= 0 && index < getLstInvoices().size()) {
            tap(getLstInvoices().get(index));
            return Optional.of(new InvoiceScreenSteps(driver));
        }
        return Optional.empty();
    }
}
