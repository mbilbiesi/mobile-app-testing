package com.hs.mobile.core.appium;

import com.google.common.io.Resources;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppiumController extends AppiumServer {
    protected static final Logger LOG = LoggerFactory.getLogger(AppiumController.class);
    private static final String ANDROID_FILE_PATH = Resources.getResource("apps/hs-app.apk").getPath();

    protected AppiumDriver driver;
    protected WebDriverWait wait;
    private DesiredCapabilities capabilities;

    //deviceConnect Information
    public static String username;
    public static String apiToken;

    //Device Lists
    public static List<Object[]> deviceList;

    //Per Test Capabilities
    public OperatingSystem platform;
    public String udid;
    public String automationName;
    public String bundleID;

    public enum OperatingSystem {
        ANDROID,
        IOS
    }

    public void startAppium() {
        // switch (platform){
        //    case IOS:
                /*capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", platform.toString());
                capabilities.setCapability("bundleID", bundleID);
                capabilities.setCapability("automationName", automationName);
                driver = new IOSDriver<MobileElement>(new URL(server), capabilities);
                break;*/

        // case ANDROID:
        try {
            /*capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "NotUsed");
            capabilities.setCapability("app", ANDROID_FILE_PATH);
            capabilities.setCapability("appPackage", "com.jayway.contacts");
            capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/

            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
            capabilities.setCapability(MobileCapabilityType.APP, ANDROID_FILE_PATH);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
            capabilities.setCapability("name", method.getName());

            driver = new AndroidDriver<MobileElement>(new URL(getAppiumServerUrl()), capabilities);
        } catch (Exception e) {
            LOG.error("unable to start android", e);
        }
        //   break;
        // }

        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void stopAppium() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                LOG.error("unable to stop appium", e);
            }
        }
    }
}
