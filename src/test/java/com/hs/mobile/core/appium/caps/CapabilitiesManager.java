package com.hs.mobile.core.appium.caps;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.AutomationName.IOS_XCUI_TEST;
import static org.openqa.selenium.Platform.ANDROID;
import static org.openqa.selenium.Platform.IOS;

import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.remote.DesiredCapabilities;

@RequiredArgsConstructor
public class CapabilitiesManager {

  @NonNull
  private final TestSettings testSettings;

  public DesiredCapabilities getDesiredCapabilities() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    String uniquePort = testSettings.getUniquePort();
    String deviceUDID = testSettings.getDeviceUDID();
    String platformVersion = testSettings.getPlatformVersion();
    String platformName = testSettings.getPlatformName().toLowerCase();
    String appFilePath = testSettings.getAppFilePath();

    switch (platformName) {
      case "android":
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "DeviceName");
        capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
        capabilities.setCapability(MobileCapabilityType.APP, appFilePath);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
        break;

      case "ios":
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
        capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
        capabilities.setCapability(MobileCapabilityType.APP, appFilePath);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, IOS_XCUI_TEST);
        capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, IOS);
        break;
    }

    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
    capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, uniquePort);
    capabilities.setCapability("autoGrantPermissions", true);
    return capabilities;
  }
}
