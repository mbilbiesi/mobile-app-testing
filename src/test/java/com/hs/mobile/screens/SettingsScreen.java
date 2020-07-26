package com.hs.mobile.screens;

import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class SettingsScreen extends AbstractScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
  private WebElement title;

  @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
  private WebElement back;

  @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='1']")
  private WebElement language;

  @AndroidFindBy(id = "android:id/text1")
  private List<WebElement> languages;

  @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@index='0']")
  private WebElement english;

  @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@index='1']")
  private WebElement arabic;

  @AndroidFindBy(id = "android:id/button2")
  private WebElement cancel;

  @AndroidFindBy(id = "android:id/checkbox")
  private WebElement chkNotifications;

  public SettingsScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
