package com.hs.mobile.steps;

import com.hs.mobile.screens.InvoiceScreen;
import io.appium.java_client.AppiumDriver;

import static com.hs.mobile.data.ElementAttribute.TEXT;

public class InvoiceScreenSteps extends InvoiceScreen {

    public InvoiceScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementAttributeValue(getLblTitle(), TEXT);
    }

    public Boolean isDownloadButtonActive() {
        return isElementActive(getBtnDownload());
    }

    public Boolean isBackButtonActive() {
        return isElementActive(getBtnBack());
    }
}
