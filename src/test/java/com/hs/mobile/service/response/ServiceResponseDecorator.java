package com.hs.mobile.service.response;

import com.hs.mobile.service.response.app.AppCenterEndpointExtension;
import com.hs.mobile.service.response.devices.DeviceFarmerEndpointExtension;
import io.restassured.response.Response;

public class ServiceResponseDecorator extends ResponseDecorated
    implements AppCenterEndpointExtension, DeviceFarmerEndpointExtension {

  public ServiceResponseDecorator(Response response) {
    super(response);
  }
}
