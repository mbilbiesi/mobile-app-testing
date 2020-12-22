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
public class RestaurantMenuScreen extends AbstractScreen<RestaurantMenuScreen> {

  @iOSXCUITFindBy(accessibility = "restaurant_name")
  private MobileElement restaurantName;

  @CacheLookup
  @iOSXCUITFindBy(accessibility = "item_name")
  private List<MobileElement> menuItemNameList;

  @iOSXCUITFindBy(accessibility = "header_close")
  private MobileElement btnClose;

  public RestaurantMenuScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
