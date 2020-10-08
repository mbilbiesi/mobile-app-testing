package com.hs.mobile.conf.ios;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.LandingScreenSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;
import com.hs.mobile.steps.ios.LandingScreenStepsIOS;
import com.hs.mobile.steps.ios.SelectLocationScreenStepsIOS;
import com.hs.mobile.steps.ios.VerticalsScreenStepsIOS;

@SuppressWarnings("unused")
public class TestStepsIOSModule extends AbstractModule {

  @Provides
  public LandingScreenSteps landingScreenSteps(TestSettings testSettings) {
    return new LandingScreenStepsIOS(testSettings);
  }

  @Provides
  public SelectLocationScreenSteps selectLocationScreenSteps(TestSettings testSettings) {
    return new SelectLocationScreenStepsIOS(testSettings);
  }

  @Provides
  public VerticalsScreenSteps verticalsScreenSteps(TestSettings testSettings) {
    return new VerticalsScreenStepsIOS(testSettings);
  }
}
