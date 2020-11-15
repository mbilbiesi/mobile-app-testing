package com.hs.mobile.screens.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class CampaignScreen extends AbstractScreen<CampaignScreen> {

  @iOSXCUITFindBy(accessibility = "icPopupClose")
  private MobileElement btnCloseCampaign;

  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeImage'")
  private MobileElement campaignScreenBg;

  public CampaignScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
