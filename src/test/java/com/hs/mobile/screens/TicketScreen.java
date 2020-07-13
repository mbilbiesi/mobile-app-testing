package com.hs.mobile.screens;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

@Getter
public class TicketScreen extends AbstractScreen {

  @AssertElementVisibility
  @iOSXCUITFindBy(id = "Back") // todo:ChangeArabicId
  @AndroidFindBy(className = "android.widget.ImageButton")
  private WebElement btnBack;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_title")
  private WebElement lblTicketTitle;

  @AssertElementVisibility
  // @iOSXCUITFindBy(id = "test") //todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/ticket_description")
  private WebElement txaTicketDescription;

  // @iOSXCUITFindBy(id = "test") todo:id
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
  private List<WebElement> btnCreateTicket;

  public TicketScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
