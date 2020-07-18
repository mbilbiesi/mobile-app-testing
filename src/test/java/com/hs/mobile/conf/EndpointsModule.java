package com.hs.mobile.conf;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hs.mobile.service.app.AppCenterEndpoints;

@SuppressWarnings("unused")
public class EndpointsModule extends AbstractModule {

  @Provides
  @Singleton
  public AppCenterEndpoints appCenterEndpoints(TestProperties properties) {
    return new AppCenterEndpoints(properties.getAppCenterUrl(), properties.getFunPlay());
  }
}
