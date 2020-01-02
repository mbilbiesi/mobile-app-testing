package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class HelpScreen extends AbstractScreen {

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_title")
    private WebElement ticketsMainTitle;

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_my_tickets")
    private WebElement myTicketsButton;

    @AssertElementVisibility
    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/expandable_tickets_list")
    private WebElement ticketsList;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txtname")
    private List<WebElement> ticketCategory;

    @iOSXCUITFindBy(id = "")
    @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/child_ticket_txt")
    private List<WebElement> ticket;

    @iOSXCUITFindBy(className = "")
    @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement btnBack;

    public HelpScreen(AppiumDriver driver) {
        super(driver);
    }
}
