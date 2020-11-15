package com.hs.mobile.steps.android;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.VerticalsScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;
import io.qameta.allure.Step;
import lombok.NonNull;

public class VerticalsScreenStepsAndroid extends BaseSteps<VerticalsScreenStepsAndroid>
    implements VerticalsScreenSteps {

  @NonNull private final VerticalsScreen verticalsScreen;

  public VerticalsScreenStepsAndroid(@NonNull TestSettings testSettings) {
    super(testSettings);
    verticalsScreen = new VerticalsScreen(testSettings);
  }

  @Override
  @Step("click on the address from the address bar")
  public void clickOnAddress() {
    tap(verticalsScreen.txtDeliveryValue());
  }

  @Override
  @Step("Click on add new address from the verticals page")
  public void clickOnAddNewLocation() {
    tap(verticalsScreen.btnNewLocation());
  }

  @Override
  @Step("verify 'All Stores' vertical is displayed")
  public boolean isAllStoresVerticalDisplayed() {
    return verticalsScreen.verticals().size() > 0;
  }

  @Override
  @Step("verify 'OrderAnything' vertical is displayed")
  public boolean isOrderAnythingVerticalDisplayed() {
    return verticalsScreen.verticals().get(2).isDisplayed();
  }

  @Override
  @Step("verify district is appeared in search field")
  public void assertDistrictIsAppearedInSearchField() {
    assertThat(verticalsScreen.txtDeliveryValue().getText())
        .as("search field has a wrong value")
        .isNotEmpty()
        .doesNotContain("Select");
  }

  @Override
  @Step("verify all verticals are displayed")
  public void assertAllVerticals() {
    assertThat(verticalsScreen.verticals().size())
        .as("Expected to fetch all verticals for the provided address")
        .isEqualTo(3);
  }

  @Override
  @Step("Verify two verticals are displayed and order-anything verticals is not present")
  public void assertTwoVerticalsAreDisplayed() {
    assertThat(verticalsScreen.verticals().size())
        .as("Expected 'All stores' & 'Quick Market' verticals for the provided address")
        .isEqualTo(2);
  }

  @Override
  @Step("Verify `All stores' vertical is displayed")
  public void verifyAllStoresVertical() {
    assertThat(verticalsScreen.verticals().size())
        .as("Expected only 'All stores' vertical for the provided address")
        .isEqualTo(1);
  }

  @Override
  @Step("Click on 'All Stores'")
  public void clickOnAllStores() {
    verticalsScreen.verticals().get(0).click();
  }

  @Override
  @Step("Click on 'Order Anything'")
  public void clickOrderAnything() {
    verticalsScreen.verticals().get(2).click();
  }
}
