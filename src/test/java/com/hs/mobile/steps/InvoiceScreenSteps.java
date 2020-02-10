package com.hs.mobile.steps;

import com.hs.mobile.screens.InvoiceScreen;
import io.appium.java_client.AppiumDriver;

import static com.hs.mobile.data.ElementAttribute.TEXT;

public class InvoiceScreenSteps {
    private InvoiceScreen invoiceScreen;

    public InvoiceScreenSteps(AppiumDriver driver) {
        invoiceScreen = new InvoiceScreen(driver);
    }

    public String getInvoiceTitle() {
        return invoiceScreen.getElementAttributeValue(invoiceScreen.getLblTitle(), TEXT);
    }

    public Boolean isDownloadButtonActive() {
        return invoiceScreen.isElementActive(invoiceScreen.getBtnDownload());
    }

    public Boolean isBackButtonActive() {
        return invoiceScreen.isElementActive(invoiceScreen.getBtnBack());
    }
}
