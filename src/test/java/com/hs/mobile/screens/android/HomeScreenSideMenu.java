package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class HomeScreenSideMenu extends AbstractScreen {

  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='2']")
  private WebElement btnProfile;

  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='3']")
  private WebElement btnInvoices;

  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='4']")
  private WebElement btnPaymentOptions;

  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='6']")
  private WebElement btnSettings;

  public HomeScreenSideMenu(@NonNull TestSettings settings) {
    super(settings);
  }
}
