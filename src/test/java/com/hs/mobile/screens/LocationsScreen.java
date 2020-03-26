package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class LocationsScreen extends AbstractScreen {
  @iOSXCUITFindBy(accessibility = "Search")  //todo:ChangeArabicId
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/action_search")
  private WebElement searchButton;

  @iOSXCUITFindBy(accessibility = "Close") //todo:ChangeArabicId
  private WebElement btnClose;

  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText'") //todo:id
//  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/places_autocomplete_edit_text")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/places_autocomplete_search_bar")
  private WebElement searchTextBox;

  @iOSXCUITFindBy(iOSClassChain = "XCUIElementTypeWindow[1]/*/*/*/*/*/*/*/XCUIElementTypeTable/XCUIElementTypeCell")
  //todo:id
  @AndroidFindBy(
      id = "com.hungerstation.android.web.debug:id/places_autocomplete_prediction_primary_text")
  private List<WebElement> itemAreas;

  @iOSXCUITFindBy(accessibility = "location.select_button")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnAddAddress")
  private WebElement selectAddressButton;

  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextView'") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/editDescription")
  private WebElement addressDescriptionTextBox;

  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSwitch'") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/save_location_switch")
  private WebElement saveForLaterToggleButton;

  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell'") //todo:id
  @AndroidFindBy(
      xpath =
          "//android.widget.RadioGroup[@resource-id='com.hungerstation.android.web.debug:id/save_location_radio_group']/*")
  private List<WebElement> locationTypes;

  public LocationsScreen(AppiumDriver driver) {
    super(driver);
  }
}
