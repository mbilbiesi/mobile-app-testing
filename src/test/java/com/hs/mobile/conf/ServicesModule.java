package com.hs.mobile.conf;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hs.mobile.service.app.AppCenterEndpoints;
import com.hs.mobile.service.devices.DevicesClient;
import org.aeonbits.owner.ConfigFactory;

@SuppressWarnings("unused")
public class ServicesModule extends AbstractModule {

  @Provides
  @Singleton
  public TestProperties properties() {
    return ConfigFactory.create(TestProperties.class, System.getProperties());
  }

  @Provides
  public AppCenterEndpoints appCenterEndpoints(TestProperties properties) {
    return new AppCenterEndpoints(properties);
  }

  @Provides
  public DevicesClient devicesClient(TestProperties properties) {
    return new DevicesClient(properties);
  }
}
