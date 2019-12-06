package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantsListScreen extends AbstractScreen {

    public RestaurantsListScreen(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_icon")
    @AssertElementVisibility
    private WebElement imgLocationIcon;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_value")
    @AssertElementVisibility
    private WebElement eleLocationValue;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/input")
    @AssertElementVisibility
    private WebElement txtSearchRestaurants;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon_start")
    @AssertElementVisibility
    private WebElement imgSearchIcon;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/viewpager")
    @AssertElementVisibility
    private WebElement eleOffersContainer;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/image")
    @AssertElementVisibility
    private List<WebElement> offerWidgets;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_container")
    @AssertElementVisibility
    private WebElement campaignContainer;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_banner")
    @AssertElementVisibility
    private List<WebElement> campainBanners;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_component")
    @AssertElementVisibility
    private WebElement filtersWidget;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_filter")
    private List<WebElement> btnFilter;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_name")
    @AssertElementVisibility
    private List<WebElement> filtersNames;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_icon")
    @AssertElementVisibility
    private List<WebElement> filtersIcons;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/RestListView")
    @AssertElementVisibility
    private WebElement restaurantsListWidget;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
    private List<WebElement> restaurantList;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
    @AssertElementVisibility
    private List<WebElement> restaurantWidgets;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/title")
    private List<WebElement> restaurantTitle;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/description")
    private List<WebElement> restaurantType;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/distance_value")
    private List<WebElement> restaurantDistance;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_title")
    private List<WebElement> deliveryText;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_value")
    private List<WebElement> deliveryFeeValue;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/delivery_fee_currency")
    private List<WebElement> deliveryFeeCurrency;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/label_desc")
    private List<WebElement> restaurantDeliveryInfo;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon")
    private List<WebElement> restaurantDeliveryInfoIcon;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//*[@text='يوصى به' or @text='recommended']")
    private List<WebElement> recommendedBadge;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//*[@id='com.hungerstation.android.web.debug:id/value'" +
            " and not(@text='يوصى به' or @text='recommended')]")
    private WebElement branchStatusBadge;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon_end")
    private WebElement btnClearSearchResult;

    public WebElement getClearSearchResultButton() {
        return btnClearSearchResult;
    }

    public WebElement getLocationIcon() {
        return imgLocationIcon;
    }

    public WebElement getLocationValue() {
        return eleLocationValue;
    }


    public WebElement getSearchRestaurants() {
        return txtSearchRestaurants;
    }

    public WebElement getSearchIcon() {
        return imgSearchIcon;
    }

    public WebElement getOffersContainer() {
        return eleOffersContainer;
    }

    public List<WebElement> getOfferWidgets() {
        return offerWidgets;
    }

    public WebElement getCampaignContainer() {
        return campaignContainer;
    }

    public List<WebElement> getCampainBanners() {
        return campainBanners;
    }

    public WebElement getFiltersWidget() {
        return filtersWidget;
    }

    public List<WebElement> getFilterButtons() {
        return btnFilter;
    }

    public List<WebElement> getFiltersNames() {
        return filtersNames;
    }


    public List<WebElement> getFiltersIcons() {
        return filtersIcons;
    }


    public WebElement getRestaurantsListWidget() {
        return restaurantsListWidget;
    }

    public List<WebElement> getRestaurantList() {
        return restaurantList;
    }

    public List<WebElement> getRestaurantWidgets() {
        return restaurantWidgets;
    }

    public List<WebElement> getRestaurantTitle() {
        return restaurantTitle;
    }

    public boolean isRestaurantTitleDisplayed(int restaurantsCount) {
        return getRestaurantTitle().size() >= restaurantsCount;
        //Sometimes another restaurant may display parially, I made the condition >= instead
        //of == to avoid failing the test
        //ToDo: find a better way to handle elements that are displaying partially.
    }

    public List<WebElement> getRestaurantType() {
        return restaurantType;
    }

    public boolean isRestaurantTypesDisplayed(int restaurantsCount) {
        return getRestaurantType().size() == restaurantsCount;
    }

    public List<WebElement> getRestaurantDistance() {
        return restaurantDistance;
    }

    public boolean isRestaurantDistanceDisplayed(int restaurantsCount) {
        return getRestaurantDistance().size() == restaurantsCount;
    }

    public List<WebElement> getDeliveryText() {
        return deliveryText;
    }

    public boolean isDeliveryTextDisplayed(int restaurantsCount) {
        return getDeliveryText().size() == restaurantsCount;
    }

    public List<WebElement> getDeliveryFeeValue() {
        return deliveryFeeValue;
    }

    public boolean isDeliveryFeeValueDisplayed(int restaurantsCount) {
        return getDeliveryFeeValue().size() == restaurantsCount;
    }

    public List<WebElement> getDeliveryFeeCurrency() {
        return deliveryFeeCurrency;
    }

    public boolean isDeliveryFeeCurrencyDisplayed(int restaurantsCount) {
        return getDeliveryFeeCurrency().size() == restaurantsCount;
    }

    public List<WebElement> getRestaurantDeliveryInfo() {
        return restaurantDeliveryInfo;
    }

    public boolean isRestaurantDeliveryInfoDisplayed(int restaurantsCount) {
        return getRestaurantDeliveryInfo().size() == restaurantsCount;
    }

    public List<WebElement> getRestaurantDeliveryInfoIcon() {
        return restaurantDeliveryInfoIcon;
    }

    public boolean isRestaurantDeliveryInfoIconDisplayed(int restaurantsCount) {
        return getRestaurantDeliveryInfoIcon().size() == restaurantsCount;
    }

    public List<WebElement> getRecommendedBadge() {
        return recommendedBadge;
    }

    public boolean isRecommendedBadgeDisplayed(int i) {
        boolean displayed = false;
        if (getRecommendedBadge().size() > 0) {
            displayed = getRecommendedBadge().get(i).isDisplayed();
        }
        return displayed;
    }

    public WebElement getBranchStatusBadge() {
        return branchStatusBadge;
    }

    public void waitUntilRestaurantsAreLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        restaurantList = wait.until(ExpectedConditions.visibilityOfAllElements(restaurantList));
    }

    public void selectRestaurant(int index) {
        touchAction.tap(tapOptions().withElement(element(restaurantList.get(index)))).perform();
    }

    /**
     * gets the count of restaurants that are currently displayed on screen
     * Note: appium recognizes only the items that are actually displaying on screen
     * so if the list actually contains 10 items, and the screen shows only 6, then
     * only 6 items will be recognized by appium.
     *
     * @param verifiableElements, if it's true, we'll decrease 1 from the total restaurants returned
     *                            if the restaurants count > 2, because we need all restaurants elements
     *                            to be visible when we are verifying page elements.
     * @return restaurants count
     */
    public int getRestaurantsCount(boolean verifiableElements) {
        int restaurantCount;
        waitUntilRestaurantsAreLoaded();

        restaurantCount = getRestaurantWidgets().size();
        if (restaurantCount > 2) {
            restaurantCount = restaurantCount - 1;
        }

        return restaurantCount;
    }

    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/action_bar_root")
    private WebElement scrollable;

    @Step("Scroll down restaurants list")
    public void scrollDownRestaurantsList() {
        waitUntilRestaurantsAreLoaded();
        //scrollByElement(restaurantDeliveryInfo.get(0));
        scrollByElement(restaurantsListWidget);
//        scrollByElement(restaurantTitle.get(0));
        //scrollByElement(scrollable);
    }

    @Step("Verify that all restaurants list screen objects are displayed correctly")
    public void verifyRestaurantsListLayout() {
        int restaurantCount = getRestaurantsCount(true);
        SoftAssertions soft = new SoftAssertions();

        verifyScreenElements();

        soft.assertThat(isRestaurantTitleDisplayed(restaurantCount))
                .as("Restaurants titles are not displayed for some " +
                        "or all of the restaurants").isTrue();
        soft.assertThat(isRestaurantTypesDisplayed(restaurantCount))
                .as("Restaurant type is not displayed for some " +
                        "or all of the restaurants").isTrue();
        soft.assertThat(isRestaurantDistanceDisplayed(restaurantCount))
                .as("Restaurant distance is not displayed for some " +
                        "or all of the restaurants").isTrue();
        soft.assertThat(isDeliveryTextDisplayed(restaurantCount))
                .as("Delivery text is not displayed for some " +
                        "or all of the restaurants").isTrue();
        soft.assertThat(isDeliveryFeeValueDisplayed(restaurantCount))
                .as("Delivery fee value is not displayed for some " +
                        "or all of the restaurants").isTrue();
        soft.assertThat(isDeliveryFeeCurrencyDisplayed(restaurantCount))
                .as("Delivery fee currency is not displayed for some " +
                        "or all of the restaurants").isTrue();
        soft.assertThat(isRestaurantDeliveryInfoDisplayed(restaurantCount))
                .as("Restaurant delivery info is not displayed for some " +
                        "or all of the restaurants").isTrue();
        soft.assertThat(isRestaurantDeliveryInfoIconDisplayed(restaurantCount))
                .as("Restaurant delivery info icon is not displayed for some " +
                        "or all of the restaurants").isTrue();
        soft.assertAll();
    }

    @Step("Search for a restaurant")
    public String searchForRestaurant(String keyword) {
        getSearchRestaurants().sendKeys(keyword);
        hideKeyboard();
        return keyword;
    }

    @Step("Verify that the restaurants that match the search criteria are returned")
    public void verifyReturnedRestaurants(String keyword) {
        int restaurantCountAfterSearch;
        String restaurantTitle;
        restaurantCountAfterSearch = getRestaurantsCount(false);

        assertThat(restaurantCountAfterSearch != 0).as("No restaurants match the search criteria")
                .isTrue();
        for (int i = 0; i < restaurantCountAfterSearch; i++) {
            restaurantTitle = getRestaurantTitle().get(i).getText();
            assertThat(restaurantTitle.contains(keyword)).as("The restaurant: "
                    + restaurantTitle + " doesnt match the search criteria with the keyword: " + keyword)
                    .isTrue();
        }
    }

    @Step("Clear the search criteria")
    public int clearSearchCriteria() {
        int restaurantsCountAfterClearingSearch = 0;
        try {
            tap(getClearSearchResultButton());
            restaurantsCountAfterClearingSearch = getRestaurantsCount(true);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return restaurantsCountAfterClearingSearch;
    }

    @Step("Verify that all restaurants are returned after clearing the search criteria")
    public void verifyAllRestaurantsAreReturned(int allRestaurantsCount, int searchRestaurantCount) {
        assertThat(allRestaurantsCount == searchRestaurantCount)
                .as("Not all restaurants are returned after clearing search criteria").isTrue();
    }

    @Step("Verify that recommended badge is showing next to a recommended restaurant")
    public void checkRecommendedBadge(boolean isRestaurantRecommended) {
        int restaurantCount = getRestaurantsCount(true);
        int i = 0;
        if (isRestaurantRecommended) {
            for (i = 0; i < restaurantCount; i++) {
                assertThat(isRecommendedBadgeDisplayed(i))
                        .as("Recommended badge is not displayed for this restaurant").isTrue();
            }
        } else {
            for (i = 0; i < restaurantCount; i++) {
                assertThat(isRecommendedBadgeDisplayed(i))
                        .as("Recommended badge is displayed even though the restaurant is not recommended")
                        .isFalse();
            }
        }
    }

    public ArrayList<Double> getDistanceOfDisplayedRestaurants(int restaurantCount) {
        ArrayList<Double> restaurantDistance = new ArrayList<>();
        String[] distaceText;
        double distance;

        for (int i = 0; i < restaurantCount; i++) {
            distaceText = getRestaurantDistance().get(i).getText().split(" ");
            distance = Double.parseDouble(distaceText[0]);
            restaurantDistance.add(distance);
        }

        return restaurantDistance;
    }

    @Step("Verify that restaurants are sorted by their distance from the customer")
    public void checkIfRestaurantsSortedByDistance() {
        int restaurantCount = getRestaurantsCount(true);
        boolean listSorted = false;
        ArrayList<Double> restaurantDistance = getDistanceOfDisplayedRestaurants(restaurantCount);
        listSorted = restaurantDistance.stream().sorted().collect(Collectors.toList()).equals(restaurantDistance);
        assertThat(listSorted).as("Restaurants are not sorted according their distance" +
                "from customer's location").isTrue();
    }
}
