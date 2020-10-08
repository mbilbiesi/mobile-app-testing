package com.hs.mobile.tests;

import com.google.inject.Inject;
import com.hs.mobile.steps.LandingScreenSteps;
import com.hs.mobile.steps.SelectLocationScreenSteps;
import com.hs.mobile.steps.VerticalsScreenSteps;

public abstract class BaseSteps extends Base {
  @Inject protected LandingScreenSteps landingScreenSteps;
  @Inject protected SelectLocationScreenSteps selectLocationScreenSteps;
  @Inject protected VerticalsScreenSteps verticalsScreenSteps;
}
