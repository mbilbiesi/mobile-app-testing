package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class InvoiceScreen extends AbstractScreen {

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_download")
  private WebElement btnDownload;

  @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
  private WebElement lblTitle;

  @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
  private WebElement btnBack;

  public InvoiceScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
