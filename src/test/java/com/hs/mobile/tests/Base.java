package com.hs.mobile.tests;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.hs.mobile.conf.BaseTestModule;
import com.hs.mobile.conf.TestProperties;
import com.hs.mobile.conf.android.TestStepsAndroidModule;
import com.hs.mobile.conf.ios.TestStepsIOSModule;
import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.service.devices.DevicesClient;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Platform;
import org.testng.ITestContext;
import org.testng.annotations.*;

import static com.hs.mobile.core.settings.TestInjectors.INJECTORS;

@Slf4j
@Listeners({TestListener.class})
public abstract class Base {
  @Inject protected DevicesClient devicesClient;
  @Inject @Getter protected AppiumDriver<?> driver;
  //@Inject @Getter protected LogsCollector logsCollector;
  @Inject @Getter protected TestProperties testProperties;

  @BeforeTest
  public void prepareTestRun(ITestContext context) {
    INJECTORS.addInjector(
        context.getName(),
        Guice.createInjector(new BaseTestModule(context), getStepsModule(context)));
    log.debug("Injector created for : {}", context.getCurrentXmlTest().getAllParameters());
  }

  @BeforeClass
  public void beforeClass(ITestContext context) {
    INJECTORS.getInjector(context.getName()).injectMembers(this);
    driver.launchApp();
    driver.activateApp("com.hungerstation.ios.hungerstationapp");
  }

  @AfterClass(alwaysRun = true)
  @Step("close the app")
  public void closeApp() {
    try {
      driver.closeApp();
    } catch (Exception exception) {
      log.info("session is not exist or already terminated");
    }
  }

  @AfterTest
  public void releaseSessions(ITestContext context) {
    try {
      driver.quit();
    } catch (Exception exception) {
      log.info("session is not exist or already terminated");
    }

    if (!context.getSuite().getName().equals("local")) {
      devicesClient.releaseDevice(context.getCurrentXmlTest().getParameter("udid"));
    }
  }

  private Module getStepsModule(ITestContext context) {
    String platformName = context.getCurrentXmlTest().getParameter("platformName");
    Platform platform = Platform.fromString(platformName);
    return platform.is(Platform.IOS) ? new TestStepsIOSModule() : new TestStepsAndroidModule();
  }
}
