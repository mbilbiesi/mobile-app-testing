package com.hs.mobile.steps.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.MoreScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.MoreScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class MoreScreenStepsIOS extends BaseSteps<MoreScreenStepsIOS> implements MoreScreenSteps {

  @NonNull private final MoreScreen moreScreen;

  public MoreScreenStepsIOS(@NonNull TestSettings settings) {
    super(settings);
    moreScreen = new MoreScreen(settings);
  }

  @Override
  @Step("click on 'Login'")
  public void clickOnLogin() {
    moreScreen.getBtnLogin().click();
  }

  @Override
  @Step("click on 'Home'")
  public void clickOnHome() {
    moreScreen.getBtnHome().click();
  }

}
