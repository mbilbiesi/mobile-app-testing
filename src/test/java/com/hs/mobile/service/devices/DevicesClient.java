package com.hs.mobile.service.devices;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

import com.hs.mobile.conf.TestProperties;
import com.hs.mobile.service.BaseEndpoint;
import com.hs.mobile.service.response.ServiceResponseDecorator;
import com.hs.mobile.service.response.devices.DeviceFarmerEndpointExtension;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.NonNull;

public class DevicesClient extends BaseEndpoint<DevicesClient> {
  private static final String DEVICES_PATH = "/api/v1/devices";
  private static final String ASSIGN_DEVICE_PATH = "/api/v1/user/devices";
  private static final String RELEASE_DEVICE_PATH = "/api/v1/user/devices/{deviceSerial}";

  public DevicesClient(@NonNull TestProperties properties) {
    super(properties);
  }

  public DeviceFarmerEndpointExtension getAllDevicesInfo() {
    Response response = givenDeviceFarmer().get(DEVICES_PATH);
    return new ServiceResponseDecorator(response);
  }

  public void assignDeviceToUser(String deviceSerial) {
    givenDeviceFarmer()
        .contentType(ContentType.JSON)
        .body("{\"serial\": \"" + deviceSerial + "\"}")
        .post(ASSIGN_DEVICE_PATH)
        .then()
        .assertThat()
        .statusCode(SC_OK)
        .body("success", equalTo(true));
  }

  public void releaseDevice(String deviceSerial) {
    givenDeviceFarmer()
        .contentType(ContentType.JSON)
        .pathParam("deviceSerial", deviceSerial)
        .delete(RELEASE_DEVICE_PATH);
  }
}
