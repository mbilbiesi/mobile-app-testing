package com.hs.mobile.service.response;

import io.restassured.response.Response;

public class ServiceResponseDecorator extends ResponseDecorated
    implements AppCenterEndpointExtension {

  public ServiceResponseDecorator(Response response) {
    super(response);
  }
}
