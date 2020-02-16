package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class WalletScreen extends AbstractScreen {

  // iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='العمليات' or @text='Transaction']")
  private WebElement transactionHeader;

  // iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='التاريخ' or @text='Date']")
  private WebElement dateHeader;

  // iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='تاريخ الانتهاء' or @text='Expiry Date']")
  private WebElement expiryDateHeader;

  // iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='القيمة' or @text='Amount']")
  private WebElement amountHeader;

  public WalletScreen(AppiumDriver driver) {
    super(driver);
  }
}
