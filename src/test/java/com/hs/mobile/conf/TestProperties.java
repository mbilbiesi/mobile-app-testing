package com.hs.mobile.conf;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:test-props.properties")
public interface TestProperties extends Config {

  @Key("appium.server.url")
  String getAppiumServerUrl();

  @Key("app.center.url")
  String getAppCenterUrl();

  @Key("fun.play")
  String getFunPlay();
}
