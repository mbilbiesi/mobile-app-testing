package com.hs.mobile.service;

import com.hs.mobile.conf.TestProperties;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHeaders;

@RequiredArgsConstructor
public abstract class BaseEndpoint<T extends BaseEndpoint<T>> {
  @NonNull private final TestProperties properties;

  protected RequestSpecification givenAppCenter() {
    return getBaseRequestSpecs()
        .baseUri(properties.getAppCenterUrl())
        .header("X-Api-Token", properties.getFunPlay());
  }

  protected RequestSpecification givenDeviceFarmer() {
    return getBaseRequestSpecs()
        .relaxedHTTPSValidation()
        .baseUri(properties.getDeviceFarmerUrl())
        .header(HttpHeaders.AUTHORIZATION, "Bearer " + properties.getDeviceFarmerToken());
  }

  private RequestSpecification getBaseRequestSpecs() {
    return RestAssured.given().spec(getRestAssuredConfig());
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
