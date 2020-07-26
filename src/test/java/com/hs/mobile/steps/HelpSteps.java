package com.hs.mobile.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.HelpScreen;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HelpSteps extends BaseSteps {

  @NonNull private final HelpScreen helpScreen;

  public HelpSteps(@NonNull TestSettings settings) {
    super(settings);
    helpScreen = new HelpScreen(settings);
  }

  private void waitUntilHelpScreenLoaded() {
    wait.until(ExpectedConditions.visibilityOfAllElements(helpScreen.getEleTicketsList()));
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
    return helpScreen.getLblTicketCategory().stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  @Step("Verify that each tickets category contains the right ticket types")
  public void verifyEachTicketCategoryContainCorrectTicketType() {
    SoftAssertions soft = new SoftAssertions();
    int ticketCategoriesCount = helpScreen.getLblTicketCategory().size();
    String category;
    List<String> expectedTickets;
    List<String> actualTickets;

    for (int i = 0; i < ticketCategoriesCount; i++) {
      category = helpScreen.getLblTicketCategory().get(i).getText();
      tap(helpScreen.getLblTicketCategory().get(i));
      expectedTickets = getExpectedTicketsPerCategory(category);
      actualTickets = getActualTicketsPerCategory(helpScreen.getEleTicket());
      soft.assertThat(helpScreen.getEleTicket().size() > 0)
          .as("No tickets exist for the category: " + category)
          .isTrue();
      soft.assertThat(expectedTickets.equals(actualTickets))
          .as("Tickets related to the '" + category + "' category are not correct")
          .isTrue();
    }
    soft.assertAll();
  }

  @Step("Click on a ticket")
  public void navigateToTicket(boolean ticketRequiresDescription) {
    if (!ticketRequiresDescription) {
      tapRandomCategory();
      tapRandomTicket();
    } else {
      tap(helpScreen.getLblTicketCategory().get(1));
      tap(helpScreen.getEleTicket().get(0));
    }
  }

  private List<String> getExpectedTicketsPerCategory(String category) {
    List<String> expectedCategories = new ArrayList<>();
    category = category.toLowerCase();
    switch (category) {
      case "الدفع":
        expectedCategories = List.of("الفاتورة في التطبيق غير مطابقة لفاتورة المطعم");
        break;
      case "The Payment":
        expectedCategories = List.of("I've received a different bill amount than the app's");
        break;
      case "الموظف":
        expectedCategories = List.of("ملاحظة على موظف المطعم");
        break;
      case "The Staff":
        expectedCategories = List.of("I have a comment on the restaurant's staff");
        break;
        // ToDo: To add more data cases regarding the rest of ticket types.
    }

    return expectedCategories;
  }

  private List<String> getActualTicketsPerCategory(List<WebElement> ticketType) {
    return ticketType.stream().map(WebElement::getText).collect(Collectors.toList());
  }

  private void tapRandomCategory() {
    int randomCategoryIndex = getRandomIndex(helpScreen.getLblTicketCategory());
    tap(helpScreen.getLblTicketCategory().get(randomCategoryIndex));
  }

  private void tapRandomTicket() {
    int randomTicketIndex = getRandomIndex(helpScreen.getEleTicket());
    tap(helpScreen.getEleTicket().get(randomTicketIndex));
  }

  private int getRandomIndex(List<WebElement> tickets) {
    return RandomUtils.nextInt(0, tickets.size());
  }

  public void navigateBackToOrder() {
    tap(helpScreen.getBtnBack());
  }
}
