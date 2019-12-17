package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.data.Language;
import com.hs.mobile.rest.endpoints.MenusEndpoint;
import com.hs.mobile.rest.model.response.MenuGroup;
import com.hs.mobile.rest.model.response.MenusResponse;
import com.hs.mobile.screens.RestaurantScreen;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hs.mobile.data.Language.ARABIC;
import static com.hs.mobile.data.Language.ENGLISH;

@Feature("Menus Smoke Test")
@Story("Cover restaurant menu smoke test cases")
@Issue("HSAP-208")
@Listeners(TestListener.class)
public class MenusTests extends BaseTest {

    private Map<Language, List<String>> expectedMenuGroups = getExpectedMenuGroups();

    @BeforeMethod
    @Step("Go to restaurant screen")
    public void goToRestaurantScreen() {
        //Given
        homeScreen.viewSavedLocations();
        locationsScreen.searchForRestaurants();
        locationsScreen.insertLocation("Riyadh");
        locationsScreen.selectItemArea(0);
        locationsScreen.submitAddress();
        locationsScreen.submitAddress();
        restaurantsListScreen.searchForRestaurant("The Pizza Company");
        restaurantsListScreen.selectDisplayedRestaurant();
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
        List<WebElement> menuGroups = swipeThroughTheMenuGroups();
        //Then
        restaurantScreenSteps.verifyThatMenuGroupsDisplayProperly(menuGroups);
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

    @Step("Fetch expected menu groups using Menus API")
    public Map<Language, List<String>> getExpectedMenuGroups() {
        MenusEndpoint menusEndpoint = new MenusEndpoint();
        Map<String, String> params = new HashMap<>();
        Map<Language, List<String>> menuGroupNames = new HashMap<>();
        List<String> menuGroupsEn = new ArrayList<>();
        List<String> menuGroupAr = new ArrayList<>();

        params.put("branch_id", "521");
        List<MenuGroup> menuGroups = menusEndpoint.getMenusResponse(params).as(MenusResponse.class).getMenuGroups();

        for (MenuGroup menuGroup : menuGroups) {
            menuGroupAr.add(menuGroup.getName());
            menuGroupsEn.add(menuGroup.getNameEn());
        }

        menuGroupNames.put(ARABIC, menuGroupAr);
        menuGroupNames.put(ENGLISH, menuGroupsEn);
        return menuGroupNames;
    }
}