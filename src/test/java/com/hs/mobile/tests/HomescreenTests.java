package com.hs.mobile.tests;

import com.hs.mobile.exception.TestExecutionException;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Epic("Smoke Tests")
@Feature("Homescreen Tests")
@Execution(ExecutionMode.CONCURRENT)
class HomescreenTests extends BaseTest {

    @Test
    @Story("Open the application with a new user")
    @Description("We need to verify that all page elements are present, " +
            "and the delivery place equals current location")
    @Issue("https://hungerstation.atlassian.net/browse/HSAP-168")
    @Severity(SeverityLevel.CRITICAL)
    void verifyThatAllHomeScreenElementsAreDisplayed(TestInfo testInfo) {
        homescreenSteps.verifyThatAllHomeElementsDisplayed();
    }
}
