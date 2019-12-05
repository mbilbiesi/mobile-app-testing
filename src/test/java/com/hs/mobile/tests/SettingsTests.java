package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.data.Language;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;

import static com.hs.mobile.data.Language.ARABIC;
import static com.hs.mobile.data.Language.ENGLISH;

@Feature("Settings Smoke Test")
@Story("Verify settings screen functionality")
@Issue("HSAP-183")
@Listeners(TestListener.class)
public class SettingsTests extends BaseTest {

    @BeforeMethod
    public void goToSettings() {
        //When
        homeScreen.clickOnMore().goToSettings();
    }

    @Test(description = "Set the language to Arabic and check settings screen")
    public void selectArabicLanguage() {
        //And
        useArabic();
        //Then
        verifyThatScreenDisplaysProperlyInArabic();
    }

    @Test(description = "Set the language to English and check settings screen")
    public void selectEnglishLanguage() {
        //And
        useEnglish();
        //Then
        verifyThatScreenDisplaysProperlyInEnglish();
    }

    @Test(description = "Verify that notifications are correctly enabled")
    public void verifyThatNotificationsAreCorrectlyEnabled() {
        //And
        enableNotifications();
        //Then
        boolean areNotificationsEnabled = settingsScreen.areNotificationsEnabled();
        driver.navigate().back();
        Assertions.assertThat(areNotificationsEnabled).as("Notifications should be enabled.").isTrue();
    }

    @Test(description = "Verify that notifications are correctly disabled")
    public void verifyThatNotificationsAreCorrectlyDisabled() {
        //And
        disableNotifications();
        //Then
        boolean areNotificationsEnabled = settingsScreen.areNotificationsEnabled();
        driver.navigate().back();
        Assertions.assertThat(areNotificationsEnabled).as("Notifications should be disabled.").isFalse();
    }

    @Step("Set the language to Arabic")
    public void useArabic() {
        Language selectedLanguage = settingsScreen.getSelectedLanguage();
        if (selectedLanguage.equals(ENGLISH)) {
            settingsScreen.selectLanguage(ARABIC);
            homeScreen.clickOnMore().goToSettings();
        }
    }

    @Step("Set the language to English")
    public void useEnglish() {
        Language selectedLanguage = settingsScreen.getSelectedLanguage();
        if (selectedLanguage.equals(ARABIC)) {
            settingsScreen.selectLanguage(ENGLISH);
            homeScreen.clickOnMore().goToSettings();
        }
    }

    @Step("Verify that elements display correctly in Arabic")
    public void verifyThatScreenDisplaysProperlyInArabic() {
        SoftAssertions assertions = new SoftAssertions();
        String title = new String("الإعدادات".getBytes(), StandardCharsets.UTF_8);

        assertions.assertThat(settingsScreen.getTitle())
                .as(String.format("Invalid title [%s].", title)).isEqualTo(title);
        assertions.assertThat(settingsScreen.isBackButtonActive())
                .as("Return button should be active.").isTrue();
        assertions.assertThat(settingsScreen.getSelectedLanguage())
                .as("Selected language should be Arabic").isEqualTo(ARABIC);
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Verify that elements display correctly in English")
    public void verifyThatScreenDisplaysProperlyInEnglish() {
        SoftAssertions assertions = new SoftAssertions();
        String title = "Settings";

        assertions.assertThat(settingsScreen.getTitle())
                .as(String.format("Invalid title [%s].", title)).isEqualTo(title);
        assertions.assertThat(settingsScreen.isBackButtonActive())
                .as("Return button should be active.").isTrue();
        assertions.assertThat(settingsScreen.getSelectedLanguage())
                .as("Selected language should be English").isEqualTo(ENGLISH);
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Enable notifications")
    public void enableNotifications() {
        if (settingsScreen.areNotificationsEnabled()) {
            settingsScreen.tickNotificationsCheckBox();
            settingsScreen.tickNotificationsCheckBox();
        } else {
            settingsScreen.tickNotificationsCheckBox();
        }
        driver.navigate().back();
        homeScreen.clickOnMore().goToSettings();
    }

    @Step("Disable notifications")
    public void disableNotifications() {
        if (settingsScreen.areNotificationsEnabled()) {
            settingsScreen.tickNotificationsCheckBox();
        } else {
            settingsScreen.tickNotificationsCheckBox();
            settingsScreen.tickNotificationsCheckBox();
        }
        driver.navigate().back();
        homeScreen.clickOnMore().goToSettings();
    }
}
