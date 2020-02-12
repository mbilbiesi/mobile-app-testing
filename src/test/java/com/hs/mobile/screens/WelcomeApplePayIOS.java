package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public abstract class WelcomeApplePayIOS extends AbstractScreen {

    @iOSXCUITFindBy(iOSClassChain = "XCUIElementTypeWindow/*/*/*/XCUIElementTypeButton[1]")
    @AssertElementVisibility
    private MobileElement btnProceedWithApplePay;

    @iOSXCUITFindBy(iOSClassChain = "XCUIElementTypeWindow/*/*/*/XCUIElementTypeButton[2]")
    @AssertElementVisibility
    private MobileElement btnSkipApplePay;

    public WelcomeApplePayIOS(AppiumDriver driver) {
        super(driver);
    }
}
