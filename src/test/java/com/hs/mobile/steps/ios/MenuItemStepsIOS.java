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
  @Step("Add more items from the menu : {0}")
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
}
