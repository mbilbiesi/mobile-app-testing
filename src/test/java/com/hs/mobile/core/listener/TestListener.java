package com.hs.mobile.core.listener;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import java.lang.reflect.Field;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestListener implements ITestListener {

  @Override
  public void onTestStart(ITestResult iTestResult) {}

  @Override
  public void onTestSuccess(ITestResult iTestResult) {}

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    Object clazz = iTestResult.getTestClass().getRealClass();
    try {
      Field field = clazz.getClass().getSuperclass().getDeclaredField("driver");
      field.setAccessible(true);

      AppiumDriver<?> driver = (AppiumDriver<?>) field.get(iTestResult.getInstance());
      saveScreenshot(composeTestName(iTestResult), driver);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      log.error("Error while taking screenshot: ", e);
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
    StringBuffer completeFileName = new StringBuffer();

    completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName());
    completeFileName.append("_");
    completeFileName.append(iTestResult.getName());

    Object[] parameters = iTestResult.getParameters();
    for (Object parameter : parameters) {
      completeFileName.append("_");
      completeFileName.append(parameter);
    }

    return completeFileName.toString().replace(":", "-");
  }

  @Attachment(value = "{title}", type = "image/png")
  private byte[] saveScreenshot(String title, AppiumDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
