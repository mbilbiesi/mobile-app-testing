package com.hs.mobile.data.devices;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hs.mobile.data.devices.model.TestDevices;
import com.hs.mobile.exception.TestExecutionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestDevicesProvider {
  private static final String DATA_TEST_DEVICES_JSON = "data/testDevices.json";
  private static final List<TestDevices> testDevicesList = new ArrayList<>();

  public TestDevicesProvider() {
    try {
      @SuppressWarnings("UnstableApiUsage")
      String testDevicesFile =
          Resources.toString(Resources.getResource(DATA_TEST_DEVICES_JSON), Charsets.UTF_8);
      testDevicesList.addAll(
          new ObjectMapper().readValue(testDevicesFile, new TypeReference<List<TestDevices>>() {}));
    } catch (IOException e) {
      log.error("Failed to read testDevice json file", e);
      throw new TestExecutionException("Error in deserializing Device file");
    }
  }

  public List<TestDevices> getTestDevicesList() {
    return testDevicesList;
  }
}
