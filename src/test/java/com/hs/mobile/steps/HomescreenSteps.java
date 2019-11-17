package com.hs.mobile.steps;

import com.hs.mobile.screens.HomeScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class HomescreenSteps extends HomeScreen {

    public HomescreenSteps(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

    @Step("Verify that all Homescreen elements are displayed correctly")
    public void verifyThatAllHomeElementsDisplayed() {
        assertAll(
                () -> assertThat(isUseMyCurrentLocationTextDisplayed())
                        .as("Use my current location text is not displayed.").isTrue(),
                () -> assertThat(isUseMyCurrentLocationImageDisplayed()).as(
                        "Use my current location image is not displayed.").isTrue(),
                () -> assertThat(isFindRestaurantsButtonDisplayed()).as(
                        "Find restaurant button is not displayed.").isTrue(),
                () -> assertThat(isRestaurantsItemDisplayed())
                        .as("Restaurants item is not displayed.").isTrue(),
                () -> assertThat(isOrdersItemDisplayed())
                        .as("Orders item is not displayed.").isTrue(),
                () -> assertThat(isOffersItemDisplayed())
                        .as("Offers item is not displayed.").isTrue(),
                () -> assertThat(isMoreItemDisplayed())
                        .as("More item is not displayed.").isTrue()
        );
    }

    @Step("Click the \"My Orders\" button")
    public void clickMyOrdersButton() {
        touchAction.tap(tapOptions().withElement(element(getOrdersItem()))).perform();
    }

    @Step("Click the \"Find Restaurants\" button")
    public void clickFindRestaurantsButton() {
        touchAction.tap(tapOptions().withElement(element(getFindRestaurantsButton()))).perform();
    }
}
