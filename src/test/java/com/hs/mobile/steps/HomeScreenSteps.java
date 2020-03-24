package com.hs.mobile.steps;

import com.hs.mobile.data.messages.MessagesProvider;
import com.hs.mobile.screens.HomeScreen;
import com.hs.mobile.screens.HomeScreenSideMenu;
import com.hs.mobile.screens.LocationsScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeScreenSteps extends BaseSteps {
  private HomeScreen homeScreen;
  private HomeScreenSideMenu homeScreenSideMenu;
  private RestaurantListScreenSteps restaurant;
  private static final Logger LOG = LoggerFactory.getLogger(MessagesProvider.class);
  private MessagesProvider messages;
  private LocationsScreen locationsScreen;
  private String language;

  public HomeScreenSteps(AppiumDriver driver, String language) {
    super(driver);
    homeScreen = new HomeScreen(driver);
    homeScreenSideMenu = new HomeScreenSideMenu(driver);
    restaurant = new RestaurantListScreenSteps(driver, language);
    locationsScreen = new LocationsScreen(driver);
    messages = new MessagesProvider(language);
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

  @Step("Verify that homescreen elements are displayed based on location")
  public void verifyHomescreenElementsBasedOnLocation(boolean isLocationValid) {
    SoftAssertions soft = new SoftAssertions();
    int homescreenBanners = homeScreen.getBannerRestuarantsGrocery().size();

    if (isLocationValid) {
      soft.assertThat(homescreenBanners > 0)
              .as("Both restaurants and grocery banners are not showing on Homescreen")
              .isTrue();
      soft.assertThat(homeScreen.getBtnRestaurantsOrGrocery().size() > 0)
              .as("Restaurants and Grocery buttons are not displayed")
              .isTrue();
      if (homescreenBanners > 0) {
        soft.assertThat(homescreenBanners == 2)
                .as("Restaurants or Grocery is not showing on homescreen")
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
                        .equalsIgnoreCase(messages.getMessageContent("location not covered")))
                .as(
                        "Expected text: "
                                + messages.getMessageContent("location not covered")
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
      LOG.error("The 'Select Location' button has not been found");
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
        LOG.error("Element has not been found, or customer has not been redirected to Map screen");
      }
      soft.assertAll();
    }
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
