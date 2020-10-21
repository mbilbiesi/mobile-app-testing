package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.support.CacheLookup;

@Getter
public class RestaurantScreen extends AbstractScreen<RestaurantScreen> {

  @iOSXCUITFindBy(accessibility = "header_close")
  private MobileElement btnClose;

  @iOSXCUITFindBy(accessibility = "header_location")
  private MobileElement headerLocation;

  @iOSXCUITFindBy(accessibility = "restaurant_name")
  private MobileElement txtRestaurantName;

  @iOSXCUITFindBy(accessibility = "rating_score")
  private MobileElement lblRating;

  @iOSXCUITFindBy(accessibility = "rating_icon")
  private MobileElement imgRatingIcon;

  @iOSXCUITFindBy(accessibility = "kitchen_label")
  private MobileElement lblKitchenType;

  @iOSXCUITFindBy(accessibility = "min_order_value")
  private MobileElement txtMinOrderValue;

  @iOSXCUITFindBy(accessibility = "delivery_fees_value")
  private MobileElement txtDeliveryFee;

  @iOSXCUITFindBy(accessibility = "delivery_eta_value")
  private MobileElement txtEtaDeliveryValue;

  @iOSXCUITFindBy(accessibility = "menu_item_0")
  private MobileElement txtMenuItem;

  @CacheLookup
  @iOSXCUITFindBy(accessibility = "restaurant_cell")
  private List<MobileElement> restaurantList;

  public RestaurantScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
