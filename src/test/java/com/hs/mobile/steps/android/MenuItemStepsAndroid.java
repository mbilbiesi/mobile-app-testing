package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.MenuItemScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.MenuItemScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class MenuItemStepsAndroid extends BaseSteps<MenuItemStepsAndroid>
    implements MenuItemScreenSteps {

  @NonNull private final MenuItemScreen menuItemScreen;

  public MenuItemStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    menuItemScreen = new MenuItemScreen(settings);
  }

  @Override
  @Step("Increase items' count to {0}")
  public void addMoreItems(int itemsCounter) {
    for (int i = 1; i < itemsCounter; i++) {
      menuItemScreen.getBtnAddMoreItems().click();
    }
  }

  @Override
  @Step("Click on add to cart button")
  public void addToCart() {
    menuItemScreen.getBtnAddToCart().click();
  }

  @Override
  public void verifyViewCartButtonIsDisplayed() {}

  @Override
  @Step("Click on view cart from menu screen")
  public void clickOnViewCart() {
    menuItemScreen.getBtnViewCart().click();
  }

  @Override
  @Step("Verify that calories label is displayed")
  public void verifyCaloriesLabel() {
    assertThat(menuItemScreen.getLblCalories().isDisplayed())
        .as("calories label is not displayed")
        .isTrue();
  }

  @Override
  @Step("Click on menu search icon")
  public void clickOnMenuSearchIcon() {
    menuItemScreen.getBtnMenuSearchIcon().click();
  }

  @Override
  @Step("Search for '{0}' menu item")
  public void searchForMenuItem(String menuItem) {
    menuItemScreen.getTxtSearchMenuInput().sendKeys(menuItem);
  }

  @Override
  @Step("Click the first menu item in the search result")
  public void clickSearchResultItem() {
    menuItemScreen.getLblFirstItemInSearchResult().click();
  }

  @Override
  @Step("Click on cancel search result from menu screen")
  public void clickCancelSearch() {
    menuItemScreen.getBtnCancelSearchResult().click();
  }

  @Override
  public void clickOnCheckoutFromMenuScreen() {}
}
