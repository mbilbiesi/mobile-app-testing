package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static com.hs.mobile.data.ElementAttribute.TEXT;

public class InvoiceScreen extends AbstractScreen {
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_download")
    private WebElement download;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    private WebElement title;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    private WebElement back;

    public InvoiceScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementAttributeValue(title, TEXT);
    }

    public Boolean isDownloadButtonActive() {
        return isElementActive(download);
    }

    public Boolean isBackButtonActive() {
        return isElementActive(back);
    }
}