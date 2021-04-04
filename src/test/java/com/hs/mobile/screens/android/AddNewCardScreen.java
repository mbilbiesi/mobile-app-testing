package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class AddNewCardScreen extends AbstractScreen<AddNewCardScreen> {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/label")
  private WebElement lblCreditCardNote;

  public AddNewCardScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
