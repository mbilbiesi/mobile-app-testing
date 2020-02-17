package com.hs.mobile.steps;

import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.HomeScreenSideMenu;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeScreenSteps extends BaseSteps {
  private HomeScreen homeScreen;
  private HomeScreenSideMenu homeScreenSideMenu;
  private RestaurantListScreenSteps restaurant;

  public HomeScreenSteps(AppiumDriver driver) {
    super(driver);
    homeScreen = new HomeScreen(driver);
    homeScreenSideMenu = new HomeScreenSideMenu(driver);
    restaurant = new RestaurantListScreenSteps(driver);
  }

  @Step("Find restaurants")
  public void findRestaurants() {
    tap(homeScreen.getFindRestaurantsButton());
    restaurant.waitUntilRestaurantsAreLoaded();
  }

  @Step("View saved locations")
  public void viewSavedLocations() {
    tap(homeScreen.getUseMyCurrentLocationText());
  }

  @Step("Verify that all 'Homescreen' elements are displayed correctly")
  public void verifyThatAllHomeElementsDisplayed() {
    verifyScreenElements();
  }

  @Step("Click the 'My Orders' button")
  public void clickMyOrdersButton() {
    tap(homeScreen.getOrdersItem());
  }

  @Step("Click the 'Find Restaurants' button")
  public void clickFindRestaurantsButton() {
    tap(homeScreen.getFindRestaurantsButton());
  }

  @Step("Click on restaurant icon")
  public void clickOnResturantIcon() {
    tap(homeScreen.getRestaurantsItem());
  }

  @Step("Click on more")
  public HomeScreenSteps clickOnMore() {
    tap(homeScreen.getMoreItem());
    return this;
  }

  @Step("Go to profile screen")
  public void goToProfile() {
    tap(homeScreenSideMenu.getProfile());
  }

  @Step("Go to profile screen")
  public void goToInvoices() {
    tap(homeScreenSideMenu.getInvoices());
  }

  @Step("Go to settings screen")
  public void goToSettings() {
    tap(homeScreenSideMenu.getSettings());
  }

  @Step("Go to payment options screen")
  public void goToPaymentOptions() {
    tap(homeScreenSideMenu.getPaymentOptions());
  }

  public void waitUntilHomescreenIsLoaded() {
    wait.until(ExpectedConditions.visibilityOfAllElements(homeScreen.getFindRestaurantsButton()));
  }

  public void dismissPromotion() {
    if (homeScreen.getLnkSkipPromotion().size() > 0) {
      tap(homeScreen.getLnkSkipPromotion().get(0));
    }
  }
}
