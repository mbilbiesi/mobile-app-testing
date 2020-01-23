package com.hs.mobile.steps;

import com.hs.mobile.screens.ProfileScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.SoftAssertions;

import java.nio.charset.StandardCharsets;

public class ProfileScreenSteps extends ProfileScreen {
    private static final String VALID_NAME = "Nabeel Sweidan";
    private HomeScreenSteps homeScreenSteps;

    public ProfileScreenSteps(AppiumDriver driver) {
        super(driver);
        homeScreenSteps = new HomeScreenSteps(driver);
    }

    @Step("Verify profile screen")
    public void verifyProfileScreen() {
        SoftAssertions soft = new SoftAssertions();
        String title = getTitle();
        boolean isValidTitle =
                new String("حسابي".getBytes(), StandardCharsets.UTF_8).equals(title)
                        || "My Account".equals(title);

        soft.assertThat(isValidTitle).as(String.format("Invalid title: [%s].", title)).isTrue();
        soft
                .assertThat(isNumberEnabled())
                .as("Number field should be disabled.")
                .isFalse();
        soft
                .assertThat(isNameActive())
                .as("Name field should be displayed and enabled.")
                .isTrue();
        soft
                .assertThat(isEmailActive())
                .as("Email field should be displayed and enabled.")
                .isTrue();
        navigateBack(1);
        soft.assertAll();
    }

    @Step("Verify profile updates")
    public void verifyProfileUpdates() {
        SoftAssertions soft = new SoftAssertions();
        String email = "ns1@hs.com";

        insertName(VALID_NAME);
        insertEmail(email);
        update();
        waitUntilProfileIsUpdated();
        navigateBack(1);
        homeScreenSteps.clickOnMore().goToProfile();
        soft
                .assertThat(getName())
                .as("Name was not successfully updated.")
                .isEqualTo(VALID_NAME);
        soft
                .assertThat(getEmail())
                .as("Name was not successfully updated.")
                .isEqualTo(email);
        navigateBack(1);
        soft.assertAll();
    }

    @Step("Verify field boundaries")
    public void verifyFieldBoundaries() {
        SoftAssertions soft = new SoftAssertions();
        String invalidName = RandomStringUtils.randomAlphanumeric(51);

        insertName(VALID_NAME);
        insertEmail("");
        soft
                .assertThat(isUpdateButtonEnabled())
                .as("Email is mandatory.")
                .isFalse();
        insertName("");
        insertEmail("ns2@hs.com");
        soft
                .assertThat(isUpdateButtonEnabled())
                .as("Name is not mandatory.")
                .isTrue();
        insertName(invalidName);
        update();
        waitUntilProfileIsUpdated();
        navigateBack(1);
        homeScreenSteps.clickOnMore().goToProfile();
        soft
                .assertThat(getName())
                .as("Name should not exceed 50 characters.")
                .isNotEqualTo(invalidName);
        navigateBack(1);
        soft.assertAll();
    }
}
