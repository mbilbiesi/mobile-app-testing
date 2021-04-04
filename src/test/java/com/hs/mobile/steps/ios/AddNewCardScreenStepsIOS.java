package com.hs.mobile.steps.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.AddNewCardScreenSteps;
import com.hs.mobile.steps.BaseSteps;
import io.qameta.allure.Step;

public class AddNewCardScreenStepsIOS extends BaseSteps<AddNewCardScreenStepsIOS>
    implements AddNewCardScreenSteps {

  public AddNewCardScreenStepsIOS(TestSettings settings) {
    super(settings);
  }

  @Override
  @Step("Verify credit card payment note")
  public void verifyCreditCardNote() {}
}
