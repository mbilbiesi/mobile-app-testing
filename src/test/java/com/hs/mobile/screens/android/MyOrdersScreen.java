package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class MyOrdersScreen extends AbstractScreen {

  @iOSXCUITFindBy(
      iOSNsPredicate =
          "type == 'XCUIElementTypeOther' AND "
              + "(name CONTAINS 'تسجيل الدخول' OR name CONTAINS 'Login')")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btnaction")
  private MobileElement btnVerify;

  // @iOSXCUITFindBy(className = "")
  @AndroidFindBy(className = "android.view.ViewGroup")
  private List<MobileElement> eleOrders;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_title")
  private List<MobileElement> eleOrderTitles;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_price")
  private List<MobileElement> eleOrderPrice;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/img_order")
  private List<MobileElement> imgRestaurant;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_status")
  private List<MobileElement> eleOrderStatus;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_date")
  private List<MobileElement> eleOrderDate;

  @iOSXCUITFindBy(
      iOSClassChain = "XCUIElementTypeWindow[1]/*/*/XCUIElementTypeTabBar/XCUIElementTypeButton[1]")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/restaurants_item")
  private MobileElement btnRestaurants;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/rest_title")
  private List<MobileElement> openOrderTitle;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_id_status")
  private List<MobileElement> openOrderStatus;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_trackable_status")
  private List<MobileElement> openOrderTrackingStatus;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/rest_img_logo")
  private List<MobileElement> openOrderRestaurantLogo;

  public MyOrdersScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
