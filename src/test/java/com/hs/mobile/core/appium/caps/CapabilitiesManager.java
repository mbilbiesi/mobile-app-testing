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

  @NonNull
  private final TestParameters testParameters;
  @NonNull
  private final String appFilePath;

  public DesiredCapabilities getDesiredCapabilities() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    String uniquePort = testParameters.getUniquePort();
    String deviceUDID = testParameters.getDeviceUDID();
    String platformVersion = testParameters.getPlatformVersion();
    Platform platform = testParameters.getPlatform();

    switch (platform) {
      case ANDROID:
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "DeviceName");
        capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
        capabilities.setCapability(MobileCapabilityType.APP, appFilePath);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID.name());
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, uniquePort);
        break;

      case IOS:
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Pro Max");
        capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
        capabilities.setCapability(MobileCapabilityType.APP, appFilePath);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, IOS_XCUI_TEST);
        capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, IOS.name());
        capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, uniquePort);

        //capabilities.setCapability("autoAcceptAlerts", true);
        //capabilities.setCapability("autoDismissAlerts", true);
        break;
    }

    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
    //capabilities.setCapability("autoGrantPermissions", true);
    return capabilities;
  }
}
