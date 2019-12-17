package com.hs.mobile.rest.endpoints;

import com.google.common.collect.ImmutableMap;
import io.restassured.response.Response;
import org.apache.http.HttpHeaders;

import java.util.Map;

import static com.hs.mobile.data.Language.ARABIC;

public class MenusEndpoint extends BaseEndpoint {
    private final String MENUS_URL = STAGING_HOST + "api/v2/menus";
    private static final Map<String, String> HEADERS
            = ImmutableMap.of(HttpHeaders.ACCEPT_LANGUAGE, ARABIC.getValue());

    public Response getMenusResponse(final Map<String, String> queryParams) {
        return getBaseRequestSpecification()
                .headers(HEADERS)
                .queryParams(queryParams)
                .get(MENUS_URL)
                .then()
                .extract()
                .response();
    }
}
