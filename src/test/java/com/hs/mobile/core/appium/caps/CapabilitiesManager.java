package com.hs.mobile.core.appium.caps;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.AutomationName.IOS_XCUI_TEST;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.openqa.selenium.Platform.ANDROID;
import static org.openqa.selenium.Platform.IOS;

import com.hs.mobile.core.settings.TestParameters;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

@RequiredArgsConstructor
public class CapabilitiesManager {
  @NonNull private final TestParameters testParameters;
  @NonNull private final String appFilePath;

  public DesiredCapabilities getDesiredCapabilities() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    Integer uniquePort = Integer.valueOf(testParameters.getUniquePort());
    String deviceUDID = testParameters.getDeviceUDID();
    String platformVersion = testParameters.getPlatformVersion();
    Platform platform = testParameters.getPlatform();
    String deviceName = testParameters.getDeviceName();
    String resolvedName = StringUtils.joinWith("-", deviceName, deviceUDID);

    switch (platform) {
      case ANDROID:
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, resolvedName);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, resolvedName);
        capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
        capabilities.setCapability(MobileCapabilityType.APP, appFilePath);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, uniquePort);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID.name());
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, TRUE);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_LAUNCH, FALSE);
        break;

      case IOS:
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
        capabilities.setCapability(MobileCapabilityType.APP, appFilePath);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, IOS_XCUI_TEST);
        capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, uniquePort);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, IOS.name());
        capabilities.setCapability(IOSMobileCapabilityType.LOCATION_SERVICES_AUTHORIZED, TRUE);
        capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, TRUE);
        capabilities.setCapability(IOSMobileCapabilityType.WAIT_FOR_APP_SCRIPT, "true");
        break;
    }

    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
    capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, TRUE);
    capabilities.setCapability(MobileCapabilityType.FULL_RESET, TRUE);
    return capabilities;
  }
}
