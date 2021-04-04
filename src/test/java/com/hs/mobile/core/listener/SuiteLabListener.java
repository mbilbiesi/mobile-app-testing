package com.hs.mobile.core.listener;

import static org.openqa.selenium.Platform.IOS;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.hs.mobile.conf.ServicesModule;
import com.hs.mobile.conf.TestProperties;
import com.hs.mobile.data.devices.TestDevicesProvider;
import com.hs.mobile.data.devices.model.TestDevices;
import com.hs.mobile.exception.ExceptionSupplier;
import com.hs.mobile.service.devices.DevicesClient;
import com.hs.mobile.service.devices.model.AllDevices;
import com.hs.mobile.service.devices.model.DevicesItem;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class SuiteLabListener implements IAlterSuiteListener {
  private static final List<TestDevices> devicesList =
      new TestDevicesProvider().getTestDevicesList();
  @Inject DevicesClient devicesClient;
  @Inject TestProperties properties;

  @Override
  public void alter(List<XmlSuite> suites) {
    Guice.createInjector(new ServicesModule()).injectMembers(this);
    var allLabDevices = devicesClient.getAllDevicesInfo().getAllDevices();

    var xmlSuite = suites.get(0);
    var availableLabDevices = getAvailableListOfDeviceForSuite(xmlSuite.getName(), allLabDevices);

    if (!properties.getUseAllLabDevices()) {
      availableLabDevices = extractTestDevicesFromDevicesLab(availableLabDevices);
    }

    assignAvailableDevicesToUser(availableLabDevices);

    List<XmlTest> testList =
        availableLabDevices.stream()
            .map(
                device -> {
                  XmlTest test = new XmlTest(xmlSuite);
                  test.setName(getDeviceName(device));
                  var params = xmlSuite.getTests().get(0).getAllParameters();
                  params.putAll(generateTestParams(device));
                  test.setParameters(params);
                  test.setXmlClasses(xmlSuite.getTests().get(0).getClasses());
                  return test;
                })
            .collect(Collectors.toList());

    xmlSuite.setTests(testList);
  }

  private List<DevicesItem> extractTestDevicesFromDevicesLab(List<DevicesItem> labDevices) {
    var testDevicesSerials =
        devicesList.stream().map(TestDevices::getSerial).collect(Collectors.toList());

    return labDevices.stream()
        .filter(devicesItem -> testDevicesSerials.contains(devicesItem.serial()))
        .collect(Collectors.toList());
  }

  private void assignAvailableDevicesToUser(List<DevicesItem> availableListOfDeviceForSuite) {
    availableListOfDeviceForSuite.forEach(
        devicesItem -> devicesClient.assignDeviceToUser(devicesItem.serial()));
  }

  private Map<String, String> generateTestParams(DevicesItem device) {
    return Map.of(
        "platformName",
        device.platform(),
        "platformVersion",
        device.version(),
        "udid",
        device.serial(),
        "uniquePort",
        getDevicePort(device.serial()),
        "assignedTestUserId",
        "1",
        "deviceName",
        getDeviceName(device));
  }

  private String getDevicePort(String deviceId) {
    return devicesList.stream()
        .filter(device -> device.getSerial().equals(deviceId))
        .map(TestDevices::getPort)
        .findFirst()
        .orElseThrow(ExceptionSupplier.failedToInitializeTest("could not get device port"));
  }

  private String getDeviceName(DevicesItem device) {
    return device.platform().equalsIgnoreCase(IOS.name()) ? device.model() : device.marketName();
  }

  private List<DevicesItem> getAvailableListOfDeviceForSuite(
      String suiteName, AllDevices allDevices) {
    return allDevices.devices().stream()
        .filter(DevicesItem::ready)
        .filter(DevicesItem::present)
        .filter(devicesItem -> !devicesItem.using())
        .filter(devicesItem -> devicesItem.platform().equalsIgnoreCase(suiteName))
        .collect(Collectors.toList());
  }
}
