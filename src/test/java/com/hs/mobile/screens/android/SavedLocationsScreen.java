package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class SavedLocationsScreen extends AbstractScreen {

  @AndroidFindBy(
      xpath =
          "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.hungerstation.android.web.debug:id/my_addresses_recycler']/*")
  private List<WebElement> savedLocations;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/add_new_location")
  private WebElement btnAddNewLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/action_more")
  private WebElement more;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_img")
  private WebElement edit;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delete_img")
  private WebElement delete;

  public SavedLocationsScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
