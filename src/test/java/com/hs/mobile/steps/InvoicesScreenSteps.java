package com.hs.mobile.steps;

import com.hs.mobile.screens.InvoicesScreen;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Optional;

import static com.hs.mobile.data.ElementAttribute.TEXT;

public class InvoicesScreenSteps extends InvoicesScreen {

    public InvoicesScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementAttributeValue(getLblTitle(), TEXT);
    }

    public Boolean isBackButtonActive() {
        return isElementActive(getLblTitle());
    }

    public Boolean areThereInvoices() {
        return CollectionUtils.isNotEmpty(getLstInvoices());
    }

    public String getMessage() {
        return getElementAttributeValue(getLblMessage(), TEXT);
    }

    public Optional<InvoiceScreenSteps> viewInvoice(int index) {
        if (CollectionUtils.isNotEmpty(getLstInvoices()) && index >= 0 && index < getLstInvoices().size()) {
            tap(getLstInvoices().get(index));
            return Optional.of(new InvoiceScreenSteps(driver));
        }
        return Optional.empty();
    }
}
