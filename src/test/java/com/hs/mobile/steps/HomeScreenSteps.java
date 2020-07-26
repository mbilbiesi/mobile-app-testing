package com.hs.mobile.steps;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.data.messages.ScreenLabelsProvider;
import com.hs.mobile.screens.android.HomeScreen;
import com.hs.mobile.screens.android.HomeScreenSideMenu;
import com.hs.mobile.screens.android.LocationsScreen;
import io.qameta.allure.Step;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class HomeScreenSteps extends BaseSteps {

  @NonNull private final HomeScreen homeScreen;
  @NonNull private final HomeScreenSideMenu homeScreenSideMenu;
  @NonNull private final RestaurantListScreenSteps restaurantSteps;
  @NonNull private final ScreenLabelsProvider screenLabel;
  @NonNull private final LocationsScreen locationsScreen;

  public HomeScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    homeScreen = new HomeScreen(settings);
    homeScreenSideMenu = new HomeScreenSideMenu(settings);
    locationsScreen = new LocationsScreen(settings);
    screenLabel = new ScreenLabelsProvider(settings);
    restaurantSteps = new RestaurantListScreenSteps(settings);
  }

  @Step("Find restaurants")
  public void findRestaurants() {
    tap(homeScreen.getFindRestaurantsButton());
    restaurantSteps.waitUntilRestaurantsAreLoaded();
  }

  @Step("View saved locations")
  public void viewSavedLocations() {
    tap(homeScreen.getLstHomeScreenAddresses());
  }

  @Step("Verify that all 'HomeScreen' elements are displayed correctly")
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

  @Step("Click 'Select Location Manually' button")
  public void clickSelectLocationManually() {
    tap(homeScreen.getBtnSetLocation().get(0));
  }

  @Step("Click on restaurant icon")
  public void clickOnRestaurantIcon() {
    tap(homeScreen.getRestaurantsItem());
  }

  @Step("Click on more")
  public HomeScreenSteps clickOnMore() {
    tap(homeScreen.getMoreItem());
    return this;
  }

  @Step("Go to profile screen")
  public void goToProfile() {
    tap(homeScreenSideMenu.getBtnProfile());
  }

  @Step("Go to profile screen")
  public void goToInvoices() {
    tap(homeScreenSideMenu.getBtnInvoices());
  }

  @Step("Go to settings screen")
  public void goToSettings() {
    tap(homeScreenSideMenu.getBtnSettings());
  }

  @Step("Go to payment options screen")
  public void goToPaymentOptions() {
    tap(homeScreenSideMenu.getBtnPaymentOptions());
  }

  @Step("Verify location is acquired by hs app")
  public void verifyLocationAcquiredCorrectly() {
    String locationValue = homeScreen.getLblDeliveryValue().getText();

    assertThat(!locationValue.equals("")).as("Location isn't displayed correctly").isTrue();
  }

  @Step("Verify that homeScreen elements are displayed based on location")
  public void verifyHomeScreenElementsBasedOnLocation(boolean isLocationValid) {
    SoftAssertions soft = new SoftAssertions();

    if (isLocationValid) {
      int homeScreenBanners = homeScreen.getBannerRestaurantsGrocery().size();
      soft.assertThat(homeScreenBanners > 0)
          .as("Both restaurants and grocery banners are not showing on HomeScreen")
          .isTrue();
      soft.assertThat(homeScreen.getBtnRestaurantsOrGrocery().size() > 0)
          .as("Restaurants and Grocery buttons are not displayed")
          .isTrue();
      if (homeScreenBanners > 0) {
        soft.assertThat(homeScreenBanners == 2)
            .as("Restaurants or Grocery is not showing on homeScreen")
            .isTrue();
        soft.assertThat(homeScreen.getBtnRestaurantsOrGrocery().size() == 2)
            .as("Find Restaurants or Find Grocery button is not displayed")
            .isTrue();
      }
    } else {
      soft.assertThat(homeScreen.getImgMissingLocation().size() > 0)
          .as("No image indicating that location isn't covered is showing up")
          .isTrue();
      soft.assertThat(homeScreen.getLblMissingLocExplanation().size() > 0)
          .as("Description indicating that location isn't covered is not displaying")
          .isTrue();
      if (homeScreen.getLblMissingLocExplanation().size() > 0) {
        soft.assertThat(
                homeScreen
                    .getLblMissingLocExplanation()
                    .get(0)
                    .getText()
                    .equalsIgnoreCase(screenLabel.getMessageContent("home.location_not_covered")))
            .as(
                "Expected text: "
                    + screenLabel.getMessageContent("home.location_not_covered")
                    + "Actual text: "
                    + homeScreen.getLblMissingLocExplanation().get(0).getText())
            .isTrue();
      }
      soft.assertThat(homeScreen.getBtnSetLocation().size() > 0)
          .as("'Choose location' button is not displaying")
          .isTrue();
    }
    soft.assertAll();
  }

  @Step("Click 'Change Location' button")
  public boolean clickChangeLocationButton() {

    try {
      tap(homeScreen.getBtnSetLocation().get(0));
      return true;
    } catch (NoSuchElementException e) {
      log.error("The 'Select Location' button has not been found");
      e.printStackTrace();
      return false;
    }
  }

  @Step("Verify that customer has been redirected to Map")
  public void verifyCustomerRedirectedToMap(boolean customerOnMap) {
    SoftAssertions soft = new SoftAssertions();
    if (customerOnMap) {
      try {
        soft.assertThat(locationsScreen.getSearchButton().isDisplayed())
            .as("Customer isn't redirected to Map screen")
            .isTrue();
      } catch (ElementNotVisibleException e) {
        e.printStackTrace();
        log.error("Element has not been found, or customer has not been redirected to Map screen");
      }

      navigateBack(1);
      soft.assertAll();
    }
  }

  @Step("Delete saved locations")
  public void deleteSavedLocations() {
    homeScreen
        .getSavedLocations()
        .forEach(
            location -> {
              tap(homeScreen.getBtnMore().get(0));
              tap(homeScreen.getBtnEditOrDelete().get(1));
              //tap(homeScreen.getLstHomescreenAddresses());
            });
  }

  @Step("Edit location")
  public void editLocation() {
    tap(homeScreen.getBtnMore().get(0));
    tap(homeScreen.getBtnEditOrDelete().get(0));
  }

  @Step("Click on View Restaurants Button")
  public void clickViewRestaurantsButton() {
    tap(homeScreen.getBtnRestaurantsOrGrocery().get(0));
  }

  public void waitUntilHomeScreenIsLoaded() {
    wait.until(ExpectedConditions.visibilityOfAllElements(homeScreen.getFindRestaurantsButton()));
  }

  public void waitUntilNewLocationButtonDisplays() {
    wait.until(ExpectedConditions.visibilityOf(homeScreen.getBtnNewLocation()));
  }

  public void waitUntilRestaurantsAnGroceryWidgetsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(homeScreen.getRestaurantsItem()));
  }

  public void clickAddNewLocation() {
    tap(homeScreen.getBtnNewLocation());
  }

  public void dismissPromotion() {
    try {
      tap(homeScreen.getLnkSkipPromotion());
    } catch (Exception e) {

    }
  }
}
