package com.hs.mobile.core.appium.caps;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.AutomationName.IOS_XCUI_TEST;
import static org.openqa.selenium.Platform.ANDROID;
import static org.openqa.selenium.Platform.IOS;

import com.hs.mobile.core.settings.TestParameters;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

@RequiredArgsConstructor
public class CapabilitiesManager {

  public static final String XCODE_ORG_ID_VALUE = "WK247W7C8M";
  public static final String XCODE_SIGNING_ID_VALUE = "iPhone Developer";
  @NonNull private final TestParameters testParameters;
  @NonNull private final String appFilePath;

  public DesiredCapabilities getDesiredCapabilities() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    String uniquePort = testParameters.getUniquePort();
    String deviceUDID = testParameters.getDeviceUDID();
    String platformVersion = testParameters.getPlatformVersion();
    Platform platform = testParameters.getPlatform();
    String deviceName = testParameters.getDeviceName();

    switch (platform) {
      case ANDROID:
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
        capabilities.setCapability(MobileCapabilityType.APP, appFilePath);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, uniquePort);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
        capabilities.setCapability("autoGrantPermissions", true);
        break;

      case IOS:
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
        capabilities.setCapability(MobileCapabilityType.APP, appFilePath);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, IOS_XCUI_TEST);
        capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
        capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, uniquePort);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, IOS);
        capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
        capabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, XCODE_ORG_ID_VALUE);
        capabilities.setCapability(
            IOSMobileCapabilityType.XCODE_SIGNING_ID, XCODE_SIGNING_ID_VALUE);
        break;
    }

    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
    capabilities.setCapability("newCommandTimeout", 100);
    return capabilities;
  }
}
