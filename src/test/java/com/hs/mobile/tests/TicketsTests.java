package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Epic("Smoke Tests")
@Feature("Tickets Tests")
@Story("Tickets types conditions")
@Listeners(TestListener.class)
public class TicketsTests extends BaseTest {

    boolean hasFirstTestExecuted = false;
    String currentScreen;
    String orderStatus = null;
    boolean hasTicketBeenCreated = false;

    @BeforeMethod
    public void beforeEachTest() {
        //Given
        if (!hasFirstTestExecuted) {
            homeScreenSteps.clickMyOrdersButton();
            myOrdersScreen.clickVerifyButton();
            verifyAccountScreenSteps.insertMobileNumber("503263813");
            verifyAccountScreenSteps.clickNextButton();
            pinCodeVerificationScreen.insertVerificationCode("395406");
            myOrdersSteps.waitUntilMyOrdersScreenLoaded();
        }
        hasFirstTestExecuted = true;
    }

    @Issue("HSAP-234")
    @Test(description = "Verify that all ticket categories related to an order are displayed")
    public void navigateToHelp_verifyTicketCategoriesExistForDeliveredOrder() {
        orderStatus = "delivered";
        myOrdersSteps.navigateToOrder(orderStatus);
        orderSteps.clickHelp();
        helpSteps.verifyHelpElementsDisplayed();
        helpSteps.verifyThatTicketCategoriesAreDisplayed(orderStatus);

        currentScreen = "Help";
    }

    @Issue("HSAP-235")
    @Test(description = "Verify that ticket types are displayed correctly for all ticket categories")
    public void navigateToHelp_verifyTicketTypesExistForEachCategory() {
        orderStatus = "delivered";
        myOrdersSteps.navigateToOrder(orderStatus);
        orderSteps.clickHelp();
        helpSteps.verifyEachTicketCategoryContainCorrectTicketType();

        currentScreen = "Help";
    }

    @Issue("HSAP-236")
    @Test(description = "Navigate to a ticket and verify that ticket screen displays correctly")
    public void navigateToTicket_verifyTicketScreenElements() {
        orderStatus = "delivered";
        myOrdersSteps.navigateToOrder(orderStatus);
        orderSteps.clickHelp();
        helpSteps.navigateToTicket(false);
        ticketSteps.verifyTicketScreenLayout(hasTicketBeenCreated);

        currentScreen = "Ticket";
    }

    @Issue("HSAP-237")
    @Test(description = "Click create a ticket, and verify that the create ticket screen displays correctly")
    public void clickCreateTicket_VerifyScreenElements() {
//        Assumptions.assumeThat(hasTicketBeenCreated)
//                .as("A ticket has been already created, therefore " +
//                        "customer won't be able to navigate to 'Create Ticket' screen").isTrue();
        //ToDo: If a ticket is already created, find another order or create a new order
        orderStatus = "delivered";
        myOrdersSteps.navigateToOrder(orderStatus);
        orderSteps.clickHelp();
        helpSteps.navigateToTicket(false);
        ticketSteps.clickCreateTicketButton();
        createTicketSteps.verifyCreateTicketScreenLayout();

        currentScreen = "Create Ticket";
    }

    @Issue("HSAP-238")
    @Test(enabled = false, description = "Create a ticket with no description")
    public void createTicketWithoutDescription_TicketShouldntBeCreated() {
        List<WebElement> errorMessage;
//        Test case will be disabled untill we find an appropriate way to identify toast messages
        //ToDo: If a ticket is already created, find another order or create a new order
        orderStatus = "delivered";

        //When
        myOrdersSteps.navigateToOrder(orderStatus);
        orderSteps.clickHelp();
        helpSteps.navigateToTicket(true);
        ticketSteps.clickCreateTicketButton();
        createTicketSteps.clickSendTicket();

        //Then
        createTicketSteps.verifyNoDescriptionErrorMessage();
    }

    @Issue("HSAP-238")
    @Test(description = "Create a ticket and verify it's created successfully")
    public void createTicket_TicketShouldBeCreatedSuccessfully() {
//        Assumptions.assumeThat(hasTicketBeenCreated)
//                .as("A ticket has been already created, therefore " +
//                        "customer won't be able to navigate to create a ticket").isTrue();
        //ToDo: If a ticket is already created, find another order or create a new order

        //When
        myOrdersSteps.navigateToOrder("in progress");
        orderSteps.clickHelp();
        helpSteps.navigateToTicket(false);
        ticketSteps.clickCreateTicketButton();
        createTicketSteps.clickSendTicket();

        //Then
        hasTicketBeenCreated = createTicketSteps.verifyTicketHasBeenCreated();
    }

    @AfterMethod
    public void navigateBackToMyOrders() {
        currentScreen = currentScreen.toLowerCase();

        switch (currentScreen) {
            case "create ticket":
                createTicketSteps.cancelTicketCreation();
                ticketSteps.navigateBackToHelp();
                helpSteps.navigateBackToOrder();
                orderSteps.navigateBackToAllOrders();
                break;
            case "ticket":
                ticketSteps.navigateBackToHelp();
                helpSteps.navigateBackToOrder();
                orderSteps.navigateBackToAllOrders();
                break;
            case "help":
                helpSteps.navigateBackToOrder();
                orderSteps.navigateBackToAllOrders();
                break;
            case "order":
                orderSteps.navigateBackToAllOrders();
                break;
        }
    }
}
