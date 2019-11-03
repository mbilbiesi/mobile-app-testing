package com.hungerstation.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

public class AppActions {

    private AndroidDriver<AndroidElement> driver;
    private WebElement element;

    public AppActions(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public AppActions(WebElement element){
        this.element = element;
    }

    public void scroll(){

    }

    public void touch(){

    }
}
