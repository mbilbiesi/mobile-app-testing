package com.hs.mobile.conf.ios;

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
import com.hs.mobile.steps.OrdersScreenSteps;
import com.hs.mobile.steps.PaymentOptionsScreenSteps;
import com.hs.mobile.steps.QuickMarketScreenSteps;
import com.hs.mobile.steps.RestaurantMenuScreenSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;
import com.hs.mobile.steps.ios.AllStoresScreenStepsIOS;
import com.hs.mobile.steps.ios.CampaignScreenStepsIOS;
import com.hs.mobile.steps.ios.CheckoutScreenStepsIOS;
import com.hs.mobile.steps.ios.LandingScreenStepsIOS;
import com.hs.mobile.steps.ios.LoginScreenStepsIOS;
import com.hs.mobile.steps.ios.MenuItemStepsIOS;
import com.hs.mobile.steps.ios.MoreScreenStepsIOS;
import com.hs.mobile.steps.ios.OrderAnythingCheckoutScreenStepsIOS;
import com.hs.mobile.steps.ios.OrderAnythingStepsIOS;
import com.hs.mobile.steps.ios.OrdersScreenStepsIOS;
import com.hs.mobile.steps.ios.PaymentOptionsScreenStepsIOS;
import com.hs.mobile.steps.ios.QuickMarketScreenStepsIOS;
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
  public AllStoresScreenSteps allStoresScreenSteps(TestSettings testSettings) {
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

  @Provides
  public CampaignScreenSteps campaignScreenSteps(TestSettings settings) {
    return new CampaignScreenStepsIOS(settings);
  }

  @Provides
  public OrderAnythingScreenSteps orderAnythingScreenSteps(TestSettings settings) {
    return new OrderAnythingStepsIOS(settings);
  }

  @Provides
  public QuickMarketScreenSteps quickMarketScreenSteps(TestSettings settings) {
    return new QuickMarketScreenStepsIOS(settings);
  }

  @Provides
  public OrdersScreenSteps ordersScreenSteps(TestSettings settings) {
    return new OrdersScreenStepsIOS(settings);
  }

  @Provides
  public OrderAnythingCheckoutScreenSteps orderAnythingCheckoutScreenSteps(TestSettings settings) {
    return new OrderAnythingCheckoutScreenStepsIOS(settings);
  }
}
