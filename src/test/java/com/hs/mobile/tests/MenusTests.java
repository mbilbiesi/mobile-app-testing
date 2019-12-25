package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Feature("Menus Smoke Test")
@Story("Cover restaurant menu smoke test cases")
@Issue("HSAP-208")
@Listeners(TestListener.class)
public class MenusTests extends BaseTest {

    @Test(description = "While swiping through menu groups, they should display properly")
    public void navigateToRestaurantScreen_menuGroupsShouldDisplayProperly() {
        //When
        restaurantScreenSteps.goToRestaurantScreen("The Pizza Company");
        List<WebElement> menuGroups = restaurantScreenSteps.swipeThroughTheMenuGroups();
        //Then
        restaurantScreenSteps.verifyThatMenuGroupsDisplayProperly(menuGroups);
    }

    @Test(description = "Verify that calories display properly")
    public void navigateToRestaurantScreen_verifyCaloriesForAMenuItem() {
        //When
        restaurantScreenSteps.goToRestaurantScreen("Porygon - Soso");
        //
        restaurantScreenSteps.verifyThatCaloriesDisplayProperlyForAMenuItem();
    }
}