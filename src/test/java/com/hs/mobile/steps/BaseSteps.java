package com.hs.mobile.steps;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.data.ElementAttribute;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public abstract class BaseSteps {
  private AppiumDriver driver;
  protected TouchAction touchAction = new TouchAction(driver);
  protected WebDriverWait wait = new WebDriverWait(driver, 10);

  public BaseSteps(AppiumDriver driver) {
    this.driver = driver;
  }

  public void hideKeyboard() {
    if (isAndroid()) {
      driver.hideKeyboard();
    } else {
      IOSDriver iosDriver = (IOSDriver) driver;
      iosDriver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
    }
  }

  public boolean isAndroid() {
    return driver instanceof AndroidDriver;
  }

  public boolean isIOS() {
    return driver instanceof IOSDriver;
  }

  public void tap(WebElement element) {
    touchAction.tap(tapOptions().withElement(element(element))).perform();
  }

  public String getElementAttributeValue(WebElement element, ElementAttribute attribute) {
    return element.getAttribute(attribute.getName());
  }

  public void verifyScreenElements() {
    SoftAssertions soft = new SoftAssertions();

    Class<?> clazz = this.getClass();
    for (Field field : clazz.getDeclaredFields()) {
      if (field.isAnnotationPresent(AssertElementVisibility.class)) {
        if (field.getType().isAssignableFrom(MobileElement.class)) {
          try {
            field.setAccessible(true);
            WebElement element = (WebElement) field.get(this);
            soft.assertThat(element.isDisplayed())
                .as(field.getName() + " is not displayed")
                .isTrue();
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          }
        }
      }
    }

    soft.assertAll();
  }

  public void verifyScreenElements(SoftAssertions soft) {
    // Method has been created in case we want to verify other things before closing the soft
    // assertion
    Class<?> clazz = this.getClass();
    for (Field field : clazz.getDeclaredFields()) {
      if (field.isAnnotationPresent(AssertElementVisibility.class)) {
        if (field.getType().isAssignableFrom(MobileElement.class)) {
          try {
            field.setAccessible(true);
            WebElement element = (WebElement) field.get(this);
            soft.assertThat(element.isDisplayed())
                .as(field.getName() + " is not displayed")
                .isTrue();
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  public void scrollByElement(WebElement element) {
    Dimension dimension = driver.manage().window().getSize();
    int x = element.getLocation().x;
    int y = element.getLocation().y;
    int startY = (int) (dimension.getHeight() * 0.90);
    int endY = (int) (dimension.getHeight() * 0.10);
    touchAction
        .press(point(x, startY))
        .waitAction(waitOptions(ofMillis(100)))
        .moveTo(point(x, endY))
        .release()
        .perform();
  }

  public String getElementColor(MobileElement element) {
    int[] rgb = new int[2];
    String color;

    rgb = getElementColorInRGB(element);
    color = convertRGBtoHex(rgb);

    return color;
  }

  public int[] getElementColorInRGB(MobileElement element) {

    int[] rgb = new int[3];
    Point point = element.getCenter();
    int centerx = point.getX();
    int centerY = point.getY();

    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    BufferedImage image = null;
    try {
      image = ImageIO.read(scrFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
    // Getting pixel color by position x and y
    int clr = image.getRGB(centerx, centerY);
    rgb[0] = (clr & 0x00ff0000) >> 16; // red
    rgb[1] = (clr & 0x0000ff00) >> 8; // green
    rgb[2] = clr & 0x000000ff; // blue

    return rgb;
  }

  public String convertRGBtoHex(int[] rgb) {
    String hex;
    hex = String.format("#%02x%02x%02x", rgb[0], rgb[1], rgb[2]);
    return hex;
  }

  public void swipe(MobileElement startElement, MobileElement endElement) {
    touchAction
        .longPress(
            longPressOptions()
                .withElement(element(startElement))
                .withDuration(Duration.ofMillis(500)))
        .moveTo(element(endElement))
        .release()
        .perform();
  }

  public Boolean isElementActive(WebElement element) {
    return element.isDisplayed() && element.isEnabled();
  }

  public void waitUntilAnElementIsUpdated(
      WebElement element, ElementAttribute attribute, String expectedValue) {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.attributeToBe(element, attribute.getName(), expectedValue));
  }

  public void navigateBack(int count) {
    if (count <= 0) {
      return;
    }
    int i = 0;
    while (i < count) {
      driver.navigate().back();
      i++;
    }
  }
}
