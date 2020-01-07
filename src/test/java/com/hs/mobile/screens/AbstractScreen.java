package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.data.ElementAttribute;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class AbstractScreen {
  protected final TouchAction touchAction;
  protected final AppiumDriver driver;

  // ToDo: find the locator of the skip promotion link in english
  @iOSXCUITFindBy(xpath = "")
  @AndroidFindBy(xpath = "//*[@text='تخطى الإعلان' or @text='textInEnglish']")
  private List<WebElement> lnkSkipPromotion;

  public AbstractScreen(AppiumDriver driver) {
    this.driver = driver;
    this.touchAction = new TouchAction(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
  }

  public void dismissPromotion() {
    if (lnkSkipPromotion.size() > 0) {
      tap(lnkSkipPromotion.get(0));
    }
  }

  protected void hideKeyboard() {
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

  protected String getElementAttributeValue(WebElement element, ElementAttribute attribute) {
    return element.getAttribute(attribute.getName());
  }

  protected void verifyScreenElements() {
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

  protected Boolean isElementActive(WebElement element) {
    return element.isDisplayed() && element.isEnabled();
  }

  protected void waitUntilAnElementIsUpdated(
          WebElement element, ElementAttribute attribute, String expectedValue) {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.attributeToBe(element, attribute.getName(), expectedValue));
  }
}
