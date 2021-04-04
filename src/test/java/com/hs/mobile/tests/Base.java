package com.hs.mobile.tests;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.hs.mobile.conf.BaseTestModule;
import com.hs.mobile.conf.android.TestStepsAndroidModule;
import com.hs.mobile.conf.ios.TestStepsIOSModule;
import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.service.devices.DevicesClient;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Platform;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Slf4j
@Listeners(TestListener.class)
abstract class Base {
  private static ConcurrentMap<String, Injector> injectors = new ConcurrentHashMap<>();
  @Inject protected DevicesClient devicesClient;
  @Inject protected AppiumDriver<MobileElement> driver;

  @BeforeTest
  public void prepareTestRun(ITestContext context) {
    injectors.putIfAbsent(
        context.getName(),
        Guice.createInjector(new BaseTestModule(context), getStepsModule(context)));
    log.debug("Injector created for : {}", context.getCurrentXmlTest().getAllParameters());
  }

  @BeforeClass
  public void beforeClass(ITestContext context) {
    injectors.get(context.getName()).injectMembers(this);
    driver.launchApp();
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
