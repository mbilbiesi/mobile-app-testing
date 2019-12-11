package com.hs.mobile.steps;

import com.hs.mobile.screens.RestaurantsListScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        int restaurantCountAfterSearch = getRestaurantsCount(false);

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
            restaurantsCountAfterClearingSearch = getRestaurantsCount(false);
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
        int restaurantCount = getRestaurantsCount(true);
        SoftAssertions soft = new SoftAssertions();

        for (int i = 0; i < restaurantCount; i++) {
            if (isRestaurantRecommended) {
                soft.assertThat(getRecommendedBadge().size() > 0)
                        .as("Recommended badge is not displayed for this restaurant").isTrue();
            } else {
                soft.assertThat(getRecommendedBadge().size() > 0)
                        .as("Recommended badge is displayed even though the restaurant is not recommended")
                        .isFalse();
            }
        }
    }

    public ArrayList<Double> getDistanceOfDisplayedRestaurants(int restaurantCount) {
        ArrayList<Double> restaurantDistance = new ArrayList<>();
        String[] distaceText;
        double distance;

        for (int i = 0; i < restaurantCount; i++) {
            distaceText = getRestaurantDistance().get(i).getText().split(" ");
            distance = Double.parseDouble(distaceText[0]);
            restaurantDistance.add(distance);
        }

        return restaurantDistance;
    }

    @Step("Verify that restaurants are sorted by their distance from the customer")
    public void checkIfRestaurantsSortedByDistance() {
        int restaurantCount = getRestaurantsCount(true);
        boolean listSorted = false;
        ArrayList<Double> restaurantDistance = getDistanceOfDisplayedRestaurants(restaurantCount);
        listSorted = restaurantDistance.stream().sorted().collect(Collectors.toList()).equals(restaurantDistance);
        assertThat(listSorted).as("Restaurants are not sorted according their distance " +
                "from customer's location").isTrue();
    }

    public int getRestaurantsCount(boolean verifiableElements) {
        int restaurantCount;
        waitUntilRestaurantsAreLoaded();
        restaurantCount = getRestaurantWidgets().size();
        if (verifiableElements) {
            if (restaurantCount > 2) {
                restaurantCount = restaurantCount - 1;
            }
        }

        return restaurantCount;
    }

    public void waitUntilRestaurantsAreLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getRestaurantList()));
    }

    @Step("Scroll down restaurants list")
    public void scrollDownRestaurantsList() {
        waitUntilRestaurantsAreLoaded();
        scrollByElement(getRestaurantsListWidget());
    }

    @Step("Verify promoted restaurants shows at the top")
    public void verifyPromotedRestaurantsDisplayOnTop(boolean listHasPromotedRestaurants) {
        List<WebElement> promotedRestaurant;
        SoftAssertions soft = new SoftAssertions();
        promotedRestaurant = getRestaurantWidgets().get(0).findElements(By.xpath(getPromotedBadgeLocator()));
        if (listHasPromotedRestaurants) {
            soft.assertThat(promotedRestaurant.size() > 0 && promotedRestaurant.get(0).isDisplayed())
                    .as("Promoted restaurants" +
                            "are not displayed at the top of restaurants list").isTrue();
        }
    }

    public int getFiltersCount() {
        return getBtnFilter().size();
    }

    @Step("Verify that restaurant filters are displayed")
    public void verifyRestaurantFiltersAreDisplayed() {
        int filtersCount;
        SoftAssertions soft = new SoftAssertions();

        filtersCount = getFiltersCount() - 1;

        for (int i = 0; i < filtersCount; i++) {
            soft.assertThat(getFiltersIcons().get(i).isDisplayed())
                    .as("Filter icon isn't displayed for filter #" + (i + 1)).isTrue();
            soft.assertThat(getFiltersNames().get(i).isDisplayed())
                    .as("Filter name isn't displayed for filter #" + i + 1).isTrue();
        }
    }
}
