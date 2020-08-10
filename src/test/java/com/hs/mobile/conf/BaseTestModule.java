package com.hs.mobile.conf;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hs.mobile.core.settings.TestParameters;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.data.Language;
import com.hs.mobile.data.user.TestUser;
import com.hs.mobile.service.app.AppCenterEndpoints;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;
import lombok.NonNull;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Platform;
import org.testng.ITestContext;

@SuppressWarnings("unused")
public class BaseTestModule extends AbstractModule {
  @NonNull private final ITestContext iTestContext;

  public BaseTestModule(ITestContext iTestContext) {
    this.iTestContext = iTestContext;
  }

  @Override
  protected void configure() {
    install(new DataProviderModule());
    install(new TestStepsModule());
    install(new CapabilitiesModule());
    install(new DriverModule());
    install(new EndpointsModule());
    install(new UtilsModule());
  }

  @Provides
  @Singleton
  public TestProperties properties() {
    return ConfigFactory.create(TestProperties.class, System.getProperties());
  }

  @Provides
  @Singleton
  public TestSettings testSettings(AppiumDriver<MobileElement> driver, TestUser testUser) {
    return TestSettings.builder()
        .driver(driver)
        .testLanguage(Language.fromString(testUser.getLanguage()))
        .build();
  }

  @Provides
  @Singleton
  public TestParameters testParameters(TestProperties properties) {
    String platformName = iTestContext.getCurrentXmlTest().getParameter("platformName");
    String platformVersion = iTestContext.getCurrentXmlTest().getParameter("platformVersion");
    String udid = iTestContext.getCurrentXmlTest().getParameter("udid");
    String uniquePort = iTestContext.getCurrentXmlTest().getParameter("uniquePort");
    String assignedTestUserId = iTestContext.getCurrentXmlTest().getParameter("assignedTestUserId");

    return TestParameters.builder()
        .platform(Platform.fromString(platformName))
        .platformVersion(platformVersion)
        .deviceUDID(udid)
        .uniquePort(uniquePort)
        .assignedTestUserId(assignedTestUserId)
        .appiumURL(properties.getAppiumServerUrl())
        .build();
  }

  @Provides
  @Singleton
  @AppFilePath
  public String appFilePath(AppCenterEndpoints appCenterEndpoints, TestParameters parameters) {
    return appCenterEndpoints.getAppDetails(parameters.getPlatform()).getDownloadUrl();
  }

  @Qualifier
  @Target({FIELD, PARAMETER, METHOD})
  @Retention(RUNTIME)
  public @interface AppFilePath {}
}