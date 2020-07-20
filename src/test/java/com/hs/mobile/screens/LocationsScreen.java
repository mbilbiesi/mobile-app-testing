package com.hs.mobile.screens;

import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class LocationsScreen extends AbstractScreen {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/action_search")
  private WebElement searchButton;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/places_autocomplete_search_bar")
  private WebElement searchTextBox;

  @AndroidFindBy(
      id = "com.hungerstation.android.web.debug:id/places_autocomplete_prediction_primary_text")
  private List<WebElement> itemAreas;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/BtnAddAddress")
  private WebElement selectAddressButton;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/editDescription")
  private WebElement addressDescriptionTextBox;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/save_location_switch")
  private WebElement saveForLaterToggleButton;

  @AndroidFindBy(
      xpath =
          "//android.widget.RadioGroup[@resource-id='com.hungerstation.android.web.debug:id/save_location_radio_group']/*")
  private List<WebElement> locationTypes;

  public LocationsScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
