package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public abstract class InvoiceScreen extends AbstractScreen {

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_download")
    private WebElement btnDownload;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    private WebElement lblTitle;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    private WebElement btnBack;

    public InvoiceScreen(AppiumDriver driver) {
        super(driver);
    }
}
