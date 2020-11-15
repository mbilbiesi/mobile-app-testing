package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.CampaignScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.CampaignScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class CampaignScreenStepsAndroid extends BaseSteps<CampaignScreenStepsAndroid>
    implements CampaignScreenSteps {

  @NonNull private final CampaignScreen campaignScreen;

  public CampaignScreenStepsAndroid(@NonNull TestSettings settings) {
    super(settings);
    campaignScreen = new CampaignScreen(settings);
  }

  @Override
  @Step("verify campaign screen is displayed")
  public void verifyCampaignScreenIsDisplayed() {
    assertThat(campaignScreen.getCampaignScreenBg().isDisplayed())
        .as("could not navigate to campaign screen")
        .isTrue();
  }

  @Override
  @Step("close campaign screen")
  public void closeCampaignScreen() {
    campaignScreen.getBtnCloseCampaign().click();
  }
}
