package com.hungerstation.test;

import com.hungerstation.util.RunCapabilities;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Demo extends RunCapabilities {
    public static void main(String[] args) throws IOException {
        AndroidDriver driver = capabilities("hsApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
