package com.hs.mobile.tests;

import com.hs.mobile.core.listener.TestListener;
import com.hs.mobile.screens.InvoiceScreen;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Optional;

@Feature("Invoices Smoke Test")
@Story("Verify elements of the invoices screen ")
@Issue("HSAP-182")
@Listeners(TestListener.class)
public class InvoicesTests extends BaseTest {

  @BeforeMethod
  public void goToInvoices() {
    // When
    homeScreenSteps.clickOnMore().goToInvoices();
  }

  @Test(description = "Check invoices screen basic elements")
  public void navigateToInvoicesScreen_basicElementsAreProperlyDisplayed() {
    // Then
    verifyInvoicesScreen();
  }

  @Test(description = "Check invoices")
  public void navigateToInvoicesScreen_invoicesAreProperlyDisplayed() {
    // Then
    verifyInvoices();
  }

  @Step("Verify that basic invoices screen elements are displayed correctly")
  public void verifyInvoicesScreen() {
    SoftAssertions assertions = new SoftAssertions();
    String title = invoicesScreenSteps.getTitle();
    boolean isValidTitle = "الفواتير".equals(title) || "Invoices".equals(title);

    assertions.assertThat(isValidTitle).as(String.format("Invalid title: [%s]", title)).isTrue();
    assertions
            .assertThat(invoicesScreenSteps.isBackButtonActive())
            .as("Return button should be displayed and enabled.")
            .isTrue();
    driver.navigate().back();
    assertions.assertAll();
  }

  @Step("Verify that invoices are displayed correctly")
  public void verifyInvoices() {
    if (invoicesScreenSteps.areThereInvoices()) {
      verifyFirstAvailableInvoice();
    } else {
      verifyDisplayedMessage();
    }
  }

  @Step("Verify the first available invoice")
  public void verifyFirstAvailableInvoice() {
    Optional<InvoiceScreen> optionalFirstInvoice = invoicesScreenSteps.viewInvoice(0);
    if (optionalFirstInvoice.isEmpty()) {
      driver.navigate().back();
      throw new AssertionError("Unable to open the invoice to verify its components.");
    }

    SoftAssertions assertions = new SoftAssertions();
    InvoiceScreen invoiceScreen = optionalFirstInvoice.get();
    String title = invoiceScreen.getTitle();
    boolean isValidTitle = "تفاصيل الفاتورة".equals(title) || "Invoice details".equals(title);

    assertions.assertThat(isValidTitle).as(String.format("Invalid title: [%s]", title)).isTrue();
    assertions
            .assertThat(invoiceScreen.isDownloadButtonActive())
            .as("Download button should be active.")
            .isTrue();
    assertions
            .assertThat(invoiceScreen.isBackButtonActive())
            .as("Return button should be active.")
            .isTrue();
    driver.navigate().back();
    driver.navigate().back();
    assertions.assertAll();
  }

  @Step("Verify the displayed \"no invoices\" message")
  public void verifyDisplayedMessage() {
    String message = invoicesScreenSteps.getMessage();
    boolean isValidMessage =
            "لا يوجد لديك اي فاتورة حالياً".equals(message)
                    || "There are no invoices to be shown at the moment".equals(message);
    driver.navigate().back();
    Assertions.assertThat(isValidMessage)
            .as(String.format("Invalid message: [%s]", message))
            .isTrue();
  }
}