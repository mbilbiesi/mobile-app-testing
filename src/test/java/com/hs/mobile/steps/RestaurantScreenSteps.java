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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hs.mobile.data.ElementAttribute.CLICKABLE;
import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.FOCUSABLE;
import static com.hs.mobile.data.Language.ARABIC;
import static com.hs.mobile.data.Language.ENGLISH;

public class RestaurantScreenSteps extends RestaurantScreen {
    private HomeScreenSteps homeScreenSteps = new HomeScreenSteps(driver);
    private LocationScreenSteps locationScreenSteps = new LocationScreenSteps(driver);
    private RestaurantListScreenSteps restaurantListScreenSteps = new RestaurantListScreenSteps(driver);

    public RestaurantScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Go to restaurant screen")
    public void goToRestaurantScreen() {
        //Given
        homeScreenSteps.viewSavedLocations();
        locationScreenSteps.searchForRestaurants();
        locationScreenSteps.insertLocation("Riyadh");
        locationScreenSteps.selectItemArea(0);
        locationScreenSteps.submitAddress();
        locationScreenSteps.submitAddress();
        restaurantListScreenSteps.searchForRestaurant("The Pizza Company");
        restaurantListScreenSteps.selectDisplayedRestaurant();
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

    @Step("Swipe through the menu groups")
    public List<WebElement> swipeThroughTheMenuGroups() {
        List<WebElement> menuGroups = getMenuGroups();
        swipe(menuGroups.get(3), menuGroups.get(0));
        swipe(menuGroups.get(2), menuGroups.get(0));
        RestaurantScreen restaurantScreen = new RestaurantScreen(driver);
        return Stream
                .concat(menuGroups.stream(), restaurantScreen.getMenuGroups().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    private void waitUntilHeaderIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getMenuGroupHeader()));
    }
}
