package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class RestaurantScreen extends AbstractScreen {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_item_name")
  private List<WebElement> menuItems;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
  private WebElement addMenuItemButton;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
  private WebElement cartButton;

  @AndroidFindBy(className = "androidx.appcompat.app.ActionBar$Tab")
  private List<WebElement> menuGroups;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/header_value")
  private WebElement menuGroupHeader;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/header_title")
  private WebElement restaurantTitle;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/calories_icon")
  private WebElement caloriesIcon;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tv_calories_total")
  private WebElement caloriesLabel;

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']")
  private WebElement firstMenuItem;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_item_name")
  private WebElement firstMenuItemName;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_value")
  private WebElement deliveryAmount;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/primary_label")
  private WebElement viewCart;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/pos_button")
  private List<WebElement> btnAcceptOffer;

  public RestaurantScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
