package com.hs.mobile.conf.ios;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.CheckoutScreenSteps;
import com.hs.mobile.steps.LandingScreenSteps;
import com.hs.mobile.steps.MenuItemScreenSteps;
import com.hs.mobile.steps.PaymentOptionsScreenSteps;
import com.hs.mobile.steps.RestaurantMenuScreenSteps;
import com.hs.mobile.steps.RestaurantScreenSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;
import com.hs.mobile.steps.ios.CheckoutScreenStepsIOS;
import com.hs.mobile.steps.ios.LandingScreenStepsIOS;
import com.hs.mobile.steps.ios.MenuItemStepsIOS;
import com.hs.mobile.steps.ios.PaymentOptionsScreenStepsIOS;
import com.hs.mobile.steps.ios.RestaurantMenuScreenStepsIOS;
import com.hs.mobile.steps.ios.RestaurantScreenStepsIOS;
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
  public RestaurantScreenSteps restaurantScreenSteps(TestSettings testSettings) {
    return new RestaurantScreenStepsIOS(testSettings);
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
}
