package com.hs.mobile.service.response.devices;

import com.hs.mobile.service.devices.model.AllDevices;
import io.restassured.response.Response;

public interface DeviceFarmerEndpointExtension extends Response {

  default AllDevices getAllDevices() {
    return this.as(AllDevices.class);
  }
}
