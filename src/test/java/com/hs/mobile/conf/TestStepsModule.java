package com.hs.mobile.conf;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.ios.LandingScreen;
import com.hs.mobile.screens.ios.SelectLocationScreen;
import com.hs.mobile.screens.ios.VerticalsScreen;
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
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class TestStepsModule extends AbstractModule {

  @Provides
  public HomeScreenSteps homeScreenSteps(TestSettings settings) {
    return new HomeScreenSteps(settings);
  }

  @Provides
  public RestaurantListScreenSteps restaurantsListSteps(TestSettings settings) {
    return new RestaurantListScreenSteps(settings);
  }

  @Provides
  public VerifyAccountScreenSteps verifyAccountScreenSteps(TestSettings settings) {
    return new VerifyAccountScreenSteps(settings);
  }

  @Provides
  public PinCodeVerificationSteps pinCodeVerificationSteps(TestSettings settings) {
    return new PinCodeVerificationSteps(settings);
  }

  @Provides
  public RestaurantScreenSteps restaurantScreenSteps(TestSettings settings) {
    return new RestaurantScreenSteps(settings);
  }

  @Provides
  public SavedLocationsScreenSteps savedLocationsScreenSteps(TestSettings settings) {
    return new SavedLocationsScreenSteps(settings);
  }

  @Provides
  public ProfileScreenSteps profileScreenSteps(TestSettings settings) {
    return new ProfileScreenSteps(settings);
  }

  @Provides
  public InvoicesScreenSteps invoicesScreenSteps(TestSettings settings) {
    return new InvoicesScreenSteps(settings);
  }

  @Provides
  public SettingsScreenSteps settingsScreenSteps(TestSettings settings) {
    return new SettingsScreenSteps(settings);
  }

  @Provides
  public PaymentOptionsSteps paymentOptionsSteps(TestSettings settings) {
    return new PaymentOptionsSteps(settings);
  }

  @Provides
  public WalletScreenSteps walletScreenSteps(TestSettings settings) {
    return new WalletScreenSteps(settings);
  }

  @Provides
  public MyOrdersSteps myOrdersSteps(TestSettings settings) {
    return new MyOrdersSteps(settings);
  }

  @Provides
  public OrderSteps orderSteps(TestSettings settings) {
    return new OrderSteps(settings);
  }

  @Provides
  public HelpSteps helpSteps(TestSettings settings) {
    return new HelpSteps(settings);
  }

  @Provides
  public TicketSteps ticketSteps(TestSettings settings) {
    return new TicketSteps(settings);
  }

  @Provides
  public CreateTicketSteps createTicketSteps(TestSettings settings) {
    return new CreateTicketSteps(settings);
  }

  @Provides
  public CheckoutScreenSteps checkoutScreenSteps(TestSettings settings) {
    return new CheckoutScreenSteps(settings);
  }

  @Provides
  public LocationScreenSteps locationScreenSteps(TestSettings settings) {
    return new LocationScreenSteps(settings);
  }

  @Provides
  public LandingScreen landingScreen(TestSettings testSettings){
    return new LandingScreen(testSettings);
  }


  @Provides
  public SelectLocationScreen selectLocationScreen(TestSettings testSettings){
    return new SelectLocationScreen(testSettings);
  }

  @Provides
  public VerticalsScreen verticalScreen(TestSettings testSettings){
    return new VerticalsScreen(testSettings);
  }


}
