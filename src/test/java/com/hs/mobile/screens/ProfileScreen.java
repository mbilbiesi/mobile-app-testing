package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.TEXT;


public class ProfileScreen extends AbstractScreen {
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    private WebElement title;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_user_name")
    private WebElement number;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_name")
    private WebElement name;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_email")
    private WebElement email;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_update")
    private WebElement update;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_logout")
    private WebElement logout;

    public ProfileScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getElementAttributeValue(title, TEXT);
    }

    public Boolean isNumberEnabled() {
        return number.isEnabled();
    }

    public Boolean isNameActive() {
        return isElementActive(name);
    }

    public Boolean isEmailActive() {
        return isElementActive(email);
    }

    public void insertName(String newName) {
        name.clear();
        name.sendKeys(newName);
    }

    public void insertEmail(String newEmail) {
        email.clear();
        email.sendKeys(newEmail);
    }

    public String getName() {
        return getElementAttributeValue(name, TEXT);
    }

    public String getEmail() {
        return getElementAttributeValue(email, TEXT);
    }

    public void update() {
        tap(update);
    }

    public Boolean isUpdateButtonEnabled() {
        return update.isEnabled();
    }

    public void waitUntilProfileIsUpdated() {
        waitUntilAnElementIsUpdated(update, ENABLED, String.valueOf(false));
    }
}