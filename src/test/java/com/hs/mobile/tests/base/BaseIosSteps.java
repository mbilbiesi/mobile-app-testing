package com.hs.mobile.tests.base;

import com.google.inject.Inject;
import com.hs.mobile.steps.ios.LandingScreenSteps;
import com.hs.mobile.steps.ios.SelectLocationScreenSteps;
import com.hs.mobile.steps.ios.VerticalsScreenSteps;

@SuppressWarnings("unused")
public class BaseIosSteps extends BaseInitiator {

  @Inject
  protected LandingScreenSteps landingScreenSteps;
  @Inject
  protected SelectLocationScreenSteps selectLocationScreenSteps;
  @Inject
  protected VerticalsScreenSteps verticalsScreenSteps;
}
