package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class SavedLocationsScreen extends AbstractScreen {

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(
            xpath =
                    "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.hungerstation.android.web.debug:id/my_addresses_recycler']/*")
    private List<WebElement> savedLocations;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/add_new_location")
    private WebElement newLocation;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/action_more")
    private WebElement more;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_img")
    private WebElement edit;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delete_img")
    private WebElement delete;

    public SavedLocationsScreen(AppiumDriver driver) {
        super(driver);
    }
}
