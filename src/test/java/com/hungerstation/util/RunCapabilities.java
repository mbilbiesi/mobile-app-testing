package com.hungerstation.util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RunCapabilities {

    public static AndroidDriver<MobileElement> capabilities(String appInfo) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                "\\src\\test\\resources\\global.properties");
        Properties properties = new Properties();
        properties.load(fis);

        String device = (String) properties.get("device");

        File app;
        File appDir = new File(System.getProperty("user.dir") +"\\src\\test\\resources\\apps");
        app = new File(appDir, (String) properties.get(appInfo));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);

        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);

        AndroidDriver<MobileElement> androidDriver =
                new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return androidDriver;

    }
}
