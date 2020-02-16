package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class HomeScreenSideMenu extends AbstractScreen {
  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='2']")
  private WebElement profile;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='3']")
  private WebElement invoices;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='4']")
  private WebElement paymentOptions;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@index='6']")
  private WebElement settings;

  public HomeScreenSideMenu(AppiumDriver driver) {
    super(driver);
  }
}
