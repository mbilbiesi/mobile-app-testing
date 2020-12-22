package com.hs.mobile.core.listener;

import static org.openqa.selenium.Platform.IOS;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.hs.mobile.conf.ServicesModule;
import com.hs.mobile.service.devices.DevicesClient;
import com.hs.mobile.service.devices.model.AllDevices;
import com.hs.mobile.service.devices.model.DevicesItem;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class SuiteLabListener implements IAlterSuiteListener {
  private static final AtomicInteger androidPort = new AtomicInteger(8200);
  private static final AtomicInteger iOSPort = new AtomicInteger(8100);
  @Inject DevicesClient devicesClient;

  @Override
  public void alter(List<XmlSuite> suites) {
    Guice.createInjector(new ServicesModule()).injectMembers(this);
    var devices = devicesClient.getAllDevicesInfo().getAllDevices();

    var xmlSuite = suites.get(0);
    var availableListOfDeviceForSuite =
        getAvailableListOfDeviceForSuite(xmlSuite.getName(), devices);
    assignAvailableDevicesToUser(availableListOfDeviceForSuite);

    List<XmlTest> testList =
        availableListOfDeviceForSuite.stream()
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
        getPort(device.platform()),
        "assignedTestUserId",
        "1",
        "deviceName",
        getDeviceName(device));
  }

  private String getDeviceName(DevicesItem device) {
    return device.platform().equalsIgnoreCase(IOS.name()) ? device.model() : device.marketName();
  }

  private List<DevicesItem> getAvailableListOfDeviceForSuite(
      String suiteName, AllDevices allDevices) {
    return allDevices.devices().stream()
        .filter(DevicesItem::ready)
        .filter(devicesItem -> !devicesItem.using())
        .filter(devicesItem -> devicesItem.platform().equalsIgnoreCase(suiteName))
        .collect(Collectors.toList());
  }

  private String getPort(String platform) {
    return platform.equalsIgnoreCase(IOS.name())
        ? String.valueOf(iOSPort.getAndIncrement())
        : String.valueOf(androidPort.getAndIncrement());
  }
}
