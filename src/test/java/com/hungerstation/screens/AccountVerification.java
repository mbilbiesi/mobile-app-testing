package com.hungerstation.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountVerification {

    public AccountVerification(AndroidDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/phone_number")
    public WebElement txtPhoneNumber;

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_login")
    public WebElement btnNext;
}
