package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class LocationsScreen extends AbstractScreen {
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

    public LocationsScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    @Step("search for restaurants")
    public void searchForRestaurants() {
        touchAction.tap(tapOptions().withElement(element(searchButton))).perform();
    }

    @Step("insert {text} location")
    public void insertLocation(String text) {
        searchTextBox.sendKeys(text);
    }

    @Step("select {index} area")
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