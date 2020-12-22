package com.hs.mobile.steps.ios;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.MenuItemScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.MenuItemScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class MenuItemStepsIOS extends BaseSteps<MenuItemStepsIOS> implements MenuItemScreenSteps {
  @NonNull private final MenuItemScreen menuItemScreen;

  public MenuItemStepsIOS(@NonNull TestSettings settings) {
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
  @Step("Add order to chart")
  public void addToCart() {
    menuItemScreen.getBtnAddToCart().click();
  }

  @Override
  @Step("Verify view cart button is displayed")
  public void verifyViewCartButtonIsDisplayed() {
    assertThat(menuItemScreen.getBtnViewCart().isDisplayed())
        .as("view cart button is not displayed")
        .isTrue();
  }

  @Override
  @Step("Click on view cart")
  public void clickOnViewCart() {
    menuItemScreen.getBtnViewCart().click();
  }

  @Override
  @Step("Verify menu calories label")
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
  @Step("Click on cancel search results")
  public void clickCancelSearch() {
    menuItemScreen.getBtnCancelSearch().click();
  }

  @Override
  @Step("Search for '{0}' menu item")
  public void searchForMenuItem(String menuItem) {
    menuItemScreen.getMenuSearchBar().sendKeys(menuItem);
  }

  @Override
  @Step("Click on a specific searched menu item")
  public void clickSearchResultItem() {
    menuItemScreen.getTxtSearchResultItem().click();
  }

  @Override
  @Step("Click on checkout from menu screen")
  public void clickOnCheckoutFromMenuScreen() {
    menuItemScreen.getBtnCheckoutFromMenuScreen().click();
  }
}
