package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class InvoicesScreen extends AbstractScreen {

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
  private WebElement lblTitle;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
  private WebElement btnBack;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@clickable='true']")
  private List<WebElement> lstInvoices;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/no_invoice_message")
  private WebElement lblMessage;

  public InvoicesScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
