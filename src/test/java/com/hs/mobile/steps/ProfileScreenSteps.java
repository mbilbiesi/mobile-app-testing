package com.hs.mobile.steps;

import com.hs.mobile.screens.ProfileScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.SoftAssertions;

import java.nio.charset.StandardCharsets;

import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.TEXT;

public class ProfileScreenSteps extends BaseSteps {
  private static final String VALID_NAME = RandomStringUtils.randomAlphanumeric(10);
  private ProfileScreen profileScreen;
  private HomeScreenSteps homeScreenSteps;

  public ProfileScreenSteps(AppiumDriver driver) {
    super(driver);
    profileScreen = new ProfileScreen(driver);
    homeScreenSteps = new HomeScreenSteps(driver);
  }

  @Step("Verify profile screen")
  public void verifyProfileScreen() {
    SoftAssertions soft = new SoftAssertions();
    String title = getTitleText();
    boolean isValidTitle =
        new String("حسابي".getBytes(), StandardCharsets.UTF_8).equals(title)
            || "My Account".equals(title);

    soft.assertThat(isValidTitle).as(String.format("Invalid title: [%s].", title)).isTrue();
    soft.assertThat(isNumberEnabled()).as("Number field should be disabled.").isFalse();
    soft.assertThat(isNameActive()).as("Name field should be displayed and enabled.").isTrue();
    soft.assertThat(isEmailActive()).as("Email field should be displayed and enabled.").isTrue();
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
    soft.assertThat(profileScreen.getName())
        .as("Name was not successfully updated.")
        .isEqualTo(VALID_NAME);
    soft.assertThat(profileScreen.getEmail())
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
    soft.assertThat(isUpdateButtonEnabled()).as("Email is mandatory.").isFalse();
    insertName("");
    insertEmail("ns2@hs.com");
    soft.assertThat(isUpdateButtonEnabled()).as("Name is not mandatory.").isTrue();
    insertName(invalidName);
    update();
    waitUntilProfileIsUpdated();
    navigateBack(1);
    homeScreenSteps.clickOnMore().goToProfile();
    soft.assertThat(profileScreen.getName())
        .as("Name should not exceed 50 characters.")
        .isNotEqualTo(invalidName);
    navigateBack(1);
    soft.assertAll();
  }

  private String getTitleText() {
    return getElementAttributeValue(profileScreen.getTitle(), TEXT);
  }

  private Boolean isNumberEnabled() {
    return profileScreen.getNumber().isEnabled();
  }

  private Boolean isNameActive() {
    return isElementActive(profileScreen.getName());
  }

  private Boolean isEmailActive() {
    return isElementActive(profileScreen.getEmail());
  }

  private void insertName(String newName) {
    profileScreen.getName().clear();
    profileScreen.getName().sendKeys(newName);
  }

  private void insertEmail(String newEmail) {
    profileScreen.getEmail().clear();
    profileScreen.getEmail().sendKeys(newEmail);
  }

  private String getNameText() {
    return getElementAttributeValue(profileScreen.getName(), TEXT);
  }

  private String getEmailText() {
    return getElementAttributeValue(profileScreen.getEmail(), TEXT);
  }

  private void update() {
    tap(profileScreen.getUpdate());
  }

  private Boolean isUpdateButtonEnabled() {
    return profileScreen.getUpdate().isEnabled();
  }

  private void waitUntilProfileIsUpdated() {
    waitUntilAnElementIsUpdated(profileScreen.getUpdate(), ENABLED, String.valueOf(false));
  }
}
