package com.hs.mobile.tests.base;

import com.google.inject.Inject;
import com.hs.mobile.conf.GuiceModuleFactory;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.data.restaurants.RestaurantsProvider;
import com.hs.mobile.data.user.TestUser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;

@Slf4j
@Guice(moduleFactory = GuiceModuleFactory.class)
public class BaseInitiator {

  public boolean isLocationValid;
  @Inject
  protected TestUser testUser;
  @Inject
  protected AppiumDriver<MobileElement> driver;

  protected RestaurantsProvider restaurantsData;


  @BeforeClass
  void startAppiumServer() {
    String language = testUser.getLanguage();
    Location location = setDeviceLocation(31.963158, 35.930359, false); // Amman
    driver.setLocation(location);
    restaurantsData = new RestaurantsProvider(language);
  }

  private Location setDeviceLocation(double latitude, double longitude, boolean locValid) {
    Location location = new Location(latitude, longitude, 5.0);
    this.isLocationValid = locValid;
    // Current implementation has to be changed to handle setting location dynamically based on our
    // inputs.

    return location;
  }

  @AfterClass()
  public void teardown() {
    if (driver != null) {
      //driver.resetApp();
      driver.quit();
    }
  }
}
