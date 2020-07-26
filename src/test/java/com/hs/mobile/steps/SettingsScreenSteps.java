package com.hs.mobile.steps;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.data.Language;
import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.android.SettingsScreen;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.util.Optional;

import static com.hs.mobile.data.ElementAttribute.*;
import static com.hs.mobile.data.Language.AR;
import static com.hs.mobile.data.Language.EN;

public class SettingsScreenSteps extends BaseSteps {

  @NonNull private final SettingsScreen settingsScreen;

  public SettingsScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    settingsScreen = new SettingsScreen(settings);
  }

  @Step("Set the language to Arabic")
  public void useArabic() {
    Language selectedLanguage = getSelectedLanguage();
    if (selectedLanguage.equals(EN)) {
      selectLanguage(AR);
    }
  }

  @Step("Set the language to English")
  public void useEnglish() {
    Language selectedLanguage = getSelectedLanguage();
    if (selectedLanguage.equals(AR)) {
      selectLanguage(EN);
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
    soft.assertThat(getSelectedLanguage()).as("Selected language should be Arabic").isEqualTo(AR);
    navigateBack(1);
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
    soft.assertThat(getSelectedLanguage()).as("Selected language should be English").isEqualTo(EN);
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
    return getElementAttributeValue(settingsScreen.getTitle(), TEXT);
  }

  public Boolean isBackButtonActive() {
    return isElementActive(settingsScreen.getBack());
  }

  public void selectLanguage(Language desiredLanguage) {
    tap(settingsScreen.getLanguage());
    waitUntilDialogDisplays();
    if (desiredLanguage.equals(EN)) {
      tap(settingsScreen.getEnglish());
    } else {
      tap(settingsScreen.getArabic());
    }
  }

  public Language getSelectedLanguage() {
    tap(settingsScreen.getLanguage());
    waitUntilDialogDisplays();
    for (WebElement lang : settingsScreen.getLanguages()) {
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
    tap(settingsScreen.getCancel());
  }

  public Boolean areNotificationsEnabled() {
    return Boolean.parseBoolean(
        getElementAttributeValue(settingsScreen.getChkNotifications(), CHECKED));
  }

  private void tickNotificationsCheckBox() {
    tap(settingsScreen.getChkNotifications());
  }

  private void waitUntilDialogDisplays() {
    waitUntilAnElementIsUpdated(settingsScreen.getCancel(), ENABLED, String.valueOf(true));
  }
}
