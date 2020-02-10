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

public class SettingsScreenSteps {
  private SettingsScreen settingsScreen;

  public SettingsScreenSteps(AppiumDriver driver) {
    settingsScreen = new SettingsScreen(driver);
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
    SoftAssertions soft = new SoftAssertions();
    String title = "الإعدادات";

    soft.assertThat(getTitleFromElement())
            .as(String.format("Invalid title [%s].", title))
            .isEqualTo(title);
    soft.assertThat(isBackButtonActive()).as("Return button should be active.").isTrue();
    soft.assertThat(getSelectedLanguage())
            .as("Selected language should be Arabic")
            .isEqualTo(ARABIC);
    settingsScreen.navigateBack(1);
    soft.assertAll();
  }

  @Step("Verify that elements display correctly in English")
  public void verifyThatScreenDisplaysProperlyInEnglish() {
    SoftAssertions soft = new SoftAssertions();
    String title = "Settings";

    soft.assertThat(getTitleFromElement())
            .as(String.format("Invalid title [%s].", title))
            .isEqualTo(title);
    soft.assertThat(isBackButtonActive()).as("Return button should be active.").isTrue();
    soft.assertThat(getSelectedLanguage())
            .as("Selected language should be English")
            .isEqualTo(ENGLISH);
    settingsScreen.navigateBack(1);
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
    settingsScreen.navigateBack(1);
  }

  @Step("Disable notifications")
  public void disableNotifications() {
    if (areNotificationsEnabled()) {
      tickNotificationsCheckBox();
    } else {
      tickNotificationsCheckBox();
      tickNotificationsCheckBox();
    }
    settingsScreen.navigateBack(1);
  }

  public String getTitleFromElement() {
    return settingsScreen.getElementAttributeValue(settingsScreen.getTitle(), TEXT);
  }

  public Boolean isBackButtonActive() {
    return settingsScreen.isElementActive(settingsScreen.getBack());
  }

  public void selectLanguage(Language desiredLanguage) {
    settingsScreen.tap(settingsScreen.getLanguage());
    waitUntilDialogDisplays();
    if (desiredLanguage.equals(ENGLISH)) {
      settingsScreen.tap(settingsScreen.getEnglish());
    } else {
      settingsScreen.tap(settingsScreen.getArabic());
    }
  }

  public Language getSelectedLanguage() {
    settingsScreen.tap(settingsScreen.getLanguage());
    waitUntilDialogDisplays();
    for (WebElement lang : settingsScreen.getLanguages()) {
      if (settingsScreen.getElementAttributeValue(lang, CHECKED).equals(String.valueOf(true))) {
        Optional<Language> languageOptional =
                Language.getByLabel(settingsScreen.getElementAttributeValue(lang, TEXT));
        if (languageOptional.isPresent()) {
          cancel();
          return languageOptional.get();
        }
      }
    }
    throw new TestExecutionException("Could not determine selected language.");
  }

  private void cancel() {
    settingsScreen.tap(settingsScreen.getCancel());
  }

  public Boolean areNotificationsEnabled() {
    return Boolean.parseBoolean(
            settingsScreen.getElementAttributeValue(settingsScreen.getNotifications(), CHECKED));
  }

  private void tickNotificationsCheckBox() {
    settingsScreen.tap(settingsScreen.getNotifications());
  }

  private void waitUntilDialogDisplays() {
    settingsScreen.waitUntilAnElementIsUpdated(
            settingsScreen.getCancel(), ENABLED, String.valueOf(true));
  }
}
