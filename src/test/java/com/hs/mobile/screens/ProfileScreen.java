package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class ProfileScreen extends AbstractScreen {

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
  private WebElement title;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_user_name")
  private WebElement number;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_name")
  private WebElement name;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_email")
  private WebElement email;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_update")
  private WebElement update;

  // @iOSXCUITFindBy(id = "test")
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_logout")
  private WebElement logout;

  public ProfileScreen(AppiumDriver driver) {
    super(driver);
  }
}
