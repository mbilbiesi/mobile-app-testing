package com.hs.mobile.steps;

import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.TicketScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class TicketSteps extends BaseSteps {
    private TicketScreen ticketScreen;

    public TicketSteps(AppiumDriver driver) {
        super(driver);
        ticketScreen = new TicketScreen(driver);
    }

    @Step("Verify that all ticket screen objects are displayed correctly")
    public void verifyTicketScreenLayout(boolean ticketCreated) {
        SoftAssertions soft = new SoftAssertions();
        waitUntilTicketScreenLoaded();
        if (!ticketCreated) {
            soft.assertThat(ticketScreen.getBtnCreateTicket().size() > 0)
                    .as("'Create Ticket' button doesn't exist")
                    .isTrue();
            verifyScreenElements();
            soft.assertAll();
        } else {
            try {
                soft.assertThat(ticketScreen.getTxaTicketDescription().isDisplayed())
                        .as("No description is showing up for the ticket")
                        .isTrue();
                soft.assertThat(
                        ticketScreen
                                .getTxaTicketDescription()
                                .getText()
                                .equalsIgnoreCase("لديك تذكرة مفتوحة حاليّا متعلقة بهذا الطلب!"))
                        .as("description isn't correct in case user has already " + "created a ticket")
                        .isTrue();
                soft.assertAll();
            } catch (TestExecutionException e) {
                throw new TestExecutionException("Ticket description text box isn't found " + e);
            }
        }
    }

    @Step("Click 'Create Ticket' button")
    public void clickCreateTicketButton() {
        waitUntilTicketScreenLoaded();
        try {
            tap(ticketScreen.getBtnCreateTicket().get(0));
        } catch (Exception e) {
            log.error("Failed to create ticket : ", e);
        }
    }

    public void waitUntilTicketScreenLoaded() {
        wait.until(ExpectedConditions.visibilityOfAllElements(ticketScreen.getLblTicketTitle()));
    }

    public void navigateBackToHelp() {
        tap(ticketScreen.getBtnBack());
    }
}
