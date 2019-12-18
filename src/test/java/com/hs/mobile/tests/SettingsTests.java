package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Settings Smoke Test")
@Story("Verify updates of language and notifications on the settings screen")
@Issue("HSAP-183")
@Listeners(TestListener.class)
public class SettingsTests extends BaseTest {

  @BeforeMethod
  public void goToSettings() {
    // Given
    homeScreenSteps.clickOnMore().goToSettings();
  }

  @Test(description = "Set the language to Arabic and check settings screen")
  public void navigateToSettingsScreen_appSuccessfullySwitchesToArabic() {
    // When
    settingsScreenSteps.useArabic();
    homeScreenSteps.clickOnMore().goToSettings();

    // Then
    settingsScreenSteps.verifyThatScreenDisplaysProperlyInArabic();
  }

  @Test(description = "Set the language to English and check settings screen")
  public void navigateToSettingsScreen_appSuccessfullySwitchesToEnglish() {
    // When
    settingsScreenSteps.useEnglish();
    homeScreenSteps.clickOnMore().goToSettings();

    // Then
    settingsScreenSteps.verifyThatScreenDisplaysProperlyInEnglish();
  }

  @Test(description = "Verify that notifications are correctly enabled")
  public void navigateToSettingsScreen_notificationsAreSuccessfullyEnabled() {
    // When
    settingsScreenSteps.enableNotifications();
    homeScreenSteps.clickOnMore().goToSettings();

    // Then
    boolean areNotificationsEnabled = settingsScreenSteps.areNotificationsEnabled();
    driver.navigate().back();
    Assertions.assertThat(areNotificationsEnabled).as("Notifications should be enabled.").isTrue();
  }

  @Test(description = "Verify that notifications are correctly disabled")
  public void navigateToSettingsScreen_notificationsAreSuccessfullyDisabled() {
    // When
    settingsScreenSteps.disableNotifications();
    homeScreenSteps.clickOnMore().goToSettings();

    // Then
    boolean areNotificationsEnabled = settingsScreenSteps.areNotificationsEnabled();
    driver.navigate().back();
    Assertions.assertThat(areNotificationsEnabled)
        .as("Notifications should be disabled.")
        .isFalse();
  }
}
