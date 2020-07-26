package com.hs.mobile.screens;

import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class OrdersScreen extends AbstractScreen {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btnaction")
  private MobileElement btnVerify;

  @AndroidFindBy(className = "android.view.ViewGroup")
  private List<MobileElement> eleOrders;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_title")
  private List<MobileElement> eleOrderTitles;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_price")
  private List<MobileElement> eleOrderPrice;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/img_order")
  private List<MobileElement> imgRestaurant;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_status")
  private List<MobileElement> eleOrderStatus;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/order_date")
  private List<MobileElement> eleOrderDate;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/restaurants_item")
  private MobileElement btnRestaurants;

  public OrdersScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
