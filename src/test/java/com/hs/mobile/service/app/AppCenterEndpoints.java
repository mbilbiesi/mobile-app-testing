package com.hs.mobile.service.app;

import static org.openqa.selenium.Platform.ANDROID;

import com.hs.mobile.conf.TestProperties;
import com.hs.mobile.service.BaseEndpoint;
import com.hs.mobile.service.response.ServiceResponseDecorator;
import com.hs.mobile.service.response.app.AppCenterEndpointExtension;
import io.restassured.response.Response;
import lombok.NonNull;
import org.openqa.selenium.Platform;

public class AppCenterEndpoints extends BaseEndpoint<AppCenterEndpoints> {
  private static final String appDetailsEndpoint = "/apps/{ownerName}/{name}/releases/latest";

  public AppCenterEndpoints(@NonNull TestProperties properties) {
    super(properties);
  }

  public AppCenterEndpointExtension getAppDetails(Platform platform) {
    String ownerName = platform.equals(ANDROID) ? "HungerStation-Platform" : "apps-054";
    Response response =
        givenAppCenter()
            .pathParam("ownerName", ownerName)
            .pathParam("name", "HungerStation")
            .get(appDetailsEndpoint);

    return new ServiceResponseDecorator(response);
  }
}
