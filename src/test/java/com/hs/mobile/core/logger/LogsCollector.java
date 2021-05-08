package com.hs.mobile.core.logger;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogsCollector {
  @NonNull private final AppiumDriver<?> driver;
  @NonNull private LoggerWebSocket loggerWebSocket;
  private Boolean isStarted = false;

  public void startCollectingPhoneLogs() {
    loggerWebSocket.resetMessageList();
    if (!isStarted) {
      driver.executeScript("mobile:startLogsBroadcast");
      loggerWebSocket.connect();
      isStarted = true;
    }
  }

  public void stopCollectingPhoneLogs() {
     driver.executeScript("mobile:stopLogsBroadcast");
     loggerWebSocket.close();
  }

  public List<String> getCollectedPhoneLogs() {
    return loggerWebSocket.getMessagesList();
  }
}
