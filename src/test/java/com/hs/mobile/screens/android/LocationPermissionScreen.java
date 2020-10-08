package com.hs.mobile.screens.android;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class LocationPermissionScreen extends AbstractScreen<LocationPermissionScreen> {

  @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
  private AndroidElement lblPermissionMessage;

  @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_always_button")
  private AndroidElement btnAllowAllTime;

  @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
  private AndroidElement btnAllowForegroundOnly;

  @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
  private AndroidElement btnDeny;

  public LocationPermissionScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
