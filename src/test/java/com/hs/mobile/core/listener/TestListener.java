package com.hs.mobile.core.listener;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

public class TestListener implements ITestListener {
    private static final Logger LOG = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Class clazz = iTestResult.getTestClass().getRealClass();
        try {
            Field field = clazz.getSuperclass().getDeclaredField("driver");
            field.setAccessible(true);

            AppiumDriver<?> driver = (AppiumDriver<?>) field.get(iTestResult.getInstance());
            saveScreenshot(composeTestName(iTestResult), driver);
        } catch (NoSuchFieldException e) {
            LOG.error("Error while taking screenshot: ", e);
        } catch (IllegalAccessException e) {
            LOG.error("Error while taking screenshot: ", e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

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
    public byte[] saveScreenshot(String title, AppiumDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
