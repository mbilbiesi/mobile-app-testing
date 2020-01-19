package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class MenuItemScreen extends AbstractScreen {
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tv_menu_item_title")
    private WebElement title;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    private WebElement caloriesIcon;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tv_calories_total")
    private WebElement caloriesTotal;
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
    private WebElement caloriesLabel;

    public MenuItemScreen(AppiumDriver driver) {
        super(driver);
    }
}
