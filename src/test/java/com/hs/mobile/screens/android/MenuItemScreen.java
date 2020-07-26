package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class MenuItemScreen extends AbstractScreen {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tv_menu_item_title")
  private WebElement txtTitle;

  @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
  private WebElement caloriesIcon;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tv_calories_total")
  private WebElement caloriesTotal;

  @AndroidFindBy(xpath = "//android.widget.TextView[@index='2']")
  private WebElement caloriesLabel;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/image_plus")
  private MobileElement plus;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/primary_label")
  private MobileElement add;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/secondary_label")
  private MobileElement amount;

  public MenuItemScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
