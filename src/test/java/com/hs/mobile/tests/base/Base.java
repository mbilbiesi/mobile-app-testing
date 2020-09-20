package com.hs.mobile.tests.base;

import com.google.inject.Inject;
import com.hs.mobile.conf.GuiceModuleFactory;
import com.hs.mobile.data.user.TestUser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Guice;

@Slf4j
@Guice(moduleFactory = GuiceModuleFactory.class)
public class Base {

  public boolean isLocationValid;
  @Inject protected TestUser testUser;
  @Inject protected AppiumDriver<MobileElement> driver;

  @AfterClass()
  public void teardown() {
    if (driver != null) {
       driver.quit();
    }
  }
}
