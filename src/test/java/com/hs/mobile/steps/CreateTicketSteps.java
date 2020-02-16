package com.hs.mobile.steps;

import com.hs.mobile.screens.CreateTicketScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CreateTicketSteps extends BaseSteps {
  private CreateTicketScreen createTicketScreen;

  public CreateTicketSteps(AppiumDriver driver) {
    super(driver);
    createTicketScreen = new CreateTicketScreen(driver);
  }

  @Step("Verify that all 'Create Ticket' screen elements are showing correctly")
  public void verifyCreateTicketScreenLayout() {
    SoftAssertions soft = new SoftAssertions();

    waitUntilCreateTicketScreenLoaded();

    soft.assertThat(createTicketScreen.getBtnSend().size() > 0)
        .as("'Send' button doesn't exist")
        .isTrue();
    verifyScreenElements();
    soft.assertAll();
  }

  @Step("Click 'Send' button")
  public void clickSendTicket() {
    hideKeyboard();
    tap(createTicketScreen.getBtnSend().get(0));
  }

  @Step("Verify that customer isn't able to create a ticket without adding description")
  public void verifyNoDescriptionErrorMessage() {
    List<WebElement> errorMessage = createTicketScreen.getToastMessage();

    SoftAssertions soft = new SoftAssertions();

    soft.assertThat(createTicketScreen.getTxtTicketDescription().isDisplayed())
        .as("Ticket has been created even though no description was entered")
        .isTrue();
    soft.assertThat(errorMessage.size() > 0)
        .as(
            "No error message is displayed after trying to "
                + "create a ticket without a description")
        .isTrue();
    soft.assertThat(errorMessage.get(0).getText().equalsIgnoreCase("['اكتب لنا تفاصيل ملاحظتك']"))
        .as("Description error message isn't correct")
        .isTrue();
    soft.assertAll();
  }

  @Step("Verify that ticket has been created successfully")
  public boolean verifyTicketHasBeenCreated() {
    boolean ticketCreated = createTicketScreen.getSupportText().size() > 0;
    SoftAssertions soft = new SoftAssertions();

    if (createTicketScreen.getSupportText().size() > 0) {
      soft.assertThat(
              createTicketScreen
                  .getSupportText()
                  .get(0)
                  .getText()
                  .equalsIgnoreCase("لتتمكن من متابعة التذكرة قم بالضغط على الدعم"))
          .as("Ticket created confirmation message isn't displayed correctiy")
          .isTrue();
    } else {
      soft.assertThat(ticketCreated).as("Ticket has not been created").isTrue();
    }

    soft.assertAll();

    return ticketCreated;
  }

  public void waitUntilCreateTicketScreenLoaded() {
    wait.until(ExpectedConditions.visibilityOfAllElements(createTicketScreen.getTxtTicketTitle()));
  }

  public void cancelTicketCreation() {
    tap(createTicketScreen.getBtnCancel());
  }
}
