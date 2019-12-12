package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.TEXT;
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
    @AndroidFindBy(
            id = "com.hungerstation.android.web.debug:id/places_autocomplete_prediction_primary_text")
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
    @AndroidFindBy(
            xpath =
                    "//android.widget.RadioGroup[@resource-id='com.hungerstation.android.web.debug:id/save_location_radio_group']/*")
    private List<WebElement> locationTypes;

    public LocationsScreen(AppiumDriver driver) {
        super(driver);
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

    @Step("Insert {description} address description")
    public void insertAddressDescription(String description) {
        addressDescriptionTextBox.sendKeys(description);
    }

    @Step("Toggle save for later button")
    public void saveForLater() {
        tap(saveForLaterToggleButton);
    }

    @Step("Select {index} location type")
    public void selectLocationType(int index) {
        tap(locationTypes.get(index));
    }

    @Step("Check if the submit button is enabled")
    public boolean isSubmitButtonEnabled() {
        return Boolean.parseBoolean(getElementAttributeValue(selectAddressButton, ENABLED));
    }

    @Step("Clear description text box")
    public void clearDescription() {
        addressDescriptionTextBox.clear();
    }

    @Step("Get the current address description")
    public String getDescription() {
        return getElementAttributeValue(addressDescriptionTextBox, TEXT);
    }

    @Step("Check if the search button is displayed")
    public boolean isSearchButtonDisplayed() {
        return searchButton.isDisplayed();
    }
}
