package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.MenuItemScreenSteps;
import lombok.NonNull;

public class MenuItemStepsAndroid extends BaseSteps<MenuItemStepsAndroid>
    implements MenuItemScreenSteps {

  public MenuItemStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
  }

  @Override
  public void addMoreItems(int itemsCounter) {}

  @Override
  public void addToCart() {}

  @Override
  public void verifyViewCartButtonIsDisplayed() {}

  @Override
  public void clickOnViewCart() {}
}
