package com.hs.mobile.conf;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hs.mobile.conf.BaseTestModule.AppFilePath;
import com.hs.mobile.core.appium.caps.CapabilitiesManager;
import com.hs.mobile.core.settings.TestParameters;
import org.openqa.selenium.remote.DesiredCapabilities;

@SuppressWarnings("unused")
public class CapabilitiesModule extends AbstractModule {

  @Provides
  @Singleton
  public DesiredCapabilities capabilities(TestParameters testParameters, @AppFilePath String app) {
    return new CapabilitiesManager(testParameters, app).getDesiredCapabilities();
  }
}
