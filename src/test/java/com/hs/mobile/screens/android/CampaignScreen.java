package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class CampaignScreen extends AbstractScreen<CampaignScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/closeCampaign")
  private MobileElement btnCloseCampaign;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/image_tool_bar_bg")
  private MobileElement campaignScreenBg;

  public CampaignScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
