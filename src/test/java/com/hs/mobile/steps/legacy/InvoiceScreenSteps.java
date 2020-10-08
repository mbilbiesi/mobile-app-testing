package com.hs.mobile.steps.legacy;

import static com.hs.mobile.data.ElementAttribute.TEXT;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.android.InvoiceScreen;
import com.hs.mobile.steps.BaseSteps;
import lombok.NonNull;

public class InvoiceScreenSteps extends BaseSteps {

  @NonNull private final InvoiceScreen invoiceScreen;

  public InvoiceScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    invoiceScreen = new InvoiceScreen(settings);
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
