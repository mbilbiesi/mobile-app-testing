package com.hs.mobile.tests.legacy;

import com.google.inject.Inject;
import com.hs.mobile.steps.legacy.CheckoutScreenSteps;
import com.hs.mobile.steps.legacy.CreateTicketSteps;
import com.hs.mobile.steps.legacy.HelpSteps;
import com.hs.mobile.steps.legacy.HomeScreenSteps;
import com.hs.mobile.steps.legacy.InvoicesScreenSteps;
import com.hs.mobile.steps.legacy.LocationScreenSteps;
import com.hs.mobile.steps.legacy.MyOrdersSteps;
import com.hs.mobile.steps.legacy.OrderSteps;
import com.hs.mobile.steps.legacy.PaymentOptionsSteps;
import com.hs.mobile.steps.legacy.PinCodeVerificationSteps;
import com.hs.mobile.steps.legacy.ProfileScreenSteps;
import com.hs.mobile.steps.legacy.RestaurantListScreenSteps;
import com.hs.mobile.steps.legacy.RestaurantScreenSteps;
import com.hs.mobile.steps.legacy.SavedLocationsScreenSteps;
import com.hs.mobile.steps.legacy.SettingsScreenSteps;
import com.hs.mobile.steps.legacy.TicketSteps;
import com.hs.mobile.steps.legacy.VerifyAccountScreenSteps;
import com.hs.mobile.steps.legacy.WalletScreenSteps;
import com.hs.mobile.tests.Base;

public class BaseSteps extends Base {

  @Inject protected HomeScreenSteps homeScreenSteps;
  @Inject protected LocationScreenSteps locationScreenSteps;
  @Inject protected RestaurantListScreenSteps restaurantsListSteps;
  @Inject protected SavedLocationsScreenSteps savedLocationsScreenSteps;
  @Inject protected RestaurantScreenSteps restaurantScreenSteps;
  @Inject protected VerifyAccountScreenSteps verifyAccountScreenSteps;
  @Inject protected PinCodeVerificationSteps pinCodeVerificationSteps;
  @Inject protected ProfileScreenSteps profileScreenSteps;
  @Inject protected InvoicesScreenSteps invoicesScreenSteps;
  @Inject protected SettingsScreenSteps settingsScreenSteps;
  @Inject protected PaymentOptionsSteps paymentOptionsSteps;
  @Inject protected WalletScreenSteps walletScreenSteps;
  @Inject protected MyOrdersSteps myOrdersSteps;
  @Inject protected OrderSteps orderSteps;
  @Inject protected HelpSteps helpSteps;
  @Inject protected TicketSteps ticketSteps;
  @Inject protected CreateTicketSteps createTicketSteps;
  @Inject protected CheckoutScreenSteps checkoutScreenSteps;
}
