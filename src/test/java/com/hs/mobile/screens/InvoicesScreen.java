package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public abstract class InvoicesScreen extends AbstractScreen {

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    private WebElement lblTitle;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    private WebElement btnBack;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@clickable='true']")
    private List<WebElement> lstInvoices;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/no_invoice_message")
    private WebElement lblMessage;

    public InvoicesScreen(AppiumDriver driver) {
        super(driver);
    }
}
