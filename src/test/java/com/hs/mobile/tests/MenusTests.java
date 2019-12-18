package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.data.Language;
import com.hs.mobile.steps.ApiSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static com.hs.mobile.data.Language.ARABIC;
import static com.hs.mobile.data.Language.ENGLISH;

@Feature("Menus Smoke Test")
@Story("Cover restaurant menu smoke test cases")
@Issue("HSAP-208")
@Listeners(TestListener.class)
public class MenusTests extends BaseTest {

    private Map<Language, List<String>> expectedMenuGroups = new ApiSteps().getExpectedMenuGroups();

    @BeforeMethod
    public void goToRestaurantScreen() {
        //Given
        restaurantScreenSteps.goToRestaurantScreen();
    }

    @Test
    public void navigateToRestaurantScreen_menuGroupsShouldBeVerified() {
        //When
        Language selectedLanguage = restaurantScreenSteps.getSelectedLanguage().equals(ENGLISH) ? ENGLISH : ARABIC;
        List<String> displayedMenuGroups = restaurantScreenSteps.getDisplayedMenuGroups();
        //Then
        restaurantScreenSteps.verifyDisplayedMenuGroups(
                displayedMenuGroups, expectedMenuGroups, selectedLanguage);
    }

    @Test(description = "While swiping through menu groups, they should display properly")
    public void navigateToRestaurantScreen_menuGroupsShouldDisplayProperly() {
        //When
        List<WebElement> menuGroups = restaurantScreenSteps.swipeThroughTheMenuGroups();
        //Then
        restaurantScreenSteps.verifyThatMenuGroupsDisplayProperly(menuGroups);
    }
}