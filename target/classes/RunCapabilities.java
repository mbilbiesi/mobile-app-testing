package com.hungerstation.util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RunCapabilities {

    protected static AppiumDriverLocalService service;
    private AndroidDriver<AndroidElement> driver;

    //Following method to make Appium server run automatically
    protected AppiumDriverLocalService startServer(){

        boolean isServerRunning;

        isServerRunning = checkIfServerIsRunning(7234);

        if(!isServerRunning){
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }

        return service;
    }

    //
    private static boolean checkIfServerIsRunning(int port){
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e){//If it comes to here, this means that the server is already running
            isServerRunning = true;
        }

        return isServerRunning;
    }

    private static void startEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir") +
                "\\src\\test\\resources\\startEmulator.bat");
        Thread.sleep(6000);
    }

    protected static AndroidDriver<MobileElement> capabilities(String appInfo) throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                "\\src\\test\\resources\\global.properties");
        Properties properties = new Properties();
        properties.load(fis);

        //String device = (String) properties.get("device");
        String device = System.getProperty("deviceName"); //We get the device name from a runtime variable

        File app;
        File appDir = new File(System.getProperty("user.dir") +"\\src\\test\\resources\\apps");
        app = new File(appDir, (String) properties.get(appInfo));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(device.toLowerCase().contains("emulator")){
            startEmulator();
        }
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);

        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);

        AndroidDriver<MobileElement> androidDriver =
                new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return androidDriver;

    }

    void getScreenshot(String testName) throws IOException {
        File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+
                "\\src\\test\\resources\\screenshots\\"+testName+".png"));
    }
}
