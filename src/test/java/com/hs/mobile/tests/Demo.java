package com.hs.mobile.tests;

import com.hs.mobile.exception.TestExecutionException;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Epic("Smoke Tests")
@Feature("Homescreen Tests")
@Execution(ExecutionMode.CONCURRENT)
public class Demo extends BaseTest {

    @Test
    @Story("Homescreen verification")
    @Description("Verify all elements in homescreen are displayed")
    @Severity(SeverityLevel.CRITICAL)
    void verifyThatAllHomeScreenElementsAreDisplayed(TestInfo testInfo) {
        assertAll(
                () -> assertThat(homeScreen.isUseMyCurrentLocationTextDisplayed())
                        .as("Use my current location text is not displayed.").isTrue(),
                () -> assertThat(homeScreen.isUseMyCurrentLocationImageDisplayed()).as(
                        "Use my current location image is not displayed.").isTrue(),
                () -> assertThat(homeScreen.isFindRestaurantsButtonDisplayed()).as(
                        "Find restaurant button is not displayed.").isTrue(),
                () -> assertThat(homeScreen.isRestaurantsItemDisplayed())
                        .as("Restaurants item is not displayed.").isTrue(),
                () -> assertThat(homeScreen.isOrdersItemDisplayed())
                        .as("Orders item is not displayed.").isTrue(),
                () -> assertThat(homeScreen.isOffersItemDisplayed())
                        .as("Offers item is not displayed.").isTrue(),
                () -> assertThat(homeScreen.isMoreItemDisplayed())
                        .as("More item is not displayed.").isTrue()
        );
    }

    @Test
    @Story("Cart")
    @Description("verify adding item to the cart")
    @Severity(SeverityLevel.CRITICAL)
    void addAnItemToCart(TestInfo testInfo) {
        homeScreen.findRestaurants();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("Riyadh");
        locationsScreen.selectItemArea(0);
        locationsScreen.submitAddress();
        locationsScreen.insertAddressDescription("Test");
        locationsScreen.submitAddress();
        restaurantsListScreen.selectRestaurant(0);
        restaurantScreen.selectMenuItem(0);
        try {
            restaurantScreen.addMenuItem();
        } catch (Exception e) {
            throw new TestExecutionException("All restaurants are closed!", e);
        }
        restaurantScreen.goToCart();
    }
}
