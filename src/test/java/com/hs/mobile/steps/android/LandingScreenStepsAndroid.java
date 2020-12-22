package com.hs.mobile.steps.android;

import static java.util.Objects.requireNonNull;
import static org.springframework.util.CollectionUtils.lastElement;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.LandingScreen;
import com.hs.mobile.screens.ios.MoreScreen;
import com.hs.mobile.steps.BaseSteps;
import com.hs.mobile.steps.LandingScreenSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingScreenStepsAndroid extends BaseSteps<LandingScreenStepsAndroid>
    implements LandingScreenSteps {

  @NonNull private final LandingScreen landingScreen;
  @NonNull private final AppiumDriver<MobileElement> driver;
  @NonNull private final MoreScreen moreScreen;

  public LandingScreenStepsAndroid(@NonNull TestSettings testSettings) {
    super(testSettings);
    landingScreen = new LandingScreen(testSettings);
    moreScreen = new MoreScreen(testSettings);
    driver = testSettings.getDriver();
  }

  @Override
  public void handleLocationPopup() {}

  @Override
  @Step("Handle promotion popup")
  public void handlePromotionPopup() {
    try {
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      driver.findElement(By.xpath("//android.view.View[@content-desc=\"تخطى الإعلان\"]")).click();
    } catch (NoSuchElementException ignored) {
    } finally {
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
  }

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
