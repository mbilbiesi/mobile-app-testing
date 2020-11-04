package com.hs.mobile.steps.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.MoreScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.MoreScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class MoreScreenStepsAndroid extends BaseSteps<MoreScreenStepsAndroid> implements MoreScreenSteps {

  @NonNull private final MoreScreen moreScreen;

  public MoreScreenStepsAndroid(@NonNull TestSettings settings) {
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
