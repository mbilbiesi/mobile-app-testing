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

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/close_icon")
  private MobileElement btnClose;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tv_calories_total")
  private MobileElement lblCalories;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/search_icon")
  private MobileElement btnMenuSearchIcon;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/input")
  private MobileElement txtSearchMenuInput;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/search_recycler")
  private MobileElement lblFirstItemInSearchResult;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/image_plus")
  private MobileElement btnAddMoreItems;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_add_to_cart")
  private MobileElement btnAddToCart;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/checkout_btn")
  private MobileElement btnViewCart;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/back_button")
  private MobileElement btnCancelSearchResult;

  public MenuItemScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
