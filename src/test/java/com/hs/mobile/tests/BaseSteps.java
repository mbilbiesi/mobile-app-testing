package com.hs.mobile.tests;

import com.google.inject.Inject;
import com.hs.mobile.steps.CheckoutScreenSteps;
import com.hs.mobile.steps.LandingScreenSteps;
import com.hs.mobile.steps.MenuItemScreenSteps;
import com.hs.mobile.steps.PaymentOptionsScreenSteps;
import com.hs.mobile.steps.RestaurantMenuScreenSteps;
import com.hs.mobile.steps.RestaurantScreenSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;

public abstract class BaseSteps extends Base {
  @Inject protected LandingScreenSteps landingScreenSteps;
  @Inject protected SelectLocationScreenSteps selectLocationScreenSteps;
  @Inject protected VerticalsScreenSteps verticalsScreenSteps;
  @Inject protected RestaurantScreenSteps restaurantScreenSteps;
  @Inject protected RestaurantMenuScreenSteps restaurantMenuScreenSteps;
  @Inject protected MenuItemScreenSteps menuItemScreenSteps;
  @Inject protected CheckoutScreenSteps checkoutScreenSteps;
  @Inject protected PaymentOptionsScreenSteps paymentOptionsScreenSteps;
}
