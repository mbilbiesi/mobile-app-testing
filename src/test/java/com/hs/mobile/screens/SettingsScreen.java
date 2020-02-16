package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class SettingsScreen extends AbstractScreen {

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
  private WebElement title;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
  private WebElement back;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='1']")
  private WebElement language;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "android:id/text1")
  private List<WebElement> languages;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@index='0']")
  private WebElement english;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@index='1']")
  private WebElement arabic;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "android:id/button2")
  private WebElement cancel;

  @iOSXCUITFindBy(id = "")
  @AndroidFindBy(id = "android:id/checkbox")
  private WebElement notifications;

  public SettingsScreen(AppiumDriver driver) {
    super(driver);
  }
}
