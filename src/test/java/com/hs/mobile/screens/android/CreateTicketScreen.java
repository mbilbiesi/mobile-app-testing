package com.hs.mobile.screens.android;

import com.hs.mobile.core.annotation.AssertElementVisibility;
import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.AbstractScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class CreateTicketScreen extends AbstractScreen {

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/menu_close")
  private WebElement btnCancel;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/txt_title")
  private WebElement txtTicketTitle;

  @AssertElementVisibility
  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/create_ticket_disc")
  private WebElement txtTicketDescription;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/parent_layout")
  private List<WebElement> btnSend;

  @AndroidFindBy(className = "android.widget.Toast")
  private List<WebElement> toastMessage;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/snackbar_text")
  private List<WebElement> supportText;

  @AndroidFindBy(id = "com.hungerstation.android.web.debug:id/snackbar_action")
  private List<WebElement> supportButton;

  public CreateTicketScreen(@NonNull TestSettings settings) {
    super(settings);
  }
}
