package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.hs.mobile.data.ElementAttribute.TEXT;

public class WalletScreen extends AbstractScreen {
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='العمليات' or @text='Transaction']")
    private WebElement transactionHeader;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='التاريخ' or @text='Date']")
    private WebElement dateHeader;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='تاريخ الانتهاء' or @text='Expiry Date']")
    private WebElement expiryDateHeader;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='القيمة' or @text='Amount']")
    private WebElement amountHeader;

    public WalletScreen(AppiumDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllHeaders() {
        List<WebElement> headers = new ArrayList<>();
        headers.add(transactionHeader);
        headers.add(dateHeader);
        headers.add(expiryDateHeader);
        headers.add(amountHeader);
        return headers;
    }

    public Boolean isHeaderActive(WebElement header) {
        return isElementActive(header);
    }

    public String getHeaderText(WebElement header) {
        return getElementAttributeValue(header, TEXT);
    }
}
