package com.hs.mobile.screens;

import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

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
