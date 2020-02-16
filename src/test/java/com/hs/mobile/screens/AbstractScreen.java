package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public abstract class AbstractScreen {

  // ToDo: find the locator of the skip promotion link in english
  @iOSXCUITFindBy(xpath = "")
  @AndroidFindBy(xpath = "//*[@text='تخطى الإعلان' or @text='textInEnglish']")
  private List<WebElement> lnkSkipPromotion;

  public AbstractScreen(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
  }
}
