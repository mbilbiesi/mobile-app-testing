package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.data.ElementAttribute;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.time.Duration;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

class AbstractScreen {
    protected final TouchAction touchAction;
    protected final AppiumDriver driver;

    public AbstractScreen(AppiumDriver driver) {
        this.driver = driver;
        this.touchAction = new TouchAction(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
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

    void tap(WebElement element) {
        touchAction.tap(tapOptions().withElement(element(element))).perform();
    }

    String getElementAttributeValue(WebElement element, ElementAttribute attribute) {
        return element.getAttribute(attribute.getName());
    }

    //ToDo: Implement a method for scrolling down a page.

    void verifyScreenElements() {
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
}