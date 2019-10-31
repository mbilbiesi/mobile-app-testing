package com.hungerstation.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends RunCapabilities implements ITestListener {
    @Override
    public void onTestStart(ITestResult result){

    }

    @Override
    public void onTestSuccess(ITestResult result){

    }

    @Override
    public void onTestFailure(ITestResult result){

        String testName = result.getName();
        try {
            getScreenshot(testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){

    }

}
