package com.hs.mobile.tests.base;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.hs.mobile.conf.BaseTestModule;
import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.data.user.TestUser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Slf4j
@Listeners(TestListener.class)
public class Base {

  @Inject protected TestUser testUser;
  @Inject protected AppiumDriver<MobileElement> driver;

  @BeforeClass
  public void setup(ITestContext context) {
    Injector injector = Guice.createInjector(new BaseTestModule(context));
    injector.injectMembers(this);
    log.debug(
        "Injector created for the following test context "
            + context.getCurrentXmlTest().getAllParameters());
  }

  @AfterClass()
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
