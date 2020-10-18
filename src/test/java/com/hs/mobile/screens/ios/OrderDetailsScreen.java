package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class OrderDetailsScreen extends AbstractScreen<OrderDetailsScreen> {

  @iOSXCUITFindBy(accessibility = "osv_title")
  private List<MobileElement> statusTitleList;

  @iOSXCUITFindBy(accessibility = "osv_subtitle")
  private List<MobileElement> statusSubTitleList;

  public OrderDetailsScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
