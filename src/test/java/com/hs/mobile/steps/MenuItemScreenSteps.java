package com.hs.mobile.steps;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.MenuItemScreen;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuItemScreenSteps extends BaseSteps {

  @NonNull
  private final MenuItemScreen menuItemScreen;

  public MenuItemScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    menuItemScreen = new MenuItemScreen(settings);
  }

  @Step("")
  public void addQuantity() {
    tap(menuItemScreen.getPlus());
  }

  @Step("")
  public Double getTotalAmount() {
    wait.until(ExpectedConditions.visibilityOf(menuItemScreen.getAmount()));
    String amountLabel = menuItemScreen.getAmount().getText().trim();
    return Double.parseDouble(amountLabel.substring(0, amountLabel.indexOf(' ')));
  }

  @Step("")
  public void addToCart() {
    tap(menuItemScreen.getAdd());
  }
  // todo: check why this class's steps are without description
}
