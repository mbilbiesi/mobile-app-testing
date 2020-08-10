package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class WalletScreen extends AbstractScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='العمليات' or @text='Transaction']")
  private WebElement transactionHeader;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='التاريخ' or @text='Date']")
  private WebElement dateHeader;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='تاريخ الانتهاء' or @text='Expiry Date']")
  private WebElement expiryDateHeader;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='القيمة' or @text='Amount']")
  private WebElement amountHeader;

  public WalletScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
