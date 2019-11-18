package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SavedLocationsScreen extends AbstractScreen {

    public SavedLocationsScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.hungerstation.android.web.debug:id/my_addresses_recycler']/*")
    private List<WebElement> savedLocations;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/add_new_location")
    private WebElement newLocation;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/action_more")
    private WebElement more;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delete_img")
    private WebElement delete;

    public void addNewLocation() {
        tap(newLocation);
    }

    public void deleteSavedLocations() {
        int numberOfLocations = savedLocations.size();
        for (int i = 0; i < numberOfLocations; i++) {
            tap(more);
            tap(delete);
        }
    }

    public List<WebElement> getSavedLocations() {
        return savedLocations;
    }
}
