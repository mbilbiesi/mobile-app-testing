package com.hs.mobile.steps;

import com.hs.mobile.screens.InvoicesScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.util.Optional;

import static com.hs.mobile.data.ElementAttribute.TEXT;

public class InvoicesScreenSteps extends BaseSteps {
    private InvoicesScreen invoicesScreen;
    private InvoiceScreenSteps invoiceScreenSteps;

    public InvoicesScreenSteps(AppiumDriver driver) {
        super(driver);
        invoicesScreen = new InvoicesScreen(driver);
        invoiceScreenSteps = new InvoiceScreenSteps(driver);
    }

    public String getTitle() {
        return getElementAttributeValue(invoicesScreen.getLblTitle(), TEXT);
    }

    @Step("Verify that basic invoices screen elements are displayed correctly")
    public void verifyInvoicesScreen() {
        SoftAssertions soft = new SoftAssertions();
        String title = getInvoiceTitle();
        boolean isValidTitle = "الفواتير".equals(title) || "Invoices".equals(title);

        soft.assertThat(isValidTitle).as(String.format("Invalid title: [%s]", title)).isTrue();
        soft.assertThat(isBackButtonActive())
                .as("Return button should be displayed and enabled.")
                .isTrue();
        navigateBack(1);
        soft.assertAll();
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
            navigateBack(1);
            throw new AssertionError("Unable to open the invoice to verify its components.");
        }

        SoftAssertions soft = new SoftAssertions();
        InvoiceScreenSteps invoiceScreen = optionalFirstInvoice.get();
        String title = invoiceScreen.getInvoiceTitle();
        boolean isValidTitle = "تفاصيل الفاتورة".equals(title) || "Invoice details".equals(title);

        soft.assertThat(isValidTitle).as(String.format("Invalid title: [%s]", title)).isTrue();
        soft.assertThat(invoiceScreen.isDownloadButtonActive())
                .as("Download button should be active.")
                .isTrue();
        soft.assertThat(invoiceScreen.isBackButtonActive())
                .as("Return button should be active.")
                .isTrue();
        navigateBack(2);
        soft.assertAll();
    }

    @Step("Verify the displayed 'no invoices' message")
    public void verifyDisplayedMessage() {
        String message = getMessage();
        boolean isValidMessage =
                "لا يوجد لديك اي فاتورة حالياً".equals(message)
                        || "There are no invoices to be shown at the moment".equals(message);
        navigateBack(1);
        Assertions.assertThat(isValidMessage)
                .as(String.format("Invalid message: [%s]", message))
                .isTrue();
    }

    private String getInvoiceTitle() {
        return getElementAttributeValue(invoicesScreen.getLblTitle(), TEXT);
    }

    public Boolean isBackButtonActive() {
        return isElementActive(invoicesScreen.getLblTitle());
    }

    public Boolean areThereInvoices() {
        return CollectionUtils.isNotEmpty(invoicesScreen.getLstInvoices());
    }

    public String getMessage() {
        return getElementAttributeValue(invoicesScreen.getLblMessage(), TEXT);
    }

    public Optional<InvoiceScreenSteps> viewInvoice(int index) {
        if (CollectionUtils.isNotEmpty(invoicesScreen.getLstInvoices())
                && index >= 0
                && index < invoicesScreen.getLstInvoices().size()) {
            tap(invoicesScreen.getLstInvoices().get(index));
            return Optional.of(invoiceScreenSteps);
        }
        return Optional.empty();
    }
}
