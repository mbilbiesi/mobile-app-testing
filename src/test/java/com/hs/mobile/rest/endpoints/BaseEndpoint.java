package com.hs.mobile.rest.endpoints;

import com.google.common.collect.ImmutableMap;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class BaseEndpoint {
    final static String STAGING_HOST = "https://hs-staging.com/";
    private static final Map<String, String> DEFAULT_HEADERS
            = ImmutableMap.of(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON.getMimeType());

    RequestSpecification getBaseRequestSpecification() {
        return given()
                .baseUri(STAGING_HOST)
                .headers(DEFAULT_HEADERS)
                .log().uri()
                .filter(new ResponseLoggingFilter());
    }
}
