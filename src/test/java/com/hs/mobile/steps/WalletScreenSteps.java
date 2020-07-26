package com.hs.mobile.steps;

import static com.hs.mobile.data.ElementAttribute.TEXT;

import com.hs.mobile.core.settings.TestSettings;
import com.hs.mobile.screens.WalletScreen;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

public class WalletScreenSteps extends BaseSteps {

  @NonNull private final WalletScreen walletScreen;

  public WalletScreenSteps(@NonNull TestSettings settings) {
    super(settings);
    walletScreen = new WalletScreen(settings);
  }

  @Step("Verify that all headers are displayed properly")
  public void verifyHeaders() {
    List<WebElement> headers = getAllHeaders();
    SoftAssertions soft = new SoftAssertions();

    for (WebElement header : headers) {
      soft.assertThat(isHeaderActive(header))
          .as(String.format("%s header should be properly displayed.", getHeaderText(header)))
          .isTrue();
    }

    navigateBack(2);
    soft.assertAll();
  }

  private List<WebElement> getAllHeaders() {
    List<WebElement> headers = new ArrayList<>();
    headers.add(walletScreen.getTransactionHeader());
    headers.add(walletScreen.getDateHeader());
    headers.add(walletScreen.getExpiryDateHeader());
    headers.add(walletScreen.getAmountHeader());
    return headers;
  }

  private Boolean isHeaderActive(WebElement header) {
    return isElementActive(header);
  }

  private String getHeaderText(WebElement header) {
    return getElementAttributeValue(header, TEXT);
  }
}
