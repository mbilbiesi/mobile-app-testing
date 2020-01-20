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
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HelpSteps extends HelpScreen {

    public HelpSteps(AppiumDriver driver) {
        super(driver);
    }

    private void waitUntilHelpScreenLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(getEleTicketsList()));
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
        return getLblTicketCategory().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Verify that each tickets category contains the right ticket types")
    public void verifyEachTicketCategoryContainCorrectTicketType() {
        SoftAssertions soft = new SoftAssertions();
        int ticketCategoriesCount = getLblTicketCategory().size();
        String category;
        List<String> expectedTickets = new ArrayList<>();
        List<String> actualTickets = new ArrayList<>();

        for (int i = 0; i < ticketCategoriesCount; i++) {
            category = getLblTicketCategory().get(i).getText();
            tap(getLblTicketCategory().get(i));
            expectedTickets = getExpectedTicketsPerCategory(category);
            actualTickets = getActualTicketsPerCategory(getEleTicket());
            soft.assertThat(getEleTicket().size() > 0)
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
        return ticketType.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Click on a ticket")
    public void navigateToTicket(boolean ticketRequiresDescription) {
        if (!ticketRequiresDescription) {
            tapRandomCategory();
            tapRandomTicket();
        } else {
            tap(getLblTicketCategory().get(1));
            tap(getEleTicket().get(0));
        }
    }

    private void tapRandomCategory() {
        int randomCategoryIndex = getRandomIndex(getLblTicketCategory());
        tap(getLblTicketCategory().get(randomCategoryIndex));
    }

    private void tapRandomTicket() {
        int randomTicketIndex = getRandomIndex(getEleTicket());
        tap(getEleTicket().get(randomTicketIndex));
    }

    private int getRandomIndex(List<WebElement> tickets) {
        return RandomUtils.nextInt(0, tickets.size());
    }

    public void navigateBackToOrder() {
        tap(getBtnBack());
    }
}
