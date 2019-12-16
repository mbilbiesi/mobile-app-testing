package com.hs.mobile.steps;

import com.hs.mobile.screens.RestaurantScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.hs.mobile.data.ElementAttribute.CLICKABLE;
import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.FOCUSABLE;

public class RestaurantScreenSteps extends RestaurantScreen {

    public RestaurantScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Verify that menu groups display properly")
    public void verifyThatMenuGroupsDisplayProperly(List<WebElement> menuGroups) {
        SoftAssertions assertions = new SoftAssertions();
        String isTrue = String.valueOf(true);
        for (WebElement menuGroup : menuGroups) {
            assertions.assertThat(getElementAttributeValue(menuGroup, CLICKABLE))
                    .as("Menu group should be clickable").isEqualTo(isTrue);
            assertions.assertThat(getElementAttributeValue(menuGroup, ENABLED))
                    .as("Menu group should be enabled").isEqualTo(isTrue);
            assertions.assertThat(getElementAttributeValue(menuGroup, FOCUSABLE))
                    .as("Menu group should be focusable").isEqualTo(isTrue);
        }
        assertions.assertAll();
    }
}
