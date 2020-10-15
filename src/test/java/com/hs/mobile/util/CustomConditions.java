package com.hs.mobile.util;

import io.appium.java_client.AppiumDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public final class CustomConditions {

  private CustomConditions() {}

  public static ExpectedCondition<Boolean> elementIsClicked(WebElement elementToClickOn) {
    {
      By byFromWebElement = LocatorUtils.getByFromWebElement(elementToClickOn);
      return driver -> {
        AppiumDriver<?> appiumDriver = (AppiumDriver<?>) driver;
        try {
          assert appiumDriver != null;
          appiumDriver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
          driver.findElement(byFromWebElement).click();
          return true;
        } catch (NoSuchElementException ignore) {
        }
        return false;
      };
    }
  }

  public static ExpectedCondition<Boolean> elementIsClicked(
      WebElement elementToClickOn, WebElement expectedElementAfterClick) {
    {
      By byFromWebElement = LocatorUtils.getByFromWebElement(expectedElementAfterClick);
      return driver -> {
        AppiumDriver<?> appiumDriver = (AppiumDriver<?>) driver;
        try {
          assert appiumDriver != null;
          appiumDriver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
          driver.findElement(byFromWebElement);
          return true;
        } catch (NoSuchElementException ignore) {
          try {
            elementToClickOn.click();
          } catch (NoSuchElementException ignored) {
          }
        }
        return false;
      };
    }
  }

  public static ExpectedCondition<Boolean> elementIsNotDisplayed(WebElement element) {
    {
      By elementBy = LocatorUtils.getByFromWebElement(element);
      return driver -> {
        AppiumDriver<?> appiumDriver = (AppiumDriver<?>) driver;
        try {
          assert appiumDriver != null;
          appiumDriver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
          appiumDriver.findElement(elementBy);
          return false;
        } catch (NoSuchElementException ignored) {
        }
        return true;
      };
    }
  }
}
