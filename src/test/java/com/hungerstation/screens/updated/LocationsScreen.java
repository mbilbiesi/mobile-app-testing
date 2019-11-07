package com.hungerstation.screens.updated;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class LocationsScreen extends BaseScreen {
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/action_search")
    private WebElement searchButton;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/places_autocomplete_edit_text")
    private WebElement searchTextBox;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/places_autocomplete_prediction_primary_text")
    private List<WebElement> itemAreas;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnAddAddress")
    private WebElement selectAddressButton;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/editDescription")
    private WebElement addressDescriptionTextBox;

    public LocationsScreen(AndroidDriver<MobileElement> driver, TouchAction touchAction) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.touchAction = touchAction;
    }

    public void searchForRestaurants() {
        touchAction.tap(tapOptions().withElement(element(searchButton))).perform();
    }

    public void insertLocation(String text) {
        searchTextBox.sendKeys(text);
    }

    public void selectItemArea(int index) {
        touchAction.tap(tapOptions().withElement(element(itemAreas.get(index)))).perform();
    }

    public void submitAddress() {
        touchAction.tap(tapOptions().withElement(element(selectAddressButton))).perform();
    }

    public void insertAddressDescription(String title) {
        addressDescriptionTextBox.sendKeys(title);
    }
}
