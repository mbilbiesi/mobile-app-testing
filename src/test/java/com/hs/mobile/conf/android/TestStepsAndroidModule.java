package com.hs.mobile.conf.android;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.AllStoresScreenSteps;
import com.hs.mobile.steps.CampaignScreenSteps;
import com.hs.mobile.steps.CheckoutScreenSteps;
import com.hs.mobile.steps.LandingScreenSteps;
import com.hs.mobile.steps.LoginScreenSteps;
import com.hs.mobile.steps.MenuItemScreenSteps;
import com.hs.mobile.steps.MoreScreenSteps;
import com.hs.mobile.steps.OrderAnythingCheckoutScreenSteps;
import com.hs.mobile.steps.OrderAnythingScreenSteps;
import com.hs.mobile.steps.PaymentOptionsScreenSteps;
import com.hs.mobile.steps.QuickMarketScreenSteps;
import com.hs.mobile.steps.RestaurantMenuScreenSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;
import com.hs.mobile.steps.android.AllStoresScreenStepsAndroid;
import com.hs.mobile.steps.android.CampaignScreenStepsAndroid;
import com.hs.mobile.steps.android.CheckoutScreenStepsAndroid;
import com.hs.mobile.steps.android.LandingScreenStepsAndroid;
import com.hs.mobile.steps.android.LoginScreenStepsAndroid;
import com.hs.mobile.steps.android.MenuItemStepsAndroid;
import com.hs.mobile.steps.android.MoreScreenStepsAndroid;
import com.hs.mobile.steps.android.OrderAnythingCheckoutScreenStepsAndroid;
import com.hs.mobile.steps.android.OrderAnythingScreenStepsAndroid;
import com.hs.mobile.steps.android.PaymentOptionsScreenStepsAndroid;
import com.hs.mobile.steps.android.QuickMarketScreenStepsAndroid;
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
  public AllStoresScreenSteps restaurantScreenSteps(TestSettings testSettings) {
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

  @Provides
  public LoginScreenSteps loginScreenSteps(TestSettings settings) {
    return new LoginScreenStepsAndroid(settings);
  }

  @Provides
  public MoreScreenSteps moreScreenSteps(TestSettings settings) {
    return new MoreScreenStepsAndroid(settings);
  }

  @Provides
  public CampaignScreenSteps campaignScreenSteps(TestSettings settings) {
    return new CampaignScreenStepsAndroid(settings);
  }

  @Provides
  public OrderAnythingScreenSteps orderAnythingSteps(TestSettings settings) {
    return new OrderAnythingScreenStepsAndroid(settings);
  }

  @Provides
  public QuickMarketScreenSteps quickMarketScreenSteps(TestSettings settings) {
    return new QuickMarketScreenStepsAndroid(settings);
  }

  @Provides
  public OrderAnythingCheckoutScreenSteps orderAnythingCheckoutScreenSteps(TestSettings settings) {
    return new OrderAnythingCheckoutScreenStepsAndroid(settings);
  }


}
