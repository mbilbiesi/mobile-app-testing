package com.hs.mobile.steps;

import com.hs.mobile.data.Language;
import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.SettingsScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.util.Optional;

import static com.hs.mobile.data.ElementAttribute.CHECKED;
import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.TEXT;
import static com.hs.mobile.data.Language.ARABIC;
import static com.hs.mobile.data.Language.ENGLISH;

public class SettingsScreenSteps extends SettingsScreen {

    public SettingsScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Set the language to Arabic")
    public void useArabic() {
        Language selectedLanguage = getSelectedLanguage();
        if (selectedLanguage.equals(ENGLISH)) {
            selectLanguage(ARABIC);
        }
    }

    @Step("Set the language to English")
    public void useEnglish() {
        Language selectedLanguage = getSelectedLanguage();
        if (selectedLanguage.equals(ARABIC)) {
            selectLanguage(ENGLISH);
        }
    }

    @Step("Verify that elements display correctly in Arabic")
    public void verifyThatScreenDisplaysProperlyInArabic() {
        SoftAssertions assertions = new SoftAssertions();
        String title = "الإعدادات";

        assertions
                .assertThat(getTitleFromElement())
                .as(String.format("Invalid title [%s].", title))
                .isEqualTo(title);
        assertions.assertThat(isBackButtonActive()).as("Return button should be active.").isTrue();
        assertions
                .assertThat(getSelectedLanguage())
                .as("Selected language should be Arabic")
                .isEqualTo(ARABIC);
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Verify that elements display correctly in English")
    public void verifyThatScreenDisplaysProperlyInEnglish() {
        SoftAssertions assertions = new SoftAssertions();
        String title = "Settings";

        assertions
                .assertThat(getTitleFromElement())
                .as(String.format("Invalid title [%s].", title))
                .isEqualTo(title);
        assertions.assertThat(isBackButtonActive()).as("Return button should be active.").isTrue();
        assertions
                .assertThat(getSelectedLanguage())
                .as("Selected language should be English")
                .isEqualTo(ENGLISH);
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Enable notifications")
    public void enableNotifications() {
        if (areNotificationsEnabled()) {
            tickNotificationsCheckBox();
            tickNotificationsCheckBox();
        } else {
            tickNotificationsCheckBox();
        }
        driver.navigate().back();
    }

    @Step("Disable notifications")
    public void disableNotifications() {
        if (areNotificationsEnabled()) {
            tickNotificationsCheckBox();
        } else {
            tickNotificationsCheckBox();
            tickNotificationsCheckBox();
        }
        driver.navigate().back();
    }

    public String getTitleFromElement() {
        return getElementAttributeValue(getTitle(), TEXT);
    }

    public Boolean isBackButtonActive() {
        return isElementActive(getBack());
    }

    public void selectLanguage(Language desiredLanguage) {
        tap(getLanguage());
        waitUntilDialogDisplays();
        if (desiredLanguage.equals(ENGLISH)) {
            tap(getEnglish());
        } else {
            tap(getArabic());
        }
    }

    public Language getSelectedLanguage() {
        tap(getLanguage());
        waitUntilDialogDisplays();
        for (WebElement lang : getLanguages()) {
            if (getElementAttributeValue(lang, CHECKED).equals(String.valueOf(true))) {
                Optional<Language> languageOptional =
                        Language.getByLabel(getElementAttributeValue(lang, TEXT));
                if (languageOptional.isPresent()) {
                    cancel();
                    return languageOptional.get();
                }
            }
        }
        throw new TestExecutionException("Could not determine selected language.");
    }

    private void cancel() {
        tap(getCancel());
    }

    public Boolean areNotificationsEnabled() {
        return Boolean.parseBoolean(getElementAttributeValue(getNotifications(), CHECKED));
    }

    private void tickNotificationsCheckBox() {
        tap(getNotifications());
    }

    private void waitUntilDialogDisplays() {
        waitUntilAnElementIsUpdated(getCancel(), ENABLED, String.valueOf(true));
    }
}
