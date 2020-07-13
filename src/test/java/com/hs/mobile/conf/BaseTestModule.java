package com.hs.mobile.conf;

import com.google.common.io.Resources;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hs.mobile.conf.annotation.AppFilePath;
import com.hs.mobile.conf.annotation.AppiumURL;
import com.hs.mobile.core.settings.TestSettings;
import org.testng.ITestContext;

@SuppressWarnings("unused")
public class BaseTestModule extends AbstractModule {

  private ITestContext iTestContext;

  public BaseTestModule(ITestContext iTestContext) {
    this.iTestContext = iTestContext;
  }

  @Override
  protected void configure() {
    install(new DataProviderModule());
    install(new TestStepsModule());
    install(new CapabilitiesModule());
    install(new DriverModule());
  }

  @Provides
  @Singleton
  public TestSettings testSettings(@AppFilePath String appFilePath, @AppiumURL String appiumURL) {
    String platform_name = iTestContext.getCurrentXmlTest().getParameter("platform_name");
    String platform_version = iTestContext.getCurrentXmlTest().getParameter("platform_version");
    String udid = iTestContext.getCurrentXmlTest().getParameter("udid");
    String uniquePort = iTestContext.getCurrentXmlTest().getParameter("uniquePort");
    String assignedTestUserId = iTestContext.getCurrentXmlTest().getParameter("assignedTestUserId");
    return TestSettings.builder()
        .platformName(platform_name)
        .platformVersion(platform_version)
        .appFilePath(appFilePath)
        .appiumURL(appiumURL)
        .deviceUDID(udid)
        .uniquePort(uniquePort)
        .assignedTestUserId(assignedTestUserId)
        .build();
  }

  @Provides
  @Singleton
  @AppFilePath
  public String appFilePath() {
    String platformName = iTestContext.getCurrentXmlTest().getParameter("platform_name");
    if (platformName.equalsIgnoreCase("android")) {
      return Resources.getResource("apps/app-debug.apk").getPath();
    } else {
      return Resources.getResource("apps/HungerStation.app").getPath();
    }
  }

  @Provides
  @Singleton
  @AppiumURL
  public String appiumURL() {
    return "http://localhost:4723/wd/hub";
  }
}
