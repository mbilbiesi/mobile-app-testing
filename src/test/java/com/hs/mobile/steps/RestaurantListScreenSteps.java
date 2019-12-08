package com.hs.mobile.steps;

import com.hs.mobile.screens.RestaurantsListScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantListScreenSteps extends RestaurantsListScreen {

    public RestaurantListScreenSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Verify that all restaurants list screen objects are displayed correctly")
    public void verifyRestaurantsListLayout() {
        verifyScreenElements();
    }

    @Step("Search for a restaurant")
    public String searchForRestaurant(String keyword) {
        getTxtSearchRestaurants().sendKeys(keyword);
        hideKeyboard();
        return keyword;
    }

    @Step("Verify the restaurants that match the search criteria are returned")
    public void verifyReturnedRestaurants(String keyword) {
        int restaurantCountAfterSearch = getRestaurantsCount();

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(restaurantCountAfterSearch > 0)
                .as("No restaurants match the search criteria").isTrue();

        List<WebElement> restaurantTitles = getRestaurantTitle();

        for (WebElement restaurantTitle : restaurantTitles) {
            String titleText = restaurantTitle.getText();
            soft.assertThat(titleText.contains(keyword))
                    .as("The restaurant: " + titleText + " does not match the search criteria with the keyword: " + keyword)
                    .isTrue();
        }

        soft.assertAll();
    }

    @Step("Clear the search criteria")
    public int clearSearchCriteria() {
        int restaurantsCountAfterClearingSearch = 0;
        try {
            tap(getBtnClearSearchResult());
            restaurantsCountAfterClearingSearch = getRestaurantsCount();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return restaurantsCountAfterClearingSearch;
    }

    @Step("Verify that all restaurants are returned after clearing the search criteria")
    public void verifyAllRestaurantsAreReturned(int allRestaurantsCount, int searchRestaurantCount) {
        assertThat(allRestaurantsCount == searchRestaurantCount)
                .as("Not all restaurants are returned after clearing search criteria").isTrue();
    }

    @Step("Verify that recommended badge is showing next to a recommended restaurant")
    public void checkRecommendedBadge(boolean isRestaurantRecommended) {
        int restaurantCount = getRestaurantsCount();

        for (int i = 0; i < restaurantCount; i++) {
            assertThat(getRestaurantWidgets().get(i).isDisplayed())
                    .as("Recommended badge is not displayed for this restaurant")
                    .isEqualTo(isRestaurantRecommended);
        }
    }

    public int getRestaurantsCount() {
        return getRestaurantWidgets().size();
    }

    public void waitUntilRestaurantsAreLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getRestaurantList()));
    }
}
