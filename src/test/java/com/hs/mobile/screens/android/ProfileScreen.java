package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class ProfileScreen extends AbstractScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
  private WebElement title;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_user_name")
  private WebElement number;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_name")
  private WebElement name;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_email")
  private WebElement email;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_update")
  private WebElement update;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_logout")
  private WebElement logout;

  public ProfileScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
