package com.hs.mobile.conf;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hs.mobile.core.appium.caps.CapabilitiesManager;
import com.hs.mobile.core.settings.TestSettings;
import org.openqa.selenium.remote.DesiredCapabilities;

@SuppressWarnings("unused")
public class CapabilitiesModule extends AbstractModule {

  @Provides
  @Singleton
  public DesiredCapabilities capabilities(TestSettings testSettings) {
    return new CapabilitiesManager(testSettings).getDesiredCapabilities();
  }
}
