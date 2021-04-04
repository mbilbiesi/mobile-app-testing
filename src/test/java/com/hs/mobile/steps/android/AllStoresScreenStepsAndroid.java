package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.AllStoresScreen;
import com.hs.mobile.steps.AllStoresScreenSteps;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.util.CustomConditions;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllStoresScreenStepsAndroid extends BaseSteps<AllStoresScreenStepsAndroid>
    implements AllStoresScreenSteps {

  @NonNull private final AllStoresScreen allStoresScreen;

  public AllStoresScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    allStoresScreen = new AllStoresScreen(settings);
  }

  @Override
  public void selectRestaurantByName(String name) {}

  @Override
  public void verifyLocationIsAppearedScreenHeader() {}

  @Step("Click on the first store")
  public void selectFirstStore() {
    allStoresScreen.getBtnFirstStore().click();
  }

  @Override
  @Step("select first filter")
  public void clickOnFirstFilter() {
    allStoresScreen.getLstFilters().get(1).click();
  }

  @Override
  @Step("Verify filter is selected")
  public void assertFilterSelection() {
    assertThat(allStoresScreen.getLstFilters().size())
        .as("select filter is not working")
        .isEqualTo(1);
  }

  @Override
  @Step("deselect filter")
  public void deselectFilter() {
    By filtersList = By.id("com.hungerstation.android.web.debug:id/filter_name");
    wait.withMessage("Could not deselect filter")
        .until(
            CustomConditions.elementIsClicked(
                allStoresScreen.getLstFilters().get(0),
                ExpectedConditions.numberOfElementsToBeMoreThan(filtersList, 1)));
  }

  @Override
  @Step("verify filter is deselected")
  public void assertFilterDeselected() {
    By filtersList = By.id("com.hungerstation.android.web.debug:id/filter_name");
    wait.withMessage("deselect filter button is not working")
        .until(ExpectedConditions.numberOfElementsToBeMoreThan(filtersList, 1));
  }

  @Override
  @Step("verify campaign banners are displayed")
  public void verifyCampaignBannersAreDisplayed() {
    assertThat(allStoresScreen.getCampaignBannerList().size())
        .as("campaign banners are not displayed")
        .isGreaterThan(0);
  }

  @Override
  @Step("Click on search for restaurant button")
  public void clickOnSearch() {
    allStoresScreen.getBtnSearchIcon().click();
  }

  @Override
  @Step("Type search keyword in the search bar")
  public void typeSearchKeyword(String searchKeyword) {
    allStoresScreen.getSearchBar().sendKeys(searchKeyword);
  }

  @Override
  @Step("Click on 'try now' to navigate to Order Anything")
  public void clickOnTryOrderAnything() {
    allStoresScreen.getBtnTryOrderAnything().click();
  }

  @Override
  @Step("Click on first campaign banner")
  public void clickOnCampaign() {
    allStoresScreen.getCampaignBannerList().get(0).click();
  }

  @Override
  @Step("Assert that one store is displayed ")
  public void verifyStoreSelectedIsAppeared() {
    assertThat(allStoresScreen.getLblSearchResults().getText().contains("Al Reef"))
        .as("There isn't a matching store")
        .isTrue();
  }

  @Override
  @Step("Click on top banner")
  public void clickOnTopPromotedStore() {
    allStoresScreen.getBtnTopPromotedStore().click();
  }

  @Override
  @Step("Click on swimlane store")
  public void selectStoreFromSwimlane() {
    allStoresScreen.getBtnSwimLaneStore().click();
  }
}
