package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class AllStoresScreen extends AbstractScreen<AllStoresScreen> {

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

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_name")
  private List<AndroidElement> lstFilters;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/input_csc")
  private MobileElement searchBar;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_banner")
  private List<MobileElement> campaignBannerList;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon_start_csc")
  private MobileElement btnSearchIcon;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/primary_label")
  private AndroidElement btnTryOrderAnything;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title")
  private AndroidElement lblSearchResults;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/promotion_container")
  private AndroidElement btnTopPromotedStore;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/horizontal_scroll")
  private AndroidElement btnSwimLaneStore;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
  private AndroidElement btnFirstStore;

  public AllStoresScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
