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
  // @iOSXCUITFindBy(id = "test") todo:id
  // ELEMENT DOESN'T EXIST IN IOS APP, A SIMILAR ELEMENT EXIST FOR THE SAME PURPOSE "I need help"
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_title")
  private WebElement lblTicketsMainTitle;

  @AssertElementVisibility
  @iOSXCUITFindBy(id = "Mt Tickets")  //todo:ChangeArabicId
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_my_tickets")
  private WebElement btnMyTickets;

  @AssertElementVisibility
  @iOSXCUITFindBy(id = "Empty list")  //todo:ChangeArabicId
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/expandable_tickets_list")
  private WebElement eleTicketsList;

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txtname")
  private List<WebElement> lblTicketCategory;

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/child_ticket_txt")
  private List<WebElement> eleTicket;

  @iOSXCUITFindBy(className = "Back") //todo:ChangeArabicId
  @AndroidFindBy(className = "android.widget.ImageButton")
  private WebElement btnBack;

  public HelpScreen(AppiumDriver driver) {
    super(driver);
  }
}
