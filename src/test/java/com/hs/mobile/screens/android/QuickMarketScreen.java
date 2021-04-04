package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class QuickMarketScreen extends AbstractScreen<QuickMarketScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btnCart")
  private AndroidElement lblCart;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/headerBackButton")
  private AndroidElement btnBack;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/deliveryFee")
  private AndroidElement lblDeliveryFee;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/minimumOrder")
  private AndroidElement lblMinDeliveryFee;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/headerSearchViewHolder")
  private AndroidElement txtSearchHeader;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/bannerImage")
  private AndroidElement lblTopBanner;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/tvTitle")
  private AndroidElement lblCategoriesSection;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btnViewAll")
  private AndroidElement btnViewAllCategories;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/recyclerView")
  private AndroidElement btnSwimlane;

  public QuickMarketScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
