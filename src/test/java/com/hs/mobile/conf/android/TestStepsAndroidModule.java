package com.hs.mobile.conf.android;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.steps.LandingScreenSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;
import com.hs.mobile.steps.android.LandingScreenStepsAndroid;
import com.hs.mobile.steps.android.SelectLocationScreenStepsAndroid;
import com.hs.mobile.steps.android.VerticalsScreenStepsAndroid;

@SuppressWarnings("unused")
public class TestStepsAndroidModule extends AbstractModule {

  @Provides
  public LandingScreenSteps landingScreenSteps(TestSettings testSettings) {
    return new LandingScreenStepsAndroid(testSettings);
  }

  @Provides
  public SelectLocationScreenSteps selectLocationScreenSteps(TestSettings testSettings) {
    return new SelectLocationScreenStepsAndroid(testSettings);
  }

  @Provides
  public VerticalsScreenSteps verticalsScreenSteps(TestSettings testSettings) {
    return new VerticalsScreenStepsAndroid(testSettings);
  }
}
