package com.hs.mobile.steps;

import com.hs.mobile.screens.HelpScreen;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HelpSteps extends HelpScreen {

    public HelpSteps(AppiumDriver driver) {
        super(driver);
    }

    private void waitUntilHelpScreenLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getTicketsList()));
    }

    @Step("Verify that all 'Help' screen elements are displayed")
    public void verifyHelpElementsDisplayed() {
        waitUntilHelpScreenLoaded();
        verifyScreenElements();
    }

    @Step("Verify that different ticket categories are displayed to the customer")
    public void verifyThatTicketCategoriesAreDisplayed(String orderStatus) {
        List<String> expectedTicketTypes = getExpectedTicketCategories(orderStatus);
        List<String> actualTicketTypes = getActualTicketCategories();

        assertThat(expectedTicketTypes.equals(actualTicketTypes))
                .as("Ticket types are not displayed correctly for this order")
                .isTrue();
    }

    private List<String> getExpectedTicketCategories(String orderStatus) {
        // ToDo change this method to prepare the expected ticket types
        // based on the different business logic for tickets
        List<String> expectedTickets;

        switch (orderStatus) {
            case "delivered":
                expectedTickets = Arrays.asList("الدفع", "الموظف");
                break;
            case "processing":
                expectedTickets = Arrays.asList("الطلب", "الدفع", "التوصيل", "الموظف");
                break;
            case "cancelled":
                expectedTickets = Arrays.asList("الطلب");
                break;
            default:
                expectedTickets = Arrays.asList("فتح تذكرة");
        }

        return expectedTickets;
    }

    private List<String> getActualTicketCategories() {
        List<String> actualTickets = new ArrayList<>();
        int ticketsCount = getTicketCategory().size();

        for (int i = 0; i < ticketsCount; i++) {
            actualTickets.add(getTicketCategory().get(i).getText());
        }

        return actualTickets;
    }

    @Step("Verify that each tickets category contains the right ticket types")
    public void verifyEachTicketCategoryContainCorrectTicketType() {
        SoftAssertions soft = new SoftAssertions();
        int ticketCategoriesCount = getTicketCategory().size();
        String category;
        List<String> expectedTickets = new ArrayList<>();
        List<String> actualTickets = new ArrayList<>();

        for (int i = 0; i < ticketCategoriesCount; i++) {
            category = getTicketCategory().get(i).getText();
            tap(getTicketCategory().get(i));
            expectedTickets = getExpectedTicketsPerCategory(category);
            actualTickets = getActualTicketsPerCategory(getTicket());
            soft.assertThat(getTicket().size() > 0)
                    .as("No tickets exist for the category: " + category)
                    .isTrue();
            soft.assertThat(expectedTickets.equals(actualTickets))
                    .as("Tickets related to the '" + category + "' category are not correct")
                    .isTrue();
        }
        soft.assertAll();
    }

    private List<String> getExpectedTicketsPerCategory(String category) {
        List<String> expectedCategories = new ArrayList<>();
        category = category.toLowerCase();
        switch (category) {
            case "الدفع":
                expectedCategories = Arrays.asList("الفاتورة في التطبيق غير مطابقة لفاتورة المطعم");
                break;
            case "The Payment":
                expectedCategories = Arrays.asList("I've received a different bill amount than the app's");
                break;
            case "الموظف":
                expectedCategories = Arrays.asList("ملاحظة على موظف المطعم");
                break;
            case "The Staff":
                expectedCategories = Arrays.asList("I have a comment on the restaurant's staff");
                break;
            // ToDo: To add more data cases regarding the rest of ticket types.
        }

        return expectedCategories;
    }

    private List<String> getActualTicketsPerCategory(List<WebElement> ticketType) {
        int ticketsCount = ticketType.size();
        List<String> actualTickets = new ArrayList<>();
        for (int i = 0; i < ticketsCount; i++) {
            actualTickets.add(ticketType.get(i).getText());
        }

        return actualTickets;
    }

    @Step("Click on a ticket")
    public void navigateToTicket(boolean ticketRequiresDescription) {
        if (!ticketRequiresDescription) {
            tapRandomCategory();
            tapRandomTicket();
        } else {
            tap(getTicketCategory().get(1));
            tap(getTicket().get(0));
        }
    }

    private void tapRandomCategory() {
        int randomCategoryIndex = getRandomIndex(getTicketCategory());
        tap(getTicketCategory().get(randomCategoryIndex));
    }

    private void tapRandomTicket() {
        int randomTicketIndex = getRandomIndex(getTicket());
        tap(getTicket().get(randomTicketIndex));
    }

    private int getRandomIndex(List<WebElement> tickets) {
        return RandomUtils.nextInt(0, tickets.size());
    }

    public void navigateBackToOrder() {
        tap(getBtnBack());
    }
}
