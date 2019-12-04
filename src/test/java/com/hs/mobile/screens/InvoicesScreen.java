package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static com.hs.mobile.data.ElementAttribute.TEXT;


public class InvoicesScreen extends AbstractScreen {
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    private WebElement title;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    private WebElement back;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@clickable='true']")
    private List<WebElement> invoices;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/no_invoice_message")
    private WebElement message;

    public InvoicesScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementAttributeValue(title, TEXT);
    }

    public Boolean isBackButtonActive() {
        return isElementActive(back);
    }

    public Boolean areThereInvoices() {
        return CollectionUtils.isNotEmpty(invoices);
    }

    public String getMessage() {
        return getElementAttributeValue(message, TEXT);
    }

    public Optional<InvoiceScreen> viewInvoice(int index) {
        if (CollectionUtils.isNotEmpty(invoices) && index >= 0 && index < invoices.size()) {
            tap(invoices.get(index));
            return Optional.of(new InvoiceScreen(driver));
        }
        return Optional.empty();
    }
}