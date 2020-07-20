package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class HelpScreen extends AbstractScreen {

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_title")
  private WebElement lblTicketsMainTitle;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/btn_my_tickets")
  private WebElement btnMyTickets;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/expandable_tickets_list")
  private WebElement eleTicketsList;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txtname")
  private List<WebElement> lblTicketCategory;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/child_ticket_txt")
  private List<WebElement> eleTicket;

  @AndroidFindBy(className = "android.widget.ImageButton")
  private WebElement btnBack;

  public HelpScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
