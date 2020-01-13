package com.hs.mobile.steps;

import com.hs.mobile.exception.TestExecutionException;
import com.hs.mobile.screens.TicketScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketSteps extends TicketScreen {

    public TicketSteps(AppiumDriver driver) {
        super(driver);
    }

    @Step("Verify that all ticket screen objects are displayed correctly")
    public void verifyTicketScreenLayout(boolean ticketCreated) {
        SoftAssertions soft = new SoftAssertions();
        waitUntilTicketScreenLoaded();
        if (!ticketCreated) {
            soft.assertThat(getBtnCreateTicket().size() > 0)
                    .as("'Create Ticket' button doesn't exist")
                    .isTrue();
            verifyScreenElements();
            soft.assertAll();
        } else {
            try {
                soft.assertThat(getTicketDescription().isDisplayed())
                        .as("No description is showing up for the ticket")
                        .isTrue();
                soft.assertThat(
                        getTicketDescription()
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
            tap(getBtnCreateTicket().get(0));
        } catch (TestExecutionException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilTicketScreenLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getTicketTitle()));
    }

    public void navigateBackToHelp() {
        tap(getBtnBack());
    }
}
