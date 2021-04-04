package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class VerticalsScreen extends AbstractScreen<VerticalsScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/ic_location")
  private MobileElement imgPin;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_label")
  private MobileElement lblDeliverTo;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_value")
  private MobileElement txtDeliveryValue;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/ic_dropdown")
  private MobileElement imgArrowDown;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/banner_image")
  private List<MobileElement> verticals;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/new_location_clickable_view")
  private AndroidElement btnNewLocation;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/gradient_overlay")
  private AndroidElement btnAllStoresVertical;

  @AndroidFindBy(xpath = "//android.widget.Button[@text='Fast Food']")
  private AndroidElement filter;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Groceries\")")
  private AndroidElement btnGroceriesVertical;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Restaurants\")")
  private AndroidElement btnAllRestaurants;

  public VerticalsScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
