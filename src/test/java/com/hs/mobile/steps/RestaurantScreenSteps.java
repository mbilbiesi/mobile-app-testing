package com.hs.mobile.steps;

import com.hs.mobile.data.Language;
import com.hs.mobile.screens.RestaurantScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.hs.mobile.data.ElementAttribute.CLICKABLE;
import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.FOCUSABLE;
import static com.hs.mobile.data.Language.ARABIC;
import static com.hs.mobile.data.Language.ENGLISH;

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
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        assertions.assertAll();
    }

    @Step("Extract menu groups from restaurant screen")
    public List<String> getDisplayedMenuGroups() {
        List<String> menuGroups = new ArrayList<>();

        for (WebElement menuGroup : getMenuGroups()) {
            tap(menuGroup);
            waitUntilHeaderIsLoaded();
            menuGroups.add(getMenuGroupHeader().getText());
        }

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        return menuGroups;
    }

    @Step("Verify that displayed menu groups match expected ones")
    public void verifyDisplayedMenuGroups(List<String> actualMenuGroups,
                                          Map<Language, List<String>> multilingualExpectedMenuGroups,
                                          Language selectedLanguage) {
        SoftAssertions assertions = new SoftAssertions();
        List<String> expectedMenuGroups = selectedLanguage.equals(ENGLISH) ? multilingualExpectedMenuGroups.get(ENGLISH)
                : multilingualExpectedMenuGroups.get(ARABIC);

        for (String menuGroup : actualMenuGroups) {
            assertions.assertThat(expectedMenuGroups.contains(menuGroup))
                    .as(String.format("Menu group [%s] is incorrectly displayed.", menuGroup)).isTrue();
        }
        assertions.assertAll();
    }

    @Step("Determine the selected language")
    public Language getSelectedLanguage() {
        String title = getRestaurantTitle().getText();
        if (title.matches("^[a-zA-Z0-9$@$!%*?&#^-_. +]+$")) {
            return ENGLISH;
        } else return ARABIC;
    }

    private void waitUntilHeaderIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getMenuGroupHeader()));
    }
}
