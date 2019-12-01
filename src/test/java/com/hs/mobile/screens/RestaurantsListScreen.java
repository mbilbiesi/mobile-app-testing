package com.hs.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RestaurantsListScreen extends AbstractScreen {

    public RestaurantsListScreen(AppiumDriver driver, TouchAction touchAction) {
        super(driver, touchAction);
    }

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_icon")
    private WebElement imgLocationIcon;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/location_value")
    private WebElement eleLocationValue;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/input")
    private WebElement txtSearchRestaurants;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/icon_start")
    private WebElement imgSearchIcon;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/viewpager")
    private WebElement eleOffersContainer;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/image")
    private List<WebElement> offerWidgets;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_container")
    private WebElement campaignContainer;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/campaign_banner")
    private List<WebElement> campainBanners;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_component")
    private WebElement filtersWidget;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_filter")
    private List<WebElement> btnFilter;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_name")
    private List<WebElement> filtersNames;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/filter_icon")
    private List<WebElement> filtersIcons;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/RestListView")
    private WebElement restaurantsListWidget;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
    private List<WebElement> restaurantList;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/constrain_parent")
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
    @AndroidFindBy(xpath = "//*[@id='com.hungerstation.android.web.debug:id/value" +
            " and (@text='يوصى به' or @text='recommended')]")
    private List<WebElement> recommendedBadge;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//*[@id='com.hungerstation.android.web.debug:id/value'" +
            " and not(@text='يوصى به' or @text='recommended')]")
    private WebElement branchStatusBadge;

    public WebElement getLocationIcon() {
        return imgLocationIcon;
    }

    public boolean isLocationIconDisplayed(){
        return getLocationIcon().isDisplayed();
    }

    public WebElement getLocationValue() {
        return eleLocationValue;
    }

    public boolean isLocationValueDisplayed(){
        return getLocationValue().isDisplayed();
    }

    public WebElement getSearchRestaurants() {
        return txtSearchRestaurants;
    }

    public boolean isSearchTextboxDisplayed(){
        return getSearchRestaurants().isDisplayed();
    }

    public WebElement getSearchIcon() {
        return imgSearchIcon;
    }

    public boolean isSearchIconDisplayed(){
        return getSearchIcon().isDisplayed();
    }

    public WebElement getOffersContainer() {
        return eleOffersContainer;
    }

    public boolean isOffersContainerDisplayed() {
        return getOffersContainer().isDisplayed();
    }

    public List<WebElement> getOfferWidgets() {
        return offerWidgets;
    }

    public boolean isOfferWidgetDisplayed() {
        return getOfferWidgets().size() > 0;
    }

    public WebElement getCampaignContainer() {
        return campaignContainer;
    }

    public boolean isCampaignContainerDisplayed() {
        return getCampaignContainer().isDisplayed();
    }

    public List<WebElement> getCampainBanners() {
        return campainBanners;
    }

    public boolean isCampaignBannersDisplayed() {
        return getCampainBanners().size() > 0;
    }

    public WebElement getFiltersWidget() {
        return filtersWidget;
    }

    public boolean isFiltersWidgetDisplayed() {
        return getFiltersWidget().isDisplayed();
    }

    public List<WebElement> getFilterButtons() {
        return btnFilter;
    }

    public boolean isFilterButtonsDisplayed() {
        return getFilterButtons().size() > 0;
    }

    public List<WebElement> getFiltersNames() {
        return filtersNames;
    }

    public boolean isFiltersNamesDisplayed() {
        return getFiltersNames().size() > 0;
    }

    public List<WebElement> getFiltersIcons() {
        return filtersIcons;
    }

    public boolean isFiltersIconsDisplayed() {
        return getFiltersIcons().size() > 0;
    }

    public WebElement getRestaurantsListWidget() {
        return restaurantsListWidget;
    }

    public boolean isRestaurantsListDisplayed() {
        return getRestaurantsListWidget().isDisplayed();
    }

    public List<WebElement> getRestaurantList() {
        return restaurantList;
    }

    public List<WebElement> getRestaurantWidgets() {
        return restaurantWidgets;
    }

    public boolean isRestaurantWidgetDisplayed() {
        return getRestaurantWidgets().size() > 0;
    }

    public List<WebElement> getRestaurantTitle() {
        return restaurantTitle;
    }

    public boolean isRestaurantTitleDisplayed(int restaurantsCount) {
        return getRestaurantTitle().size() == restaurantsCount;
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

    public int getRestaurantsCount() {
        return getRestaurantWidgets().size();
    }

    @Step
    public void verifyRestaurantsListLayout(){

        int restaurantCount = getRestaurantsCount();

        assertAll(
                () -> assertThat(isLocationValueDisplayed())
                        .as("The location text is not displayed").isTrue(),
                () -> assertThat(isLocationIconDisplayed()).as(
                        "The location icon is not displayed.").isTrue(),
                () -> assertThat(isSearchTextboxDisplayed()).as(
                        "Search restaurants textbox is not displayed.").isTrue(),
                () -> assertThat(isSearchIconDisplayed())
                        .as("Search icon is not displayed.").isTrue(),
                () -> assertThat(isOffersContainerDisplayed())
                        .as("Offers container is not displayed.").isTrue(),
                () -> assertThat(isOfferWidgetDisplayed())
                        .as("Offer widgets are not displayed.").isTrue(),
                () -> assertThat(isCampaignContainerDisplayed())
                        .as("Campaings container is not displayed.").isTrue(),
                () -> assertThat(isCampaignBannersDisplayed())
                        .as("Campaign banners are not displayed").isTrue(),
                () -> assertThat(isFiltersWidgetDisplayed())
                        .as("Filters widget is not displayed").isTrue(),
                () -> assertThat(isFilterButtonsDisplayed())
                        .as("Filters are not displayed").isTrue(),
                () -> assertThat(isFiltersNamesDisplayed())
                        .as("Filter names are not displayed").isTrue(),
                () -> assertThat(isFiltersIconsDisplayed())
                        .as("Filter icons are not displayed").isTrue(),
                () -> assertThat(isRestaurantsListDisplayed())
                        .as("Restaurants list widget is not displayed").isTrue(),
                () -> assertThat(isRestaurantWidgetDisplayed())
                        .as("Restaurants widgets are not displayed").isTrue(),
                () -> assertThat(isRestaurantTitleDisplayed(restaurantCount))
                        .as("Restaurants titles are not displayed for some " +
                                "or all of the restaurants").isTrue(),
                () -> assertThat(isRestaurantTypesDisplayed(restaurantCount))
                        .as("Restaurant type is not displayed for some " +
                                "or all of the restaurants").isTrue(),
                () -> assertThat(isRestaurantDistanceDisplayed(restaurantCount))
                        .as("Restaurant distance is not displayed for some " +
                                "or all of the restaurants").isTrue(),
                () -> assertThat(isDeliveryTextDisplayed(restaurantCount))
                        .as("Delivery text is not displayed for some " +
                                "or all of the restaurants").isTrue(),
                () -> assertThat(isDeliveryFeeValueDisplayed(restaurantCount))
                        .as("Delivery fee value is not displayed for some " +
                                "or all of the restaurants").isTrue(),
                () -> assertThat(isDeliveryFeeCurrencyDisplayed(restaurantCount))
                        .as("Delivery fee currency is not displayed for some " +
                                "or all of the restaurants").isTrue(),
                () -> assertThat(isRestaurantDeliveryInfoDisplayed(restaurantCount))
                        .as("Restaurant delivery info is not displayed for some " +
                                "or all of the restaurants").isTrue(),
                () -> assertThat(isRestaurantDeliveryInfoIconDisplayed(restaurantCount))
                        .as("Restaurant delivery info icon is not displayed for some " +
                                "or all of the restaurants").isTrue()
        );
    }
}
