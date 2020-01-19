package com.hs.mobile.core.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;

public abstract class AppiumServer {
    public static final int APPIUM_PORT = 4723; // todo: generate random available port
    protected static final Logger LOG = LoggerFactory.getLogger(AppiumServer.class);
    private static final String LOCAL_IP_ADDRESS = "127.0.0.1";
    private static AppiumDriverLocalService service;
    private static AppiumServiceBuilder builder;
    private static DesiredCapabilities capabilities;

    public static void startServer() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("noReset", "false");

        builder = new AppiumServiceBuilder();
        builder.withIPAddress(LOCAL_IP_ADDRESS);
        builder.usingPort(APPIUM_PORT);
        builder.withCapabilities(capabilities);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public static void stopServer() {
        service.stop();
    }

    public static boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static String getAppiumServerUrl() {
        return service.getUrl().toString();
    }
}
