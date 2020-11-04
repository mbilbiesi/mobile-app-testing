package com.hs.mobile.conf.ios;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.AllStoresScreenSteps;
import com.hs.mobile.steps.CheckoutScreenSteps;
import com.hs.mobile.steps.LandingScreenSteps;
import com.hs.mobile.steps.LoginScreenSteps;
import com.hs.mobile.steps.MenuItemScreenSteps;
import com.hs.mobile.steps.MoreScreenSteps;
import com.hs.mobile.steps.PaymentOptionsScreenSteps;
import com.hs.mobile.steps.RestaurantMenuScreenSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;
import com.hs.mobile.steps.ios.AllStoresScreenStepsIOS;
import com.hs.mobile.steps.ios.CheckoutScreenStepsIOS;
import com.hs.mobile.steps.ios.LandingScreenStepsIOS;
import com.hs.mobile.steps.ios.LoginScreenStepsIOS;
import com.hs.mobile.steps.ios.MenuItemStepsIOS;
import com.hs.mobile.steps.ios.MoreScreenStepsIOS;
import com.hs.mobile.steps.ios.PaymentOptionsScreenStepsIOS;
import com.hs.mobile.steps.ios.RestaurantMenuScreenStepsIOS;
import com.hs.mobile.steps.ios.SelectLocationScreenStepsIOS;
import com.hs.mobile.steps.ios.VerticalsScreenStepsIOS;

@SuppressWarnings("unused")
public class TestStepsIOSModule extends AbstractModule {

  @Provides
  public LandingScreenSteps landingScreenSteps(TestSettings testSettings) {
    return new LandingScreenStepsIOS(testSettings);
  }

  @Provides
  public SelectLocationScreenSteps selectLocationScreenSteps(TestSettings testSettings) {
    return new SelectLocationScreenStepsIOS(testSettings);
  }

  @Provides
  public VerticalsScreenSteps verticalsScreenSteps(TestSettings testSettings) {
    return new VerticalsScreenStepsIOS(testSettings);
  }

  @Provides
  public AllStoresScreenSteps restaurantScreenSteps(TestSettings testSettings) {
    return new AllStoresScreenStepsIOS(testSettings);
  }

  @Provides
  public RestaurantMenuScreenSteps restaurantMenuScreenSteps(TestSettings settings) {
    return new RestaurantMenuScreenStepsIOS(settings);
  }

  @Provides
  public MenuItemScreenSteps menuItemScreenSteps(TestSettings settings) {
    return new MenuItemStepsIOS(settings);
  }

  @Provides
  public CheckoutScreenSteps checkoutScreenSteps(TestSettings testSettings) {
    return new CheckoutScreenStepsIOS(testSettings);
  }

  @Provides
  public PaymentOptionsScreenSteps paymentOptionsScreenSteps(TestSettings settings) {
    return new PaymentOptionsScreenStepsIOS(settings);
  }

  @Provides
  public LoginScreenSteps loginScreenSteps(TestSettings settings) {
    return new LoginScreenStepsIOS(settings);
  }

  @Provides
  public MoreScreenSteps moreScreenSteps(TestSettings settings) {
    return new MoreScreenStepsIOS(settings);
  }
}
