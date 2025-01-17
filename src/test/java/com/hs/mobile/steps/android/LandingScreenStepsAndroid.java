package com.hs.mobile.steps.android;

import static java.util.Objects.requireNonNull;
import static org.springframework.util.CollectionUtils.lastElement;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.LandingScreen;
import com.hs.mobile.screens.ios.MoreScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.LandingScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingScreenStepsAndroid extends BaseSteps<LandingScreenStepsAndroid>
    implements LandingScreenSteps {

  @NonNull private final LandingScreen landingScreen;
  @NonNull private final MoreScreen moreScreen;

  public LandingScreenStepsAndroid(@NonNull TestSettings testSettings) {
    super(testSettings);
    landingScreen = new LandingScreen(testSettings);
    moreScreen = new MoreScreen(testSettings);
  }

  @Override
  public void handleLocationPopup() {}

  public void selectNewAddress() {
    tap(landingScreen.getLblDelivery());
  }

  @Override
  @Step("click on 'More' from tab bar")
  public void clickOnMore() {
    landingScreen.getBtnMore().click();
  }

  @Override
  @Step("Click on more actions")
  public void clickOnMoreActions() {
    landingScreen.getBtnMoreAction().click();
  }

  @Override
  @Step("Get address label")
  public String getAddressLabel() {
    return requireNonNull(lastElement(landingScreen.getLstDescription())).getText();
  }

  @Override
  @Step("Click on 'Edit' address")
  public void clickOnEditAddress() {
    landingScreen.getEditDeleteDialog().get(0).click();
  }

  @Override
  @Step("Click on 'Delete' address")
  public void clickOnDeleteAddress() {
    landingScreen.getEditDeleteDialog().get(1).click();
  }

  @Override
  public void confirmRemoveAddress() {}

  @Override
  @Step("Verify '{0}' address type is appeared in search field")
  public void verifySearchFieldValueIsEqualTo(String value) {
    wait.withMessage("Address type is not displayed in search field")
        .until(
            ExpectedConditions.attributeToBe(landingScreen.getLblDeliveryValue(), "text", value));
  }

  @Override
  @Step("Click on more screen")
  public void clickOnOrders() {
    moreScreen.getBtnLogin().click();
  }
}
