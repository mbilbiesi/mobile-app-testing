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
        navigateBack(1);
    }

    @Step("Set the language to English")
    public void useEnglish() {
        Language selectedLanguage = getSelectedLanguage();
        if (selectedLanguage.equals(ARABIC)) {
            selectLanguage(ENGLISH);
        }
        navigateBack(1);
    }

    @Step("Verify that elements display correctly in Arabic")
    public void verifyThatScreenDisplaysProperlyInArabic() {
        SoftAssertions soft = new SoftAssertions();
        String title = "الإعدادات";

        soft
                .assertThat(getTitleFromElement())
                .as(String.format("Invalid title [%s].", title))
                .isEqualTo(title);
        soft.assertThat(isBackButtonActive()).as("Return button should be active.").isTrue();
        soft
                .assertThat(getSelectedLanguage())
                .as("Selected language should be Arabic")
                .isEqualTo(ARABIC);
        navigateBack(1);
        soft.assertAll();
    }

    @Step("Verify that elements display correctly in English")
    public void verifyThatScreenDisplaysProperlyInEnglish() {
        SoftAssertions soft = new SoftAssertions();
        String title = "Settings";

        soft
                .assertThat(getTitleFromElement())
                .as(String.format("Invalid title [%s].", title))
                .isEqualTo(title);
        soft.assertThat(isBackButtonActive()).as("Return button should be active.").isTrue();
        soft
                .assertThat(getSelectedLanguage())
                .as("Selected language should be English")
                .isEqualTo(ENGLISH);
        navigateBack(1);
        soft.assertAll();
    }

    @Step("Enable notifications")
    public void enableNotifications() {
        if (areNotificationsEnabled()) {
            tickNotificationsCheckBox();
            tickNotificationsCheckBox();
        } else {
            tickNotificationsCheckBox();
        }
        navigateBack(1);
    }

    @Step("Disable notifications")
    public void disableNotifications() {
        if (areNotificationsEnabled()) {
            tickNotificationsCheckBox();
        } else {
            tickNotificationsCheckBox();
            tickNotificationsCheckBox();
        }
        navigateBack(1);
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
