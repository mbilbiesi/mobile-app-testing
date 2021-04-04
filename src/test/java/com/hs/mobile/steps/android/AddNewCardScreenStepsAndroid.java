package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.AddNewCardScreen;
import com.hs.mobile.steps.AddNewCardScreenSteps;
import com.hs.mobile.steps.BaseSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class AddNewCardScreenStepsAndroid extends BaseSteps<AddNewCardScreenStepsAndroid>
    implements AddNewCardScreenSteps {

  @NonNull private final AddNewCardScreen addNewCardScreen;

  public AddNewCardScreenStepsAndroid(@NonNull TestSettings testSettings) {
    super(testSettings);
    addNewCardScreen = new AddNewCardScreen(testSettings);
  }

  @Override
  @Step("Verify credit card charge note is displayed")
  public void verifyCreditCardNote() {
    assertThat(addNewCardScreen.getLblCreditCardNote().isDisplayed())
        .as("Credit card note is not not displayed")
        .isTrue();
  }
}
