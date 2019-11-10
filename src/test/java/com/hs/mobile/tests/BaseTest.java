package com.hs.mobile.tests;

import com.hs.mobile.core.appium.AppiumController;
import com.hs.mobile.core.appium.AppiumServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    AppiumController appiumController = new AppiumController();

    @BeforeAll
    static void startAppiumServer() {
        AppiumServer.startServer();
    }

    @AfterAll
    static void stopAppiumServer() {
        AppiumServer.startServer();
    }

    @BeforeEach()
    void startAppium() {
        appiumController.startAppium();
    }

    @AfterEach
    void closeApp() {
        appiumController.stopAppium();
    }
}
