package com.hs.mobile.steps;

import com.hs.mobile.screens.ProfileScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.SoftAssertions;

import java.nio.charset.StandardCharsets;

public class ProfileScreenSteps {
    private static final String VALID_NAME = RandomStringUtils.randomAlphanumeric(10);
    private ProfileScreen profileScreen;
    private HomeScreenSteps homeScreenSteps;

    public ProfileScreenSteps(AppiumDriver driver) {
        profileScreen = new ProfileScreen(driver);
        homeScreenSteps = new HomeScreenSteps(driver);
    }

    @Step("Verify profile screen")
    public void verifyProfileScreen() {
        SoftAssertions soft = new SoftAssertions();
        String title = profileScreen.getTitle();
        boolean isValidTitle =
                new String("حسابي".getBytes(), StandardCharsets.UTF_8).equals(title)
                        || "My Account".equals(title);

        soft.assertThat(isValidTitle).as(String.format("Invalid title: [%s].", title)).isTrue();
        soft.assertThat(profileScreen.isNumberEnabled())
                .as("Number field should be disabled.")
                .isFalse();
        soft.assertThat(profileScreen.isNameActive())
                .as("Name field should be displayed and enabled.")
                .isTrue();
        soft.assertThat(profileScreen.isEmailActive())
                .as("Email field should be displayed and enabled.")
                .isTrue();
        profileScreen.navigateBack(1);
        soft.assertAll();
    }

    @Step("Verify profile updates")
    public void verifyProfileUpdates() {
        SoftAssertions soft = new SoftAssertions();
        String email = "ns1@hs.com";

        profileScreen.insertName(VALID_NAME);
        profileScreen.insertEmail(email);
        profileScreen.update();
        profileScreen.waitUntilProfileIsUpdated();
        profileScreen.navigateBack(1);
        homeScreenSteps.clickOnMore().goToProfile();
        soft.assertThat(profileScreen.getName())
                .as("Name was not successfully updated.")
                .isEqualTo(VALID_NAME);
        soft.assertThat(profileScreen.getEmail())
                .as("Name was not successfully updated.")
                .isEqualTo(email);
        profileScreen.navigateBack(1);
        soft.assertAll();
    }

    @Step("Verify field boundaries")
    public void verifyFieldBoundaries() {
        SoftAssertions soft = new SoftAssertions();
        String invalidName = RandomStringUtils.randomAlphanumeric(51);

        profileScreen.insertName(VALID_NAME);
        profileScreen.insertEmail("");
        soft.assertThat(profileScreen.isUpdateButtonEnabled()).as("Email is mandatory.").isFalse();
        profileScreen.insertName("");
        profileScreen.insertEmail("ns2@hs.com");
        soft.assertThat(profileScreen.isUpdateButtonEnabled()).as("Name is not mandatory.").isTrue();
        profileScreen.insertName(invalidName);
        profileScreen.update();
        profileScreen.waitUntilProfileIsUpdated();
        profileScreen.navigateBack(1);
        homeScreenSteps.clickOnMore().goToProfile();
        soft.assertThat(profileScreen.getName())
                .as("Name should not exceed 50 characters.")
                .isNotEqualTo(invalidName);
        profileScreen.navigateBack(1);
        soft.assertAll();
    }
}
