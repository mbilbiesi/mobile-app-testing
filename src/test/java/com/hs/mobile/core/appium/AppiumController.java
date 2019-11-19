package com.hs.mobile.core.appium;

public class AppiumController extends AppiumServer {
   /* private static final Logger LOG = LoggerFactory.getLogger(AppiumController.class);
    private static final String ANDROID_FILE_PATH = Resources.getResource("apps/hs-app.apk").getPath();
    private static final String APPIUM_URL = "http://localhost:4723/wd/hub";

    protected static AppiumDriver driver;
    protected static TouchAction touchAction;
    private static DesiredCapabilities capabilities;

    protected static OperatingSystem platform;
    protected static String udid;
    protected static String automationName;

    public enum OperatingSystem {
        ANDROID,
        IOS
    }

    public static void startAppium() {
        switch (platform) {
            case IOS:
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", platform.toString());
                capabilities.setCapability("automationName", automationName);
                try {
                    driver = new IOSDriver<MobileElement>(new URL(APPIUM_URL), capabilities);
                } catch (Exception e) {
                    LOG.error("unable to initiate iOS driver", e);
                }
                break;

            case ANDROID:
                capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Nexus API 29");
                capabilities.setCapability(MobileCapabilityType.UDID, udid);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                capabilities.setCapability(MobileCapabilityType.APP, ANDROID_FILE_PATH);
                capabilities.setCapability("autoGrantPermissions", true);
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

                try {
                    driver = new AndroidDriver<MobileElement>(new URL(APPIUM_URL), capabilities);
                } catch (Exception e) {
                    LOG.error("unable to initiate Android driver", e);
                }
                break;
        }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void stopAppium() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                LOG.error("unable to stop appium", e);
            }
        }
    }*/
}
