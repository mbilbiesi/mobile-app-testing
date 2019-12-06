package com.hs.mobile.screens;

import com.hs.mobile.enumeration.ElementAttribute;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

class AbstractScreen {
    protected final TouchAction touchAction;
    protected final AppiumDriver driver;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//*[@text='تخطى الإعلان' or @text='TBD']")
    private List<WebElement> lnkSkipPromotion;

    public void dismissPromotion() {
        if(lnkSkipPromotion.size()>0) {
            tap(lnkSkipPromotion.get(0));
        }
    }

    public AbstractScreen(AppiumDriver driver, TouchAction touchAction) {
        this.driver = driver;
        this.touchAction = touchAction;
        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(15)), this);
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

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    void tap(WebElement element) {
        touchAction.tap(tapOptions().withElement(element(element))).perform();
    }

    String getElementAttributeValue(WebElement element, ElementAttribute attribute) {
        return element.getAttribute(attribute.getName());
    }

    //ToDo: Implement a method for scrolling down a page.
    public void scrollDown1(int swipeTimes, int durationForSwipe) {
        Dimension dimension = driver.manage().window().getSize();

        for (int i = 1; i <= swipeTimes; i++) {
            int start = (int) (dimension.getHeight() * 0.5);
            int end = (int) (dimension.getHeight() * 0.3);
            int x = (int) (dimension.getWidth() * .5);

            new TouchAction((AppiumDriver) driver).press(point(x, start)).moveTo(point(x, end))
                    .waitAction(waitOptions(Duration.ofMillis(durationForSwipe)))
                    .release().perform();
        }
    }

    public void scrollDown(WebElement element) {

        Point point = element.getLocation();
        int startY = point.y;
        int endY = point.y;

        Dimension dimension = driver.manage().window().getSize();

        int startX = (int) (dimension.getWidth() * 0.80);
        int endX = (int) (dimension.getWidth() * 0.20);
        touchAction.press(point(startX, startY)).moveTo(point(endX, endY))
                .release().perform();
    }

    public void scrollDown(List<WebElement> element) {

        Point point = element.get(0).getLocation();
        int startY = point.y;
        int endY = point.y;

        Dimension dimension = driver.manage().window().getSize();

        int startX = (int) (dimension.getWidth() * 0.80);
        int endX = (int) (dimension.getWidth() * 0.20);

        touchAction.press(point(startX, startY)).moveTo(point(endX, endY))
                .release().perform();
    }

    public void scrollByElement(WebElement element) {
        Dimension dimension = driver.manage().window().getSize();
        int x = element.getLocation().x;
        int y = element.getLocation().y;
        int startY = (int) (dimension.getHeight() * 0.90);
        int endY = (int) (dimension.getHeight() * 0.10);
        //TouchAction action = new TouchAction(driver);
        touchAction.press(point(x, startY)).waitAction(waitOptions(ofMillis(100)))
                .moveTo(point(x, endY)).release().perform();
    }
}