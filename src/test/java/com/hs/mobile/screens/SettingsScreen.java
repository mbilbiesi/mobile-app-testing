package com.hs.mobile.screens;

import com.hs.mobile.data.Language;
import com.hs.mobile.exception.TestExecutionException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static com.hs.mobile.data.ElementAttribute.CHECKED;
import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.TEXT;
import static com.hs.mobile.data.Language.ENGLISH;

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

    public String getTitle() {
        return getElementAttributeValue(title, TEXT);
    }

    public Boolean isBackButtonActive() {
        return isElementActive(back);
    }

    public void selectLanguage(Language desiredLanguage) {
        tap(language);
        waitUntilDialogDisplays();
        if (desiredLanguage.equals(ENGLISH)) {
            tap(english);
        } else {
            tap(arabic);
        }
    }

    public Language getSelectedLanguage() {
        tap(language);
        waitUntilDialogDisplays();
        for (WebElement lang : languages) {
            if (getElementAttributeValue(lang, CHECKED).equals(String.valueOf(true))) {
                Optional<Language> languageOptional = Language.getByLabel(getElementAttributeValue(lang, TEXT));
                if (languageOptional.isPresent()) {
                    cancel();
                    return languageOptional.get();
                }
            }
        }
        throw new TestExecutionException("Could not determine selected language.");
    }

    public void cancel() {
        tap(cancel);
    }

    public Boolean areNotificationsEnabled() {
        return Boolean.parseBoolean(getElementAttributeValue(notifications, CHECKED));
    }

    public void tickNotificationsCheckBox() {
        tap(notifications);
    }

    public void waitUntilDialogDisplays() {
        waitUntilAnElementIsUpdated(cancel, ENABLED, String.valueOf(true));
    }
}
