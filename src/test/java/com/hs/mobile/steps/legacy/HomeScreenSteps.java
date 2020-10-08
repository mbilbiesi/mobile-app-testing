package com.hs.mobile.steps.legacy;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.data.messages.ScreenLabelsProvider;
import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.android.HomeScreenSideMenu;
import com.hs.mobile.screens.android.LandingScreen;
import com.hs.mobile.screens.android.LocationMainScreen;
import com.hs.mobile.steps.BaseSteps;
import io.qameta.allure.Step;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class HomeScreenSteps extends BaseSteps {

  @NonNull private final LandingScreen landingScreen;
  @NonNull private final HomeScreenSideMenu homeScreenSideMenu;
  @NonNull private final RestaurantListScreenSteps restaurantSteps;
  @NonNull private final ScreenLabelsProvider screenLabel;
  @NonNull private final LocationMainScreen locationsScreen;

  public HomeScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    landingScreen = new LandingScreen(settings);
    homeScreenSideMenu = new HomeScreenSideMenu(settings);
    locationsScreen = new LocationMainScreen(settings);
    screenLabel = new ScreenLabelsProvider(settings);
    restaurantSteps = new RestaurantListScreenSteps(settings);
  }

  @Step("Find restaurants")
  public void findRestaurants() {
    tap(landingScreen.getFindRestaurantsButton());
    restaurantSteps.waitUntilRestaurantsAreLoaded();
  }

  @Step("View saved locations")
  public void viewSavedLocations() {
    tap(landingScreen.getLstHomeScreenAddresses());
  }

  @Step("Verify that all 'LandingScreen' elements are displayed correctly")
  public void verifyThatAllHomeElementsDisplayed() {
    verifyScreenElements(landingScreen);
  }

  @Step("Click the 'My Orders' button")
  public void clickMyOrdersButton() {
    tap(landingScreen.getOrdersItem());
  }

  @Step("Click the 'Find Restaurants' button")
  public void clickFindRestaurantsButton() {
    tap(landingScreen.getFindRestaurantsButton());
  }

  @Step("Click 'Select Location Manually' button")
  public void clickSelectLocationManually() {
    tap(landingScreen.getBtnSetLocation().get(0));
  }

  @Step("Click on restaurant icon")
  public void clickOnRestaurantIcon() {
    tap(landingScreen.getRestaurantsItem());
  }

  @Step("Click on more")
  public HomeScreenSteps clickOnMore() {
    tap(landingScreen.getMoreItem());
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
    String locationValue = landingScreen.getLblDeliveryValue().getText();

    assertThat(!locationValue.equals("")).as("Location isn't displayed correctly").isTrue();
  }

  @Step("Verify that landingScreen elements are displayed based on location")
  public void verifyHomeScreenElementsBasedOnLocation(boolean isLocationValid) {
    SoftAssertions soft = new SoftAssertions();

    if (isLocationValid) {
      int homeScreenBanners = landingScreen.getBannerRestaurantsGrocery().size();
      soft.assertThat(homeScreenBanners > 0)
          .as("Both restaurants and grocery banners are not showing on LandingScreen")
          .isTrue();
      soft.assertThat(landingScreen.getBtnRestaurantsOrGrocery().size() > 0)
          .as("Restaurants and Grocery buttons are not displayed")
          .isTrue();
      if (homeScreenBanners > 0) {
        soft.assertThat(homeScreenBanners == 2)
            .as("Restaurants or Grocery is not showing on landingScreen")
            .isTrue();
        soft.assertThat(landingScreen.getBtnRestaurantsOrGrocery().size() == 2)
            .as("Find Restaurants or Find Grocery button is not displayed")
            .isTrue();
      }
    } else {
      soft.assertThat(landingScreen.getImgMissingLocation().size() > 0)
          .as("No image indicating that location isn't covered is showing up")
          .isTrue();
      soft.assertThat(landingScreen.getLblMissingLocExplanation().size() > 0)
          .as("Description indicating that location isn't covered is not displaying")
          .isTrue();
      if (landingScreen.getLblMissingLocExplanation().size() > 0) {
        soft.assertThat(
                landingScreen
                    .getLblMissingLocExplanation()
                    .get(0)
                    .getText()
                    .equalsIgnoreCase(screenLabel.getMessageContent("home.location_not_covered")))
            .as(
                "Expected text: "
                    + screenLabel.getMessageContent("home.location_not_covered")
                    + "Actual text: "
                    + landingScreen.getLblMissingLocExplanation().get(0).getText())
            .isTrue();
      }
      soft.assertThat(landingScreen.getBtnSetLocation().size() > 0)
          .as("'Choose location' button is not displaying")
          .isTrue();
    }
    soft.assertAll();
  }

  @Step("Click 'Change Location' button")
  public boolean clickChangeLocationButton() {

    try {
      tap(landingScreen.getBtnSetLocation().get(0));
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
        //        soft.assertThat(locationMainScreen.getSearchButton().isDisplayed())
        //            .as("Customer isn't redirected to Map screen")
        //            .isTrue();
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
    landingScreen
        .getSavedLocations()
        .forEach(
            location -> {
              tap(landingScreen.getBtnMore().get(0));
              tap(landingScreen.getBtnEditOrDelete().get(1));
              tap(landingScreen.getLstHomeScreenAddresses());
            });
  }

  @Step("Edit location")
  public void editLocation() {
    tap(landingScreen.getBtnMore().get(0));
    tap(landingScreen.getBtnEditOrDelete().get(0));
  }

  @Step("Click on View Restaurants Button")
  public void clickViewRestaurantsButton() {
    tap(landingScreen.getBtnRestaurantsOrGrocery().get(0));
  }

  public void waitUntilHomeScreenIsLoaded() {
    wait.until(ExpectedConditions.visibilityOfAllElements(landingScreen.getFindRestaurantsButton()));
  }

  public void waitUntilNewLocationButtonDisplays() {
    wait.until(ExpectedConditions.visibilityOf(landingScreen.getBtnNewLocation()));
  }

  public void waitUntilRestaurantsAnGroceryWidgetsLoaded() {
    wait.until(ExpectedConditions.visibilityOf(landingScreen.getRestaurantsItem()));
  }

  public void clickAddNewLocation() {
    tap(landingScreen.getBtnNewLocation());
  }

  public void dismissPromotion() {
    try {
      tap(landingScreen.getLnkSkipPromotion());
    } catch (Exception e) {
      throw new TestExecutionException("Unable to dismiss Promotion", e);
    }
  }
}
