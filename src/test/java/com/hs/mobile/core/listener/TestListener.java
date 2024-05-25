package com.hs.mobile.core.listener;

import com.hs.mobile.tests.Base;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.RandomStringUtils;
import org.imgscalr.Scalr;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.logging.LogEntry;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;

@Slf4j
public class TestListener implements ITestListener {
  private boolean attachLogs;
  private boolean attachLogsOnFailure;

  @Override
  public void onTestStart(ITestResult iTestResult) {
    if (iTestResult.getInstance() instanceof Base) {
      Base baseTest = ((Base) iTestResult.getInstance());
      attachLogs = baseTest.getTestProperties().isAttachLog();
      attachLogsOnFailure = baseTest.getTestProperties().isAttachLogsOnlyOnFailure();

      if (attachLogs) {
        //((Base) iTestResult.getInstance()).getLogsCollector().startCollectingPhoneLogs();
      }
    }
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {
    if (iTestResult.getInstance() instanceof Base) {
      attachScreenshotToTestReport(iTestResult);

      if (attachLogs && !attachLogsOnFailure) {
        attachLogs(iTestResult);
      }
    }
  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    if (iTestResult.getInstance() instanceof Base) {
      attachScreenshotToTestReport(iTestResult);

      if (attachLogs) {
        attachLogs(iTestResult);
      }
    }
  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {}

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

  @Override
  public void onStart(ITestContext iTestContext) {}

  @Override
  public void onFinish(ITestContext iTestContext) {}

  private String composeTestName(ITestResult iTestResult) {
    StringBuilder completeFileName = new StringBuilder();

    completeFileName
        .append(iTestResult.getTestClass().getRealClass().getSimpleName())
        .append("_")
        .append(iTestResult.getName())
        .append("_")
        .append(RandomStringUtils.randomAlphanumeric(10));

    Object[] parameters = iTestResult.getParameters();
    for (Object parameter : parameters) {
      completeFileName.append("_");
      completeFileName.append(parameter);
    }

    return completeFileName.toString().replace(":", "-");
  }

  private void attachLogs(ITestResult iTestResult) {
    //LogsCollector logsCollector = ((Base) iTestResult.getInstance()).getLogsCollector();
    AppiumDriver<?> driver = ((Base) iTestResult.getInstance()).getDriver();

   // String phoneLogs = String.join(System.lineSeparator(), logsCollector.getCollectedPhoneLogs());
    String appiumServerLog = "";

    try {
      appiumServerLog =
          driver.manage().logs().get("server").getAll().stream()
              .map(LogEntry::toString)
              .collect(Collectors.joining(System.lineSeparator()));
    } catch (WebDriverException e) {
      log.error("Could not attach appium server logs", e);
    }
    Allure.addAttachment("AppiumServerLog", "text/plain", appiumServerLog, ".log");
    //Allure.addAttachment("PhoneLog", "text/plain", phoneLogs, ".log");
  }

  private void attachScreenshotToTestReport(ITestResult iTestResult) {
    String title = composeTestName(iTestResult);
    AppiumDriver<?> driver = ((Base) iTestResult.getInstance()).getDriver();

    try {
      Allure.addAttachment(
          title,
          "image/png",
          new ByteArrayInputStream(resizeImage(driver.getScreenshotAs(OutputType.BYTES))),
          ".png");
    } catch (Exception e) {
      log.info("There was an issue in resizing screenshot :", e);
    }
  }

  private byte[] resizeImage(byte[] imageInByte) throws Exception {
    InputStream inputStream = new ByteArrayInputStream(imageInByte);
    BufferedImage bufferedImageFromConvert = ImageIO.read(inputStream);

    BufferedImage bufferedImageResized = Scalr.resize(bufferedImageFromConvert, 1200);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ImageIO.write(bufferedImageResized, "png", outputStream);

    return outputStream.toByteArray();
  }
}
