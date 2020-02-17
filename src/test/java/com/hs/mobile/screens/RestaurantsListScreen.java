package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class RestaurantsListScreen extends AbstractScreen {

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_icon")
  @AssertElementVisibility
  private WebElement imgLocationIcon;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_value")
  @AssertElementVisibility
  private WebElement eleLocationValue;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/input")
  @AssertElementVisibility
  private WebElement txtSearchRestaurants;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon_start")
  @AssertElementVisibility
  private WebElement imgSearchIcon;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/viewpager")
  @AssertElementVisibility
  private WebElement eleOffersContainer;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/image")
  @AssertElementVisibility
  private List<WebElement> offerWidgets;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_container")
  @AssertElementVisibility
  private WebElement campaignContainer;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_banner")
  @AssertElementVisibility
  private List<MobileElement> campainBanners;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_component")
  @AssertElementVisibility
  private WebElement filtersWidget;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_filter")
  private List<WebElement> btnFilter;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_name")
  private List<WebElement> filtersNames;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_icon")
  private List<WebElement> filtersIcons;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/RestListView")
  @AssertElementVisibility
  private WebElement restaurantsListWidget;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
  @AssertElementVisibility
  private List<WebElement> restaurantList;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
  @AssertElementVisibility
  private List<WebElement> restaurantWidgets;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title")
  @AssertElementVisibility
  private List<WebElement> restaurantTitle;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/description")
  @AssertElementVisibility
  private List<WebElement> restaurantType;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/distance_value")
  private List<WebElement> restaurantDistance;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_title")
  @AssertElementVisibility
  private List<WebElement> deliveryText;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_value")
  @AssertElementVisibility
  private List<WebElement> deliveryFeeValue;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_currency")
  @AssertElementVisibility
  private List<WebElement> deliveryFeeCurrency;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/label_desc")
  @AssertElementVisibility
  private List<WebElement> restaurantDeliveryInfo;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon")
  @AssertElementVisibility
  private List<WebElement> restaurantDeliveryInfoIcon;

  // @iOSXCUITFindBy(xpath = "//*test")
  @AndroidFindBy(xpath = "//*[@text='يوصى به' or @text='recommended']")
  private List<WebElement> recommendedBadge;

  // @iOSXCUITFindBy(xpath = "//*test")
  @AndroidFindBy(
      xpath =
          "//*[@id='com.hungerstation.android.web.debug:id/value'"
              + " and not(@text='يوصى به' or @text='recommended')]")
  private WebElement branchStatusBadge;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon_end")
  private WebElement btnClearSearchResult;

  // @iOSXCUITFindBy(xpath = "//*test")
  @AndroidFindBy(xpath = "//*[@text='اعلان' or @text='Promoted']")
  private List<WebElement> promotedBadge;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/layout_campaign_tool_bar")
  private WebElement campaignMainImage;

  private String promotedBadgeLocator = "//*[@text='اعلان' or @text='Promoted']";

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_value")
  @AssertElementVisibility
  private List<WebElement> restaurantListLayout;

  public RestaurantsListScreen(AppiumDriver driver) {
    super(driver);
  }
}
