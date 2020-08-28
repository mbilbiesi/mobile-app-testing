package com.hs.mobile.tests.base;

import com.google.inject.Inject;
import com.hs.mobile.steps.CheckoutScreenSteps;
import com.hs.mobile.steps.CreateTicketSteps;
import com.hs.mobile.steps.HelpSteps;
import com.hs.mobile.steps.HomeScreenSteps;
import com.hs.mobile.steps.InvoicesScreenSteps;
import com.hs.mobile.steps.LocationScreenSteps;
import com.hs.mobile.steps.MyOrdersSteps;
import com.hs.mobile.steps.OrderSteps;
import com.hs.mobile.steps.PaymentOptionsSteps;
import com.hs.mobile.steps.PinCodeVerificationSteps;
import com.hs.mobile.steps.ProfileScreenSteps;
import com.hs.mobile.steps.RestaurantListScreenSteps;
import com.hs.mobile.steps.RestaurantScreenSteps;
import com.hs.mobile.steps.SavedLocationsScreenSteps;
import com.hs.mobile.steps.SettingsScreenSteps;
import com.hs.mobile.steps.TicketSteps;
import com.hs.mobile.steps.VerifyAccountScreenSteps;
import com.hs.mobile.steps.WalletScreenSteps;

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
