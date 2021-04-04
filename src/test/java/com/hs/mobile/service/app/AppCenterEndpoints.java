package com.hs.mobile.service.app;

import static org.openqa.selenium.Platform.ANDROID;

import com.hs.mobile.conf.TestProperties;
import com.hs.mobile.exception.ExceptionSupplier;
import com.hs.mobile.service.BaseEndpoint;
import com.hs.mobile.service.response.ServiceResponseDecorator;
import com.hs.mobile.service.response.app.AppCenterEndpointExtension;
import io.restassured.response.Response;
import java.util.Comparator;
import lombok.NonNull;
import org.openqa.selenium.Platform;

public class AppCenterEndpoints extends BaseEndpoint<AppCenterEndpoints> {
  private static final String appDetailsEndpoint = "/apps/{ownerName}/{name}/releases/{buildId}";
  private static final String appReleasesEndpoint = "/apps/{ownerName}/{name}/releases";
  private TestProperties properties;

  public AppCenterEndpoints(@NonNull TestProperties properties) {
    super(properties);
    this.properties = properties;
  }

  public AppCenterEndpointExtension getAppDetails(Platform platform) {
    String ownerName = platform.equals(ANDROID) ? "HungerStation-Platform" : "apps-054";
    String buildId =
        properties.getAppBuildId().equalsIgnoreCase("latest")
            ? getLatestBuildId(platform).toString()
            : properties.getAppBuildId();

    Response response =
        givenAppCenter()
            .pathParam("ownerName", ownerName)
            .pathParam("name", "HungerStation")
            .pathParam("buildId", buildId)
            .get(appDetailsEndpoint);

    return new ServiceResponseDecorator(response);
  }

  private Integer getLatestBuildId(Platform platform) {
    String ownerName = platform.equals(ANDROID) ? "HungerStation-Platform" : "apps-054";

    return givenAppCenter()
        .pathParam("ownerName", ownerName)
        .pathParam("name", "HungerStation")
        .get(appReleasesEndpoint)
        .then()
        .extract()
        .body()
        .jsonPath()
        .getList("id", Integer.class)
        .stream()
        .max(Comparator.naturalOrder())
        .orElseThrow(ExceptionSupplier.failedToInitializeTest("could not get latest build id"));
  }
}
