package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class LandingScreen extends AbstractScreen<LandingScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_label")
  private WebElement lblDelivery;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_value")
  private MobileElement lblDeliveryValue;

  @AndroidFindBy(accessibility = "More")
  private MobileElement btnMore;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/overflow_icon")
  private MobileElement btnMoreAction;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title")
  private List<MobileElement> editDeleteDialog;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/description")
  private List<MobileElement> lstDescription;

  public LandingScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
