package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

@Getter
public class AddReferralCodeScreen extends AbstractScreen {

    @iOSXCUITFindBy(className = "")
    @AndroidFindBy(className = "android.widget.ImageButton")
    @AssertElementVisibility
    private MobileElement btnClose;

    @iOSXCUITFindBy(className = "")
    @AndroidFindBy(className = "android.widget.ImageView")
    @AssertElementVisibility
    private MobileElement imgReferralCode;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_code_label")
    @AssertElementVisibility
    private MobileElement lblReferralCode;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/edt_referral")
    @AssertElementVisibility
    private MobileElement txtReferralCode;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_verify")
    @AssertElementVisibility
    private MobileElement btnVerifyReferralCode;

    public AddReferralCodeScreen(AppiumDriver driver) {
        super(driver);
    }
}
