package com.hs.mobile.steps;

import com.hs.mobile.screens.RestaurantScreen;
import com.hs.mobile.screens.RestaurantsListScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
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

    RestaurantScreen restaurant = new RestaurantScreen(driver);

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
    public void verifyPromotedRestaurantsDisplayOnTop() {
        List<WebElement> promotedRestaurant;
        SoftAssertions soft = new SoftAssertions();
        promotedRestaurant = getRestaurantWidgets().get(0).findElements(By.xpath(getPromotedBadgeLocator()));

        soft.assertThat(promotedRestaurant.size() > 0 && promotedRestaurant.get(0).isDisplayed())
                .as("Promoted restaurants" +
                        "are not displayed at the top of restaurants list").isTrue();
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

    @Step("Verify that 'All' filter is displayed")
    public void verifyAllFiterIsDisplayed() {
        assertThat(isAllFilterDisplayed(getFiltersNames().get(0)))
                .as("'All' filter is not displayed").isTrue();
    }

    @Step("Verify that 'All' filter is selected")
    public void verifyAllFiterIsSelectedAndColorIsYellow() {
        String filterColor;
        filterColor = getElementColor((MobileElement) getBtnFilter().get(0));

        assertThat(filterColor.equalsIgnoreCase("#ffd700"))
                .as("The 'All' filter isn't selected, and it's color isn't yellow");
    }

    public boolean isAllFilterDisplayed(WebElement allFilter) {
        boolean isDisplayed = false;

        if (allFilter.getText().equals("All") || allFilter.getText().equals("الكل")) {
            isDisplayed = true;
        }

        return isDisplayed;
    }

    @Step("Swipe filters list")
    public String swipeFiltersList() {
        String firstFilterTitle;
        int endElementIndex = getFiltersCount() - 1;
        MobileElement startElement = (MobileElement) getBtnFilter().get(endElementIndex);
        MobileElement endElement = (MobileElement) getBtnFilter().get(0);

        firstFilterTitle = getFiltersNames().get(0).getText();
        swipe(startElement, endElement);

        return firstFilterTitle;
    }

    @Step("Verify that customer was able to swipe the filters list")
    public void verifyFiltersSwipedSuccessfully(String filterTitleBeforeSwipe) {
        String filterTitleAfterSwipe = getFiltersNames().get(0).getText();

        assertThat(!filterTitleBeforeSwipe.equals(filterTitleAfterSwipe))
                .as("Customer wasn't able to do swipe action on the filters list").isTrue();
    }

    @Step("Verify that top banner image ration is 2:1")
    public void verifyTopBannerImageRatio() {
        Dimension topBannerSize;
        double bannerHeight;
        double bannerWidth;

        topBannerSize = getOfferWidgets().get(0).getSize();
        bannerHeight = topBannerSize.getHeight();
        bannerWidth = topBannerSize.getWidth();

        assertThat(bannerWidth == bannerHeight * 2)
                .as("Top banner ratio is not 2:1").isTrue();
    }

    @Step("Verify that top banner shows restaurant offers")
    public void verifyTopBannerShowsOnlyOffers() {
        boolean topBannerHasOffers;

        topBannerHasOffers = checkTopBanner();
        clickTopBanner(topBannerHasOffers);
        verifyCustomerRedirectedToARestaurant();
    }

    public boolean checkTopBanner() {
        boolean topBannerHasOffers = false;

        if (getOfferWidgets().size() > 0) {
            topBannerHasOffers = true;
        }

        return topBannerHasOffers;
    }

    public void clickTopBanner(boolean topBannerHasOffers) {
        if (topBannerHasOffers) {
            tap(getOfferWidgets().get(0));
        }
    }

    public void verifyCustomerRedirectedToARestaurant() {
        SoftAssertions soft = new SoftAssertions();

        try {
            soft.assertThat(restaurant.getRestaurantHeader().isDisplayed())
                    .as("Top banner doesn't have restaurant offers").isTrue();
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }
}
