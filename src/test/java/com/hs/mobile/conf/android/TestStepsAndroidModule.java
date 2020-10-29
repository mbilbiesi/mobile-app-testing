package com.hs.mobile.conf.android;

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
import com.hs.mobile.steps.android.AllStoresScreenStepsAndroid;
import com.hs.mobile.steps.android.CheckoutScreenStepsAndroid;
import com.hs.mobile.steps.android.LandingScreenStepsAndroid;
import com.hs.mobile.steps.android.MenuItemStepsAndroid;
import com.hs.mobile.steps.android.PaymentOptionsScreenStepsAndroid;
import com.hs.mobile.steps.android.RestaurantMenuScreenStepsAndroid;
import com.hs.mobile.steps.android.SelectLocationScreenStepsAndroid;
import com.hs.mobile.steps.android.VerticalsScreenStepsAndroid;

@SuppressWarnings("unused")
public class TestStepsAndroidModule extends AbstractModule {

  @Provides
  public LandingScreenSteps landingScreenSteps(TestSettings testSettings) {
    return new LandingScreenStepsAndroid(testSettings);
  }

  @Provides
  public SelectLocationScreenSteps selectLocationScreenSteps(TestSettings testSettings) {
    return new SelectLocationScreenStepsAndroid(testSettings);
  }

  @Provides
  public VerticalsScreenSteps verticalsScreenSteps(TestSettings testSettings) {
    return new VerticalsScreenStepsAndroid(testSettings);
  }

  @Provides
  public RestaurantScreenSteps restaurantScreenSteps(TestSettings testSettings) {
    return new AllStoresScreenStepsAndroid(testSettings);
  }

  @Provides
  public RestaurantMenuScreenSteps restaurantMenuScreenSteps(TestSettings settings) {
    return new RestaurantMenuScreenStepsAndroid(settings);
  }

  @Provides
  public MenuItemScreenSteps menuItemScreenSteps(TestSettings settings) {
    return new MenuItemStepsAndroid(settings);
  }

  @Provides
  public CheckoutScreenSteps checkoutScreenSteps(TestSettings testSettings) {
    return new CheckoutScreenStepsAndroid(testSettings);
  }

  @Provides
  public PaymentOptionsScreenSteps paymentOptionsScreenSteps(TestSettings settings) {
    return new PaymentOptionsScreenStepsAndroid(settings);
  }
}
