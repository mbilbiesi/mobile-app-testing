package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.screens.RestaurantScreen;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Feature("Menus Smoke Test")
@Story("Cover restaurant menu smoke test cases")
@Issue("HSAP-208")
@Listeners(TestListener.class)
public class MenusTests extends BaseTest {

    @Test(description = "While swiping through menu groups, they should display properly")
    public void navigateToRestaurantScreen_menuGroupsShouldDisplayProperly() {
        //Given
        goToRestaurantScreen();
        //When
        List<WebElement> menuGroups = swipeThroughTheMenuGroups();
        //Then
        restaurantScreenSteps.verifyThatMenuGroupsDisplayProperly(menuGroups);
    }

    @Step("Go to restaurant screen")
    public void goToRestaurantScreen() {
        homeScreen.clickFindRestaurantsButton();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("Riyadh");
        locationsScreen.selectItemArea(0);
        locationsScreen.submitAddress();
        locationsScreen.submitAddress();
        restaurantsListScreen.searchForRestaurant("The Pizza Company");
        restaurantsListScreen.selectDisplayedRestaurant();
    }

    @Step("Swipe through the menu groups")
    public List<WebElement> swipeThroughTheMenuGroups() {
        List<WebElement> menuGroups = restaurantScreen.getMenuGroups();
        restaurantScreen.swipe(menuGroups.get(3), menuGroups.get(0));
        restaurantScreen.swipe(menuGroups.get(2), menuGroups.get(0));
        restaurantScreen = new RestaurantScreen(driver);
        return Stream
                .concat(menuGroups.stream(), restaurantScreen.getMenuGroups().stream())
                .distinct()
                .collect(Collectors.toList());
    }
}