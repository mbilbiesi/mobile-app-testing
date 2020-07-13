package com.hs.mobile.screens;

import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class RestaurantScreen extends AbstractScreen {

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_item_name")
  private List<WebElement> menuItems;

  @iOSXCUITFindBy(accessibility = "Add") // todo:ChangeArabicId
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
  private WebElement addMenuItemButton;

  @iOSXCUITFindBy(accessibility = "View cart") // todo:ChangeArabicId
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
  private WebElement cartButton;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(className = "androidx.appcompat.app.ActionBar$Tab")
  private List<WebElement> menuGroups;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/header_value")
  private WebElement menuGroupHeader;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/header_title")
  private WebElement restaurantTitle;

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/calories_icon")
  private WebElement caloriesIcon;

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tv_calories_total")
  private WebElement caloriesLabel;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']")
  private WebElement firstMenuItem;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_item_name")
  private WebElement firstMenuItemName;

  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_value")
  private WebElement deliveryAmount;

  @iOSXCUITFindBy(accessibility = "View cart") // todo:ChangeArabicId
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/primary_label")
  private WebElement viewCart;

  //  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/pos_button")
  private List<WebElement> btnAcceptOffer;

  public RestaurantScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
