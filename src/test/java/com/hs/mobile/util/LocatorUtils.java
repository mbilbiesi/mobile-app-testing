package com.hs.mobile.util;

import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;
import static org.apache.commons.lang3.StringUtils.substringBetween;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class LocatorUtils {

  private LocatorUtils() {}

  public static By getByFromWebElement(WebElement element) {
    var locator = substringBetween(element.toString(), "({", "})");
    var locatorBy = substringBefore(locator, ":");
    var locatorSelector = substringAfter(locatorBy, ".");
    var locatorValue = substringAfter(locator, ":").trim();

    By by;
    switch (locatorSelector) {
      case "id":
        by = MobileBy.id(locatorValue);
        break;
      case "AccessibilityId":
        by = MobileBy.AccessibilityId(locatorValue);
        break;
      case "xpath":
        by = By.xpath(locatorValue);
        break;
      default:
        throw new IllegalStateException("locator : " + locatorSelector + " not found!!!");
    }
    return by;
  }
}
