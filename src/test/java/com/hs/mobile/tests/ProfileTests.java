package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;

@Feature("Profile Smoke Test")
@Story("Verify elements, updates, and field boundaries of the profile screen")
@Issue("HSAP-181")
@Listeners(TestListener.class)
public class ProfileTests extends BaseTest {
  private static final String VALID_NAME = "Nabeel Sweidan";

  @BeforeMethod
  public void goToProfile() {
    // When
    homeScreenSteps.clickOnMore().goToProfile();
  }

  @Test(description = "Check user profile screen elements")
  public void navigateToProfileScreen_elementsAreProperlyDisplayed() {
    // Then
    verifyProfileScreen();
  }

  @Test(description = "Perform and verify valid updates")
  public void navigateToProfileScreen_updatesAreCorrectlyPerformed() {
    // Then
    verifyProfileUpdates();
  }

  @Test(description = "Check user profile field boundaries")
  public void navigateToProfileScreen_fieldsHaveProperBoundaries() {
    // Then
    verifyFieldBoundaries();
  }

  @Step("Verify profile screen")
  public void verifyProfileScreen() {
    SoftAssertions assertions = new SoftAssertions();
    String title = profileScreen.getTitle();
    boolean isValidTitle =
        new String("حسابي".getBytes(), StandardCharsets.UTF_8).equals(title)
            || "My Account".equals(title);

    assertions.assertThat(isValidTitle).as(String.format("Invalid title: [%s].", title)).isTrue();
    assertions
        .assertThat(profileScreen.isNumberEnabled())
        .as("Number field should be disabled.")
        .isFalse();
    assertions
        .assertThat(profileScreen.isNameActive())
        .as("Name field should be displayed and enabled.")
        .isTrue();
    assertions
        .assertThat(profileScreen.isEmailActive())
        .as("Email field should be displayed and enabled.")
        .isTrue();
    driver.navigate().back();
    assertions.assertAll();
  }

  @Step("Verify profile updates")
  public void verifyProfileUpdates() {
    SoftAssertions assertions = new SoftAssertions();
    String email = "ns1@hs.com";

    profileScreen.insertName(VALID_NAME);
    profileScreen.insertEmail(email);
    profileScreen.update();
    profileScreen.waitUntilProfileIsUpdated();
    driver.navigate().back();
    homeScreenSteps.clickOnMore().goToProfile();
    assertions
        .assertThat(profileScreen.getName())
        .as("Name was not successfully updated.")
        .isEqualTo(VALID_NAME);
    assertions
        .assertThat(profileScreen.getEmail())
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

    profileScreen.insertName(VALID_NAME);
    profileScreen.insertEmail("");
    assertions
        .assertThat(profileScreen.isUpdateButtonEnabled())
        .as("Email is mandatory.")
        .isFalse();
    profileScreen.insertName("");
    profileScreen.insertEmail("ns2@hs.com");
    assertions
        .assertThat(profileScreen.isUpdateButtonEnabled())
        .as("Name is not mandatory.")
        .isTrue();
    profileScreen.insertName(invalidName);
    profileScreen.update();
    profileScreen.waitUntilProfileIsUpdated();
    driver.navigate().back();
    homeScreenSteps.clickOnMore().goToProfile();
    assertions
        .assertThat(profileScreen.getName())
        .as("Name should not exceed 50 characters.")
        .isNotEqualTo(invalidName);
    driver.navigate().back();
    assertions.assertAll();
  }
}
