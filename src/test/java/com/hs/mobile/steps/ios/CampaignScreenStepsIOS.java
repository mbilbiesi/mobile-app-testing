package com.hs.mobile.steps.ios;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.CampaignScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.CampaignScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CampaignScreenStepsIOS extends BaseSteps<CampaignScreenStepsIOS>
    implements CampaignScreenSteps {

  @NonNull private final CampaignScreen campaignScreen;

  public CampaignScreenStepsIOS(@NonNull TestSettings settings) {
    super(settings);
    campaignScreen = new CampaignScreen(settings);
  }

  @Override
  @Step("verify campaign screen is displayed")
  public void verifyCampaignScreenIsDisplayed() {
    wait.withMessage("could not navigate to campaign screen")
        .until(
            ExpectedConditions.attributeToBe(
                campaignScreen.getCampaignScreenBg(), "enabled", "true"));
  }

  @Override
  @Step("close campaign screen")
  public void closeCampaignScreen() {
    campaignScreen.getBtnCloseCampaign().click();
  }
}
