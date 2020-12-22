package com.hs.mobile.service.response.app;

import io.restassured.response.Response;

public interface AppCenterEndpointExtension extends Response {

  default String getDownloadUrl() {
    return this.jsonPath().getString("download_url");
  }
}
