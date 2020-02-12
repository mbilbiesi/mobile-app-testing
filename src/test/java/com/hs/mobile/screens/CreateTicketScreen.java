package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class CreateTicketScreen extends AbstractScreen {

    @AssertElementVisibility
    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_close")
    private WebElement btnCancel;

    @AssertElementVisibility
    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_title")
    private WebElement txtTicketTitle;

    @AssertElementVisibility
    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/create_ticket_disc")
    private WebElement txtTicketDescription;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
    private List<WebElement> btnSend;

    //@iOSXCUITFindBy(className = "test")
    @AndroidFindBy(className = "android.widget.Toast")
    private List<WebElement> toastMessage;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/snackbar_text")
    private List<WebElement> supportText;

    //@iOSXCUITFindBy(id = "test")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/snackbar_action")
    private List<WebElement> supportButton;

    public CreateTicketScreen(AppiumDriver driver) {
        super(driver);
    }
}
