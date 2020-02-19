package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class SavedLocationsScreen extends AbstractScreen {

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(
      xpath =
          "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.hungerstation.android.web.debug:id/my_addresses_recycler']/*")
  private List<WebElement> savedLocations;

  @iOSXCUITFindBy(id = "location.new_location_button")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/add_new_location")
  private WebElement btnAddNewLocation;

  // @iOSXCUITFindBy(id = "test") LOGIC IS DIFFERENT IN IOS APP, THEREFORE THIS ELEMENT DOESNT EXIST
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/action_more")
  private WebElement more;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_img")
  private WebElement edit;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delete_img")
  private WebElement delete;

  @iOSXCUITFindBy(accessibility = "Edit") //todo:ChangeArabicId
  private WebElement btnEditIos;

  @iOSXCUITFindBy(accessibility = "Cancel") //todo:ChangeArabicId
  private WebElement btnCancelIos;

  @iOSXCUITFindBy(accessibility = "Done") //todo:ChangeArabicId
  private WebElement btnDoneIos;

  @iOSXCUITFindBy(accessibility = "") //todo:id
  private WebElement btnDeleteLocationIos;

  public SavedLocationsScreen(AppiumDriver driver) {
    super(driver);
  }
}
