package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.AllStoresScreen;
import com.hs.mobile.steps.AllStoresScreenSteps;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.util.CustomConditions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import lombok.NonNull;

public class AllStoresScreenStepsIOS extends BaseSteps<AllStoresScreenStepsIOS>
    implements AllStoresScreenSteps {

  @NonNull private final AllStoresScreen allStoresScreen;
  @NonNull private final AppiumDriver driver;

  public AllStoresScreenStepsIOS(@NonNull TestSettings testSettings) {
    super(testSettings);
    allStoresScreen = new AllStoresScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Step("Select `{0}` restaurant")
  public void selectRestaurantByName(String name) {
    driver.findElement(MobileBy.iOSNsPredicateString("label CONTAINS '" + name + "'")).click();
  }

  @Override
  @Step("verify location is appeared in screen header")
  public void verifyLocationIsAppearedScreenHeader() {
    assertThat(allStoresScreen.getHeaderLocation().getText())
        .as("Wrong value in header screen")
        .isNotEmpty();
  }

  @Override
  @Step("Select fast food filter")
  public void clickOnFirstFilter() {
    wait.withMessage("could not select a filter")
        .until(
            CustomConditions.elementIsClicked(
                allStoresScreen.getFastFoodFilter(), allStoresScreen.getFastFoodSection()));
  }

  @Override
  @Step("Verify filter is selected")
  public void assertFilterSelection() {
    assertThat(allStoresScreen.getFastFoodSection().isDisplayed())
        .as("select filter is not working")
        .isTrue();
  }

  @Step("deselect fast food filter")
  public void deselectFilter() {
    allStoresScreen.getFastFoodFilter().click();
  }

  @Step("verify filter is deselected")
  public void assertFilterDeselected() {
    assertThat(allStoresScreen.getAllFilterSection().isDisplayed())
        .as("deselect filter is not working")
        .isTrue();
  }

  @Override
  @Step("verify campaign banners are displayed")
  public void verifyCampaignBannersAreDisplayed() {
    assertThat(allStoresScreen.getFirstCampaignBanner().isDisplayed())
        .as("campaign banners are not displayed")
        .isTrue();
  }

  @Override
  @Step("Click on search for restaurant button")
  public void clickOnSearch() {
    allStoresScreen.getBtnSearchIcon().click();
  }

  @Override
  @Step("Type search keyword in the search bar")
  public void typeSearchKeyword(String searchKeyword) {
    allStoresScreen.getTxtSearch().sendKeys(searchKeyword);
  }

  @Override
  @Step("Click on 'try now' to navigate to Order Anything")
  public void clickOnTryOrderAnything() {
    allStoresScreen.getBtnOrderAnything().click();
  }

  @Override
  @Step("Click on first campaign banner")
  public void clickOnCampaign() {
    allStoresScreen.getFirstCampaignBanner().click();
  }

  @Override
  @Step("Assert that one store is displayed ")
  public void verifyStoreSelectedIsAppeared() {
    assertThat(allStoresScreen.getLstStores().size() == 1)
        .as("There isn't a matching store")
        .isTrue();
  }

  @Override
  @Step("Click on top banner promoted store")
  public void clickOnTopPromotedStore() {
    allStoresScreen.getBtnTopPromotedStore().click();
  }

  @Override
  @Step("Click on a store form the swimlane section")
  public void selectStoreFromSwimlane() {
    allStoresScreen.getLstSwimlane().get(1).click();
  }

  @Override
  public void selectFirstStore() {}
}
