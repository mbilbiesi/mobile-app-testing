package com.hs.mobile.tests;

import com.google.inject.Inject;
import com.hs.mobile.steps.AllStoresScreenSteps;
import com.hs.mobile.steps.CampaignScreenSteps;
import com.hs.mobile.steps.CheckoutScreenSteps;
import com.hs.mobile.steps.LandingScreenSteps;
import com.hs.mobile.steps.LoginScreenSteps;
import com.hs.mobile.steps.MenuItemScreenSteps;
import com.hs.mobile.steps.MoreScreenSteps;
import com.hs.mobile.steps.OrderAnythingScreenSteps;
import com.hs.mobile.steps.PaymentOptionsScreenSteps;
import com.hs.mobile.steps.RestaurantMenuScreenSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;

public abstract class BaseTestSteps extends Base {
  @Inject protected LandingScreenSteps landingScreenSteps;
  @Inject protected SelectLocationScreenSteps selectLocationScreenSteps;
  @Inject protected VerticalsScreenSteps verticalsScreenSteps;
  @Inject protected AllStoresScreenSteps allStoresScreenSteps;
  @Inject protected RestaurantMenuScreenSteps restaurantMenuScreenSteps;
  @Inject protected MenuItemScreenSteps menuItemScreenSteps;
  @Inject protected CheckoutScreenSteps checkoutScreenSteps;
  @Inject protected PaymentOptionsScreenSteps paymentOptionsScreenSteps;
  @Inject protected LoginScreenSteps loginScreenSteps;
  @Inject protected MoreScreenSteps moreScreenSteps;
  @Inject protected CampaignScreenSteps campaignScreenSteps;
  @Inject protected OrderAnythingScreenSteps orderAnythingScreenSteps;
}
