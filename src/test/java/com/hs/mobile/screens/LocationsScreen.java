package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/save_location_switch")
    private WebElement saveForLaterToggleButton;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(xpath = "//android.widget.RadioGroup[@resource-id='com.hungerstation.android.web.debug:id/save_location_radio_group']/*")
    private List<WebElement> locationTypes;

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

    public void insertAddressDescription(String description) {
        addressDescriptionTextBox.sendKeys(description);
    }

    public void saveForLater() {
        tap(saveForLaterToggleButton);
    }

    public void selectLocationType(int index) {
        tap(locationTypes.get(index));
    }

    public boolean isSubmitButtonEnabled() {
        String enabled = selectAddressButton.getAttribute("enabled");
        return "true".equals(enabled);
    }

    public void clearDescription() {
        addressDescriptionTextBox.clear();
    }

    public String getDescription() {
        return addressDescriptionTextBox.getAttribute("text");
    }

    public boolean isSearchButtonDisplayed() {
        return searchButton.isDisplayed();
    }
}
