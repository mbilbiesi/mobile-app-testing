package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.support.CacheLookup;

@Getter
public class MenuItemScreen extends AbstractScreen<MenuItemScreen> {

  @CacheLookup
  @iOSXCUITFindBy(accessibility = "plus_button")
  private MobileElement btnAddMoreItems;

  @iOSXCUITFindBy(accessibility = "add_to_cart_label")
  private MobileElement btnAddToCart;

  @iOSXCUITFindBy(accessibility = "checkout_left_text")
  private MobileElement btnViewCart;

  public MenuItemScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
