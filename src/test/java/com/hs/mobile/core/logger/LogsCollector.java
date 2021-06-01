package com.hs.mobile.core.logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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
      if (driver instanceof AndroidDriver) {
        ((AndroidDriver<?>) driver).startLogcatBroadcast();
      } else {
        ((IOSDriver<?>) driver).startSyslogBroadcast();
      }
      loggerWebSocket.connect();
      isStarted = true;
    }
  }

  public void stopCollectingPhoneLogs() {
    if (driver instanceof AndroidDriver) {
      ((AndroidDriver<?>) driver).stopLogcatBroadcast();
    } else {
      ((IOSDriver<?>) driver).stopSyslogBroadcast();
    }
    loggerWebSocket.close();
  }

  public List<String> getCollectedPhoneLogs() {
    return loggerWebSocket.getMessagesList();
  }
}
