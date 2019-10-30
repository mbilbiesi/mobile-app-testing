package com.hungerstation.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Locations {
    public Locations(AndroidDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/action_search")
    public WebElement btnSearch;

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/places_autocomplete_edit_text")
    public WebElement txtSearch;

    @AndroidFindBy(className = "android.widget.RelativeLayout")
    public List<WebElement> itemAreas;

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnAddAddress")
    public WebElement btnSelectAddress;

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/editDescription")
    public WebElement txtAddressDescription;
}
