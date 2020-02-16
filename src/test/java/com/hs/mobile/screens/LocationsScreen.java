package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
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
}
