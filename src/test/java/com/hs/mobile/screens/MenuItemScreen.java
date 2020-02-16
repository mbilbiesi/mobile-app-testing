package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class MenuItemScreen extends AbstractScreen {
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tv_menu_item_title")
  private WebElement title;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
  private WebElement caloriesIcon;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tv_calories_total")
  private WebElement caloriesTotal;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
  private WebElement caloriesLabel;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/image_plus")
  private MobileElement plus;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/primary_label")
  private MobileElement add;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/secondary_label")
  private MobileElement amount;

  public MenuItemScreen(AppiumDriver driver) {
    super(driver);
  }
}
