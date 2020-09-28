package com.hs.mobile.service.app;

import static org.openqa.selenium.Platform.ANDROID;

import com.hs.mobile.service.response.AppCenterEndpointExtension;
import com.hs.mobile.service.response.ServiceResponseDecorator;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.Platform;

@RequiredArgsConstructor
public class AppCenterEndpoints {
  private static final String appDetailsEndpoint = "/apps/{ownerName}/{name}/releases/latest";
  @NonNull private final String url;
  @NonNull private final String token;

  public AppCenterEndpointExtension getAppDetails(Platform platform) {
    String ownerName = platform.equals(ANDROID) ? "HungerStation-Platform" : "apps-054";
    Response response =
        given()
            .header("X-Api-Token", token)
            .pathParam("ownerName", ownerName)
            .pathParam("name", "HungerStation")
            .get(appDetailsEndpoint);

    return new ServiceResponseDecorator(response);
  }

  private RequestSpecification given() {
    return RestAssured.given().spec(getRestAssuredConfig()).baseUri(url);
  }

  private RequestSpecification getRestAssuredConfig() {
    return new RequestSpecBuilder()
        .log(LogDetail.URI)
        .setUrlEncodingEnabled(true)
        .addFilter(
            new AllureRestAssured()
                .setRequestTemplate("request.ftl")
                .setResponseTemplate("response.ftl"))
        .build();
  }
}
