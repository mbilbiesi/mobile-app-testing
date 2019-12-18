package com.hs.mobile.steps;

import com.hs.mobile.screens.ProfileScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import java.nio.charset.StandardCharsets;

public class ProfileScreenSteps extends ProfileScreen {
    private static final String VALID_NAME = "Nabeel Sweidan";
    private HomeScreenSteps homeScreenSteps = new HomeScreenSteps(driver);

    public ProfileScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Verify profile screen")
    public void verifyProfileScreen() {
        SoftAssertions assertions = new SoftAssertions();
        String title = getTitle();
        boolean isValidTitle =
                new String("حسابي".getBytes(), StandardCharsets.UTF_8).equals(title)
                        || "My Account".equals(title);

        assertions.assertThat(isValidTitle).as(String.format("Invalid title: [%s].", title)).isTrue();
        assertions
                .assertThat(isNumberEnabled())
                .as("Number field should be disabled.")
                .isFalse();
        assertions
                .assertThat(isNameActive())
                .as("Name field should be displayed and enabled.")
                .isTrue();
        assertions
                .assertThat(isEmailActive())
                .as("Email field should be displayed and enabled.")
                .isTrue();
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Verify profile updates")
    public void verifyProfileUpdates() {
        SoftAssertions assertions = new SoftAssertions();
        String email = "ns1@hs.com";

        insertName(VALID_NAME);
        insertEmail(email);
        update();
        waitUntilProfileIsUpdated();
        driver.navigate().back();
        homeScreenSteps.clickOnMore().goToProfile();
        assertions
                .assertThat(getName())
                .as("Name was not successfully updated.")
                .isEqualTo(VALID_NAME);
        assertions
                .assertThat(getEmail())
                .as("Name was not successfully updated.")
                .isEqualTo(email);
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Verify field boundaries")
    public void verifyFieldBoundaries() {
        SoftAssertions assertions = new SoftAssertions();
        String invalidName =
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

        insertName(VALID_NAME);
        insertEmail("");
        assertions
                .assertThat(isUpdateButtonEnabled())
                .as("Email is mandatory.")
                .isFalse();
        insertName("");
        insertEmail("ns2@hs.com");
        assertions
                .assertThat(isUpdateButtonEnabled())
                .as("Name is not mandatory.")
                .isTrue();
        insertName(invalidName);
        update();
        waitUntilProfileIsUpdated();
        driver.navigate().back();
        homeScreenSteps.clickOnMore().goToProfile();
        assertions
                .assertThat(getName())
                .as("Name should not exceed 50 characters.")
                .isNotEqualTo(invalidName);
        driver.navigate().back();
        assertions.assertAll();
    }
}
