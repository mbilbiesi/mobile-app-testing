package com.hs.mobile.steps;

import com.hs.mobile.screens.MenuItemScreen;
import com.hs.mobile.screens.RestaurantScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hs.mobile.data.ElementAttribute.CLICKABLE;
import static com.hs.mobile.data.ElementAttribute.ENABLED;
import static com.hs.mobile.data.ElementAttribute.FOCUSABLE;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class RestaurantScreenSteps extends BaseSteps {
  private RestaurantScreen restaurantScreen;
  private MenuItemScreen menuItemScreen;
  private HomeScreenSteps homeScreenSteps;
  private LocationScreenSteps locationScreenSteps;
  private RestaurantListScreenSteps restaurantListScreenSteps;
  private MenuItemScreenSteps menuItemScreenSteps;

  public RestaurantScreenSteps(AppiumDriver driver) {
    super(driver);
    restaurantScreen = new RestaurantScreen(driver);
    menuItemScreen = new MenuItemScreen(driver);
    homeScreenSteps = new HomeScreenSteps(driver);
    locationScreenSteps = new LocationScreenSteps(driver);
    restaurantListScreenSteps = new RestaurantListScreenSteps(driver);
    menuItemScreenSteps = new MenuItemScreenSteps(driver);
  }

  @Step("Go to restaurant screen")
  public void goToRestaurantScreen(String restaurantName) {
    // Given
    homeScreenSteps.viewSavedLocations();
    locationScreenSteps.searchForRestaurants();
    locationScreenSteps.insertLocation("Riyadh");
    locationScreenSteps.selectItemArea(0);
    locationScreenSteps.submitAddress();
    locationScreenSteps.submitAddress();
    restaurantListScreenSteps.searchForRestaurant(restaurantName);
    restaurantListScreenSteps.selectDisplayedRestaurant();
  }

  @Step("Verify that menu groups display properly")
  public void verifyThatMenuGroupsDisplayProperly(List<WebElement> menuGroups) {
    SoftAssertions soft = new SoftAssertions();
    String isTrue = String.valueOf(true);
    for (WebElement menuGroup : menuGroups) {
      soft.assertThat(getElementAttributeValue(menuGroup, CLICKABLE))
          .as("Menu group should be clickable")
          .isEqualTo(isTrue);
      soft.assertThat(getElementAttributeValue(menuGroup, ENABLED))
          .as("Menu group should be enabled")
          .isEqualTo(isTrue);
      soft.assertThat(getElementAttributeValue(menuGroup, FOCUSABLE))
          .as("Menu group should be focusable")
          .isEqualTo(isTrue);
    }
    navigateBack(3);
    soft.assertAll();
  }

  @Step("Swipe through the menu groups")
  public List<WebElement> swipeThroughTheMenuGroups() {
    List<WebElement> menuGroups = restaurantScreen.getMenuGroups();
    swipe(menuGroups.get(3), menuGroups.get(0));
    swipe(menuGroups.get(2), menuGroups.get(0));
    return Stream.concat(menuGroups.stream(), restaurantScreen.getMenuGroups().stream())
        .distinct()
        .collect(Collectors.toList());
  }

  @Step("Verify that calories display properly for a menu item")
  public void verifyThatCaloriesDisplayProperlyForAMenuItem() {
    SoftAssertions soft = new SoftAssertions();

    soft.assertThat(isElementActive(restaurantScreen.getCaloriesIcon()))
        .as("Calories icon should be active")
        .isTrue();
    soft.assertThat(isElementActive(restaurantScreen.getCaloriesLabel()))
        .as("Calories label should be active")
        .isTrue();
    soft.assertThat(isElementActive(restaurantScreen.getFirstMenuItemName()))
        .as("Menu item should be active")
        .isTrue();

    String caloriesLabel = restaurantScreen.getCaloriesLabel().getText();
    String firstMenuItemName = restaurantScreen.getFirstMenuItemName().getText();

    tap(restaurantScreen.getFirstMenuItem());

    wait.until(ExpectedConditions.visibilityOf(menuItemScreen.getTxtTitle()));

    soft.assertThat(isElementActive(menuItemScreen.getCaloriesIcon()))
        .as("Calories icon should be active.")
        .isTrue();
    soft.assertThat(isElementActive(menuItemScreen.getCaloriesLabel()))
        .as("Calories label should be active.")
        .isTrue();
    soft.assertThat(isElementActive(menuItemScreen.getCaloriesTotal()))
        .as("Calories total should be active.")
        .isTrue();
    soft.assertThat(caloriesLabel)
        .as("Calories details should match.")
        .isEqualTo(
            menuItemScreen.getCaloriesTotal().getText()
                + " "
                + menuItemScreen.getCaloriesLabel().getText().toLowerCase());
    soft.assertThat(firstMenuItemName)
        .as("Menu item details should match.")
        .isEqualTo(menuItemScreen.getTxtTitle().getText());

    navigateBack(4);
    soft.assertAll();
  }

  @Step("Add first item to cart for {count} time(s)")
  public Double addFirstItemToCart(int count) {
    if (count <= 0) {
      return null;
    }
    tap(restaurantScreen.getFirstMenuItem());
    int i = 0;
    while (i < count) {
      menuItemScreenSteps.addQuantity();
      i++;
    }
    menuItemScreenSteps.addToCart();
    return menuItemScreenSteps.getTotalAmount();
  }

  @Step("Get delivery fee from the restaurant screen")
  public Double getDeliveryFee() {
    String deliveryFeeLabel = restaurantScreen.getDeliveryAmount().getText().trim();
    return Double.parseDouble(deliveryFeeLabel.substring(0, deliveryFeeLabel.indexOf(' ')));
  }

  @Step("Go to checkout screen")
  public void goToCheckout() {
    tap(restaurantScreen.getViewCart());
  }

  private void swipe(WebElement startElement, WebElement endElement) {
    touchAction
        .longPress(
            longPressOptions()
                .withElement(element(startElement))
                .withDuration(Duration.ofMillis(500)))
        .moveTo(element(endElement))
        .release()
        .perform();
  }
}
