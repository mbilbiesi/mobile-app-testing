package com.hs.mobile.screens.android;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class TicketScreen extends AbstractScreen {

  @AssertElementVisibility
  @AndroidFindBy(className = "android.widget.ImageButton")
  private WebElement btnBack;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_title")
  private WebElement lblTicketTitle;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/ticket_description")
  private WebElement txaTicketDescription;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
  private List<WebElement> btnCreateTicket;

  public TicketScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
