package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class AbstractScreen {

  public AbstractScreen(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
  }
}
