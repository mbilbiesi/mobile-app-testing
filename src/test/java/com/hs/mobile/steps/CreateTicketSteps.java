package com.hs.mobile.steps;

import com.hs.mobile.screens.CreateTicketScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTicketSteps extends CreateTicketScreen {

    public CreateTicketSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Verify that all 'Create Ticket' screen elements are showing correctly")
    public void verifyCreateTicketScreenLayout() {
        SoftAssertions soft = new SoftAssertions();

        waitUntilCreateTicketScreenLoaded();

        soft.assertThat(getBtnSend().size() > 0).as("'Send' button doesn't exist").isTrue();
        verifyScreenElements();
        soft.assertAll();
    }

    @Step("Click 'Send' button")
    public void clickSendTicket() {
        tap(getBtnSend().get(0));
    }

    @Step("Verify that customer isn't able to create a ticket without adding description")
    public void verifyNoDescriptionErrorMessage() {
        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(getTicketDescription().isDisplayed())
                .as("Ticket has been created even though no description was entered")
                .isTrue();
        soft.assertThat(getToastMessage().size() > 0)
                .as(
                        "No error message is displayed after trying to "
                                + "create a ticket without a description")
                .isTrue();
        soft.assertThat(
                getToastMessage().get(0).getText().equalsIgnoreCase("['اكتب لنا تفاصيل ملاحظتك']"))
                .as("Description error message isn't correct")
                .isTrue();
        soft.assertAll();
    }

    @Step("Verify that ticket has been created successfully")
    public boolean verifyTicketHasBeenCreated() {
        boolean ticketCreated = getToastMessage().size() > 0;
        SoftAssertions soft = new SoftAssertions();

        if (getToastMessage().size() > 0) {
            soft.assertThat(getToastMessage().get(0).getText().equalsIgnoreCase("تم"))
                    .as("Ticket created confirmation message isn't displayed correctiy")
                    .isTrue();
        } else {
            soft.assertThat(ticketCreated).as("Ticket has not been created").isTrue();
        }

        soft.assertAll();

        return ticketCreated;
    }

    public void waitUntilCreateTicketScreenLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getTicketTitle()));
    }

    public void cancelTicketCreation() {
        tap(getBtnCancel());
    }
}
