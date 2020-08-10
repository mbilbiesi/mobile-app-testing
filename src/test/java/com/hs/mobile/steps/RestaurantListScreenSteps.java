package com.hs.mobile.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.exception.TestExecutionException;

import com.hs.mobile.screens.android.RestaurantScreen;
import com.hs.mobile.screens.android.RestaurantsListScreen;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.api.Assumptions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RestaurantListScreenSteps extends BaseSteps {

  private static final int MAX_CAMPAIGNS_NUMBER = 8;
  @NonNull private final RestaurantsListScreen restaurantsListScreen;
  @NonNull private final RestaurantScreen restaurant;

  public RestaurantListScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    restaurantsListScreen = new RestaurantsListScreen(settings);
    restaurant = new RestaurantScreen(settings);
  }

  @Step("Verify that all restaurants list screen objects are displayed correctly")
  public void verifyRestaurantsListLayout() {
    restaurantsListScreen.verifyRestaurantsListElements();
  }

  @Step("Search for a restaurant")
  public String searchForRestaurant(String keyword) {
    restaurantsListScreen.getTxtSearchRestaurants().sendKeys(keyword);
    hideKeyboard();
    return keyword;
  }

  @Step("Verify the restaurants that match the search criteria are returned")
  public void verifyReturnedRestaurants(String keyword) {
    int restaurantCountAfterSearch = getRestaurantsCount(false);

    SoftAssertions soft = new SoftAssertions();
    soft.assertThat(restaurantCountAfterSearch > 0)
        .as("No restaurants match the search criteria")
        .isTrue();

    List<WebElement> restaurantTitles = restaurantsListScreen.getRestaurantTitle();

    for (WebElement restaurantTitle : restaurantTitles) {
      String titleText = restaurantTitle.getText();
      soft.assertThat(titleText.contains(keyword))
          .as(
              "The restaurant: "
                  + titleText
                  + " does not match the search criteria with the keyword: "
                  + keyword)
          .isTrue();
    }

    tap(restaurantsListScreen.getBtnClearSearchResult());

    soft.assertAll();
  }

  @Step("Clear the search criteria")
  public int clearSearchCriteria() {
    int restaurantsCountAfterClearingSearch = 0;
    try {
      tap(restaurantsListScreen.getBtnClearSearchResult());
      restaurantsCountAfterClearingSearch = getRestaurantsCount(false);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }

    return restaurantsCountAfterClearingSearch;
  }

  @Step("Verify that all restaurants are returned after clearing the search criteria")
  public void verifyAllRestaurantsAreReturned(int allRestaurantsCount, int searchRestaurantCount) {
    assertThat(allRestaurantsCount == searchRestaurantCount)
        .as("Not all restaurants are returned after clearing search criteria")
        .isTrue();
  }

  @Step("Verify that recommended badge is showing next to a recommended restaurant")
  public void checkRecommendedBadge(boolean isRestaurantRecommended) {
    int restaurantCount = getRestaurantsCount(true);
    SoftAssertions soft = new SoftAssertions();
    if (restaurantCount > 0) {
      for (int i = 0; i < restaurantCount; i++) {
        if (isRestaurantRecommended) {
          soft.assertThat(restaurantsListScreen.getRecommendedBadge().size() > 0)
              .as("Recommended badge is not displayed for this restaurant")
              .isTrue();
        } else {
          soft.assertThat(restaurantsListScreen.getRecommendedBadge().size() > 0)
              .as("Recommended badge is displayed even though the restaurant is not recommended")
              .isFalse();
        }
      }
    } else {
      soft.assertThat(restaurantCount > 0)
          .as(
              "Unable to verify that recommended badge is displayed since "
                  + "there are no restaurants matching the searck keyword")
          .isTrue();
    }
    clearSearchCriteria();

    soft.assertAll();
  }

  public ArrayList<Double> getDistanceOfDisplayedRestaurants(int restaurantCount) {
    ArrayList<Double> restaurantDistance = new ArrayList<>();
    String[] distaceText;
    double distance;

    for (int i = 0; i < restaurantCount; i++) {
      distaceText = restaurantsListScreen.getRestaurantDistance().get(i).getText().split(" ");
      distance = Double.parseDouble(distaceText[0]);
      restaurantDistance.add(distance);
    }

    return restaurantDistance;
  }

  @Step("Verify that restaurants are sorted by their distance from the customer")
  public void checkIfRestaurantsSortedByDistance(boolean restaurantsWithBadges) {
    Assumptions.assumeThat(restaurantsWithBadges)
        .as(
            "Restaurants sorting won't be correct because some restaurants are either recommended or"
                + "sponsored")
        .isFalse();
    int restaurantCount = getRestaurantsCount(true);
    boolean listSorted = false;
    ArrayList<Double> restaurantDistance = getDistanceOfDisplayedRestaurants(restaurantCount);
    listSorted =
        restaurantDistance.stream()
            .sorted()
            .collect(Collectors.toList())
            .equals(restaurantDistance);
    assertThat(listSorted)
        .as("Restaurants are not sorted according their distance " + "from customer's location")
        .isTrue();
  }

  public int getRestaurantsCount(boolean verifiableElements) {
    int restaurantCount;
    //    waitUntilRestaurantsAreLoaded();
    restaurantCount = restaurantsListScreen.getRestaurantWidgets().size();
    if (verifiableElements) {
      if (restaurantCount > 2) {
        restaurantCount = restaurantCount - 1;
      }
    }

    return restaurantCount;
  }

  public void waitUntilRestaurantsAreLoaded() {
    wait.until(
        ExpectedConditions.visibilityOfAllElements(restaurantsListScreen.getEleLocationValue()));
  }

  public void waitUntilCampaignRestaurantsAreLoaded() {
    wait.until(
        ExpectedConditions.visibilityOfAllElements(restaurantsListScreen.getRestaurantWidgets()));
  }

  @Step("Scroll down restaurants list")
  public boolean scrollDownRestaurantsList() {
    waitUntilRestaurantsAreLoaded();
    scrollByElement(restaurantsListScreen.getRestaurantsListWidget());
    if (restaurantsListScreen.getPromotedBadge().size() > 0
        || restaurantsListScreen.getRecommendedBadge().size() > 0) {
      return true;
    } else {
      return false;
    }
  }

  @Step("Verify promoted restaurants shows at the top")
  public void verifyPromotedRestaurantsDisplayOnTop() {
    List<WebElement> promotedRestaurant;
    SoftAssertions soft = new SoftAssertions();
    promotedRestaurant =
        restaurantsListScreen
            .getRestaurantWidgets()
            .get(0)
            .findElements(By.xpath(restaurantsListScreen.getPromotedBadgeLocator()));

    soft.assertThat(promotedRestaurant.size() > 0 && promotedRestaurant.get(0).isDisplayed())
        .as("Promoted restaurants" + "are not displayed at the top of restaurants list")
        .isTrue();
    soft.assertAll();
  }

  public int getFiltersCount() {
    return restaurantsListScreen.getBtnFilter().size();
  }

  @Step("Verify that restaurant filters are displayed")
  public void verifyRestaurantFiltersAreDisplayed() {
    int filtersCount;
    SoftAssertions soft = new SoftAssertions();

    filtersCount = getFiltersCount() - 1;

    for (int i = 0; i < filtersCount; i++) {
      soft.assertThat(restaurantsListScreen.getFiltersIcons().get(i).isDisplayed())
          .as("Filter icon isn't displayed for filter #" + (i + 1))
          .isTrue();
      soft.assertThat(restaurantsListScreen.getFiltersNames().get(i).isDisplayed())
          .as("Filter name isn't displayed for filter #" + i + 1)
          .isTrue();
    }

    soft.assertAll();
  }

  @Step("Verify that 'All' filter is displayed")
  public void verifyAllFiterIsDisplayed() {
    assertThat(isAllFilterDisplayed(restaurantsListScreen.getFiltersNames().get(0)))
        .as("'All' filter is not displayed")
        .isTrue();
  }

  @Step("Verify that 'All' filter is selected")
  public void verifyAllFiterIsSelectedAndColorIsYellow() {
    String filterColor;

    filterColor = getElementColor((MobileElement) restaurantsListScreen.getBtnFilter().get(0));

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
    MobileElement startElement =
        (MobileElement) restaurantsListScreen.getBtnFilter().get(endElementIndex);
    MobileElement endElement = (MobileElement) restaurantsListScreen.getBtnFilter().get(0);

    firstFilterTitle = restaurantsListScreen.getFiltersNames().get(0).getText();
    swipe(startElement, endElement);

    return firstFilterTitle;
  }

  @Step("Verify that customer was able to swipe the filters list")
  public void verifyFiltersSwipedSuccessfully(String filterTitleBeforeSwipe) {
    String filterTitleAfterSwipe = restaurantsListScreen.getFiltersNames().get(0).getText();

    assertThat(!filterTitleBeforeSwipe.equals(filterTitleAfterSwipe))
        .as("Customer wasn't able to do swipe action on the filters list")
        .isTrue();
  }

  @Step("Verify that top banner image ration is 2:1")
  public void verifyTopBannerImageRatio() {
    Dimension topBannerSize;
    double bannerHeight;
    double bannerWidth;

    topBannerSize = restaurantsListScreen.getOfferWidgets().get(0).getSize();
    bannerHeight = topBannerSize.getHeight();
    bannerWidth = topBannerSize.getWidth();

    assertThat(bannerWidth == bannerHeight * 2).as("Top banner ratio is not 2:1").isTrue();
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

    if (restaurantsListScreen.getOfferWidgets().size() > 0) {
      topBannerHasOffers = true;
    }

    return topBannerHasOffers;
  }

  public void clickTopBanner(boolean topBannerHasOffers) {
    if (topBannerHasOffers) {
      tap(restaurantsListScreen.getOfferWidgets().get(0));
    }
  }

  public void verifyCustomerRedirectedToARestaurant() {
    if (restaurant.getBtnAcceptOffer().size() > 0) {
      tap(restaurant.getBtnAcceptOffer().get(0));
    }
    SoftAssertions soft = new SoftAssertions();
    try {
      soft.assertThat(restaurant.getRestaurantTitle().isDisplayed())
          .as("Top banner doesn't have restaurant offers")
          .isTrue();
      navigateBack(1);
      soft.assertAll();
    } catch (ElementNotVisibleException e) {
      e.printStackTrace();
    }
  }

  @Step("Verify that campaigns are displayed in a separate carousel")
  public void verifyCampaignsDisplayInSeparateCarousel(boolean campaginsEnabled) {
    SoftAssertions soft = new SoftAssertions();
    if (campaginsEnabled) {
      try {
        soft.assertThat(restaurantsListScreen.getCampaignContainer().isDisplayed())
            .as("Campaigns section doesn't exist in the screen")
            .isTrue();
        soft.assertThat(restaurantsListScreen.getCampainBanners().size() > 0)
            .as("No campaigns are displayed inside the campaigns section")
            .isTrue();
      } catch (TestExecutionException e) {
        e.printStackTrace();
      }
    } else {
      soft.assertThat(restaurantsListScreen.getCampainBanners().size() == 0)
          .as("Campaigns are displayed even though campaigns are disabled")
          .isTrue();
    }
    //        navigateBack(1);

    soft.assertAll();
  }

  @Step(
      "Verify that the max number of campaigns displyed in the campaigns carousel is "
          + MAX_CAMPAIGNS_NUMBER)
  public void verifyMaxCampaginsNumberInCarousel() {
    int campaignsCount = getCampaignsCount();
    int activeScreenCampagins = campaignsCount;

    WebElement lastVisibleCampaignBeforeSwipe =
        restaurantsListScreen.getCampainBanners().get(campaignsCount - 1);
    WebElement lastVisibleCampaignAfterSwipe;

    while (activeScreenCampagins > 4) {
      swipeCampaigns(campaignsCount);
      activeScreenCampagins = getCampaignsCount();

      lastVisibleCampaignAfterSwipe =
          restaurantsListScreen.getCampainBanners().get(activeScreenCampagins - 1);
      if (!lastVisibleCampaignBeforeSwipe
          .getText()
          .equalsIgnoreCase(lastVisibleCampaignAfterSwipe.getText())) {
        campaignsCount = campaignsCount + activeScreenCampagins;
      }

      if (lastVisibleCampaignBeforeSwipe
          .getText()
          .equals(lastVisibleCampaignAfterSwipe.getText())) {
        break;
      }
    }

    assertThat(campaignsCount <= MAX_CAMPAIGNS_NUMBER)
        .as(
            "Campagins count should be "
                + MAX_CAMPAIGNS_NUMBER
                + " as a maximum "
                + "while actual number of campagins is: "
                + campaignsCount)
        .isTrue();
  }

  public int getCampaignsCount() {
    return restaurantsListScreen.getCampainBanners().size();
  }

  public void swipeCampaigns(int campaignsCount) {
    int endElementIndex = campaignsCount - 1;
    MobileElement startElement = restaurantsListScreen.getCampainBanners().get(endElementIndex);
    MobileElement endElement = restaurantsListScreen.getCampainBanners().get(0);

    swipe(startElement, endElement);
  }

  @Step("Click one of the displayed campaigns")
  public void clickCampaign(boolean campaignsEnabled) {
    Assumptions.assumeThat(campaignsEnabled)
        .as("Campaigns are not enabled, so there's no campaign to check")
        .isTrue();

    waitUntilCampaignsAreLoaded();

    int randomCampaignIndex = getRandomCampaignIndex();

    tap(restaurantsListScreen.getCampainBanners().get(randomCampaignIndex));
    waitUntilCampaignRestaurantsAreLoaded();
  }

  @Step("Verify that restaurants are displayed based on the selected campaign")
  public void verifyCampaignRestaurants() {
    // ToDo: Implement an API call to verify that restaurants that display under a
    // campaign actually belong to it
    int restaurantsCount = restaurantsListScreen.getRestaurantWidgets().size();
    navigateBack(1);
    assertThat(restaurantsCount > 0).as("No restaurants are displayed for this campaign").isTrue();
  }

  private int getRandomCampaignIndex() {
    return RandomUtils.nextInt(0, getCampaignsCount());
  }

  @Step("Verify that campaign image ratio is 2:1")
  public void verifyCampaignImageRatio(boolean campaignsEnabled) {

    Assumptions.assumeThat(campaignsEnabled)
        .as("Campaigns are not enabled, so there's no campaign to check")
        .isTrue();

    Dimension campaignSize;
    double campaignHeight;
    double campaignWidth;
    boolean campaignImgDisplayed;

    campaignSize = restaurantsListScreen.getCampaignMainImage().getSize();
    campaignHeight = campaignSize.getHeight();
    campaignWidth = campaignSize.getWidth();

    navigateBack(1);

    assertThat(campaignWidth / campaignHeight).as("Campaign image ratio is not 2:1").isEqualTo(2);
  }

  public void navigateBackToRestaurantsList() {
    if (restaurantsListScreen.getRestaurantListLayout().size() == 0
        && restaurantsListScreen.getRestaurantWidgets().size() == 0) {
      navigateBack(1);
    }
  }

  public void waitUntilCampaignsAreLoaded() {
    wait.until(ExpectedConditions.visibilityOfAllElements(restaurantsListScreen.getOfferWidgets()));
  }

  @Step("Select displayed restaurant")
  public void selectDisplayedRestaurant() {
    tap(restaurantsListScreen.getRestaurantTitle().get(0));
    if (restaurant.getBtnAcceptOffer().size() > 0) {
      tap(restaurant.getBtnAcceptOffer().get(0));
    }
  }
}
