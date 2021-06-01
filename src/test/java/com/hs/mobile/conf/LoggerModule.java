package com.hs.mobile.conf;

import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hs.mobile.core.logger.LoggerWebSocket;
import com.hs.mobile.core.logger.LogsCollector;
import com.hs.mobile.exception.TestInitializationException;
import com.rationaleemotions.GridApiAssistant;
import com.rationaleemotions.pojos.Host;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unused")
@Slf4j
public class LoggerModule extends PrivateModule {

  @Override
  protected void configure() {
    expose(LogsCollector.class);
  }

  @Provides
  @Singleton
  private LogsCollector logsCollector(AppiumDriver<?> driver, LoggerWebSocket loggerWebSocket) {
    return new LogsCollector(driver, loggerWebSocket);
  }

  @Provides
  private LoggerWebSocket loggerWebSocket(URI socketURI) {
    return new LoggerWebSocket(socketURI);
  }

  @Provides
  private Host getDriverSessionHost(TestProperties properties, AppiumDriver<?> driver)
      throws MalformedURLException {
    Host hubHost = new Host(properties.getAppiumServerUrl());
    GridApiAssistant assistant = new GridApiAssistant(hubHost);
    return assistant.getNodeDetailsForSession(driver.getSessionId().toString());
  }

  @Provides
  private URI getWebSocketUri(Host driverSessionHost, AppiumDriver<?> driver) {
    String logType = driver instanceof AndroidDriver ? "logcat" : "syslog";

    try {
      var resolvedUrlLink =
          String.format(
              "ws://%s:%s/ws/session/%s/appium/device/%s",
              driverSessionHost.getIpAddress(),
              driverSessionHost.getPort(),
              driver.getSessionId().toString(),
              logType);

      log.debug("Log WebSocket resolved url is : " + resolvedUrlLink);
      return new URI(resolvedUrlLink);
    } catch (URISyntaxException e) {
      throw new TestInitializationException("Could not resolve WebSocket URL");
    }
  }
}
