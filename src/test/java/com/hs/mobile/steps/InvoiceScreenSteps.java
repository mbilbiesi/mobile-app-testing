package com.hs.mobile.steps;

import com.hs.mobile.screens.InvoiceScreen;
import io.appium.java_client.AppiumDriver;

import static com.hs.mobile.data.ElementAttribute.TEXT;

public class InvoiceScreenSteps extends BaseSteps {
  private InvoiceScreen invoiceScreen;

  public InvoiceScreenSteps(AppiumDriver driver) {
    super(driver);
    invoiceScreen = new InvoiceScreen(driver);
  }

  public String getInvoiceTitle() {
    return getElementAttributeValue(invoiceScreen.getLblTitle(), TEXT);
  }

  public Boolean isDownloadButtonActive() {
    return isElementActive(invoiceScreen.getBtnDownload());
  }

  public Boolean isBackButtonActive() {
    return isElementActive(invoiceScreen.getBtnBack());
  }
}
