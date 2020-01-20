package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class TicketScreen extends AbstractScreen {

    @AssertElementVisibility
    @iOSXCUITFindBy(className = "")
    @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement btnBack;

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_title")
    private WebElement lblTicketTitle;

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/ticket_description")
    private WebElement txaTicketDescription;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
    private List<WebElement> btnCreateTicket;

    public TicketScreen(AppiumDriver driver) {
        super(driver);
    }
}
